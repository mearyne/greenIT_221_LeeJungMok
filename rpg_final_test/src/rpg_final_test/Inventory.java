package rpg_final_test;

import java.util.Map;
import java.util.Set;

public class Inventory extends Stage {
	private UnitParty party = new UnitParty();

	private static final int EQUIP = 1;
	private static final int REMOVE = 2;
	private static final int DRINKPOTION = 3;

	public Map<Integer, Item> inventory = UnitPlayer.getInstance().getInventory();

	public Inventory() {
		super("인벤토리");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		while (true) {
			printMenu();
			int sel = selMenu();

			if (sel == QUIT)
				break;

		}
	}

	@Override
	public void init() {
	}

	public void printInventory() {
		Set<Integer> keys = this.inventory.keySet();
		System.out.println("========== 인벤토리 ==========");
		for (Integer key : keys) {
			System.out.printf("%d. %s\n", this.inventory.get(key).getItemCode(), this.inventory.get(key).getName());
		}
	}

	private void printMenu() {
		System.out.println("1. 장착");
		System.out.println("2. 해제");
		System.out.println("3. 포션먹기");
		System.out.println("0. 뒤로가기");
	}

	private int selMenu() {
		System.out.print("선택 :");
		int sel = GameManager.scan.nextInt();

		if (sel == EQUIP) {
			selEquip();

		} else if (sel == REMOVE) {
			selUnEquip();

		} else if (sel == DRINKPOTION) {
			int selItem = selItem();
			Item item = inventory.get(selItem);

			if (item.getType() == Item.POTION) {
				
			} else {
				System.out.println("선택한 아이템은 포션이 아닙니다");
			}

		}

		return sel;
	}

	private void selEquip() {
		printInventory();
		int selItem = selItem();

		if (selItem != QUIT) {
			party.printParty();
			int selParty = party.selParty();

			if (selParty != -1) {
				Item item = inventory.get(selItem);
				equipItem(selParty, item);

			}
		} else {
			System.out.println("일치하는 아이템이 없습니다");
		}
	}

	private void selUnEquip() {
		printInventory();
		int selItem = selItem();

		if (selItem != QUIT) {
			party.printParty();
			int selParty = party.selParty();

			if (selParty != -1) {
				int type = inventory.get(selItem).getType();

				unequipItem(type, selParty);

			}
		} else {
			System.out.println("일치하는 아이템이 없습니다");
		}

	}

	private void equipItem(int selParty, Item item) {
		// TODO Auto-generated method stub
		unequipItem(item.getType(), selParty);
		if (item.getType() == Item.WEAPON) {
			UnitParty.partys.get(selParty).setWeapon(new Item());

		} else if (item.getType() == Item.ARMOUR) {
			UnitParty.partys.get(selParty).setArmour(new Item());

		} else if (item.getType() == Item.RING) {

			UnitParty.partys.get(selParty).setRing(new Item());

		}

	}

	private void unequipItem(int type, int selParty) {
		// 선택한 파티원의 장비타입을 해제시킨다
		// 해제된 장비는 인벤토리로 이동한다
		if (type == Item.WEAPON) {
			Item item = UnitParty.partys.get(selParty).getWeapon();
			if (item.getName().equals("비어있음") == false) {
				inventory.put(item.getItemCode(), item);

			} else {

				UnitParty.partys.get(selParty).setWeapon(new Item());
			}

		} else if (type == Item.ARMOUR) {
			Item item = UnitParty.partys.get(selParty).getArmour();
			if (item.getName().equals("비어있음") == false)
				inventory.put(item.getItemCode(), item);

			UnitParty.partys.get(selParty).setArmour(new Item());

		} else if (type == Item.RING) {
			Item item = UnitParty.partys.get(selParty).getRing();
			if (item.getName().equals("비어있음") == false)
				inventory.put(item.getItemCode(), item);

			UnitParty.partys.get(selParty).setRing(new Item());

		}

	}

	private int selItem() {
		System.out.print("아이템 선택 :");
		int sel = GameManager.scan.nextInt();

		if (inventory.containsKey(sel))
			return sel;
		System.out.println("일치하는 아이템이 없습니다");
		return QUIT;
	}

}
