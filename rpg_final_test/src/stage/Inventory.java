package stage;

import java.util.Map;
import java.util.Set;

import item.Item;
import item.ItemDAO;
import item.ItemPotion;
import party.Unit;
import party.UnitParty;
import party.UnitPlayer;
import rpg_final_test.GameManager;

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
		Set<Integer> keys = inventory.keySet();
		System.out.println("========== 인벤토리 ==========");
		for (Integer key : keys) {
			System.out.printf("%d. %s\n", key, inventory.get(key).getName());
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
			Item item = inventory.get(selItem); // 포션 아이템 선택함

			if (item != null && item.getType() == Item.POTION) {
				party.printParty();
				int selParty = party.selParty();

				if (selParty == -1) {
					drinkpotion(item, selParty);
				}

			} else {
				System.out.println("선택한 아이템은 포션이 아닙니다");
			}

		}

		return sel;
	}

	private void drinkpotion(Item item, int selParty) {
		Unit party = UnitParty.partys.get(selParty);
		ItemPotion potion = (ItemPotion) item;

		int resultHp = party.getHp() + potion.getHealing();
		if (resultHp > party.getMaxHp())
			party.setHp(party.getMaxHp());
		party.setHp(resultHp);

	}

	private void selEquip() {
		printInventory();
		int selItem = selItem();

		if (selItem != QUIT) {
			party.printParty();
			int selParty = party.selParty();

			if (selParty != -1) {
				System.out.println(UnitParty.partys.get(selParty).getName() + "를 선택했습니다");
				Item item = ItemDAO.items.get(selItem);

				equipItem(selParty, item); // 이 아이템은 종합데이터베이스안에 있는 아이템이다

			}
		}
	}

	private void selUnEquip() {
		party.printParty();
		int selParty = party.selParty();

		if (selParty != -1) {
			// TODO 1.무기 2.방어구 3.링 출력
			System.out.println("해제할 부위 선택");
			System.out.println("1. 무기");
			System.out.println("2. 방어구");
			System.out.println("3. 링");

			// TODO 부위선택
			int sel = GameManager.scan.nextInt();
			Item wearingItem = new Item();

			if (sel == Item.WEAPON)
				wearingItem = UnitParty.partys.get(selParty).getWeapon();
			else if (sel == Item.ARMOUR)
				wearingItem = UnitParty.partys.get(selParty).getArmour();
			else if (sel == Item.RING)
				wearingItem = UnitParty.partys.get(selParty).getRing();

			if (wearingItem.getType() == 10000) {
				System.out.println("장착중인 아이템이 없습니다");
			} else {
				unequipItem(wearingItem.getItemCode(), selParty);

			}
		}

	}

	private void equipItem(int selParty, Item item) {
		unequipItem(item.getItemCode(), selParty); // 내가 끼고있는 장비 해제

		if (item.getType() == Item.WEAPON) {
			UnitParty.partys.get(selParty).setWeapon(item);

		} else if (item.getType() == Item.ARMOUR) {
			UnitParty.partys.get(selParty).setArmour(item);

		} else if (item.getType() == Item.RING) {
			UnitParty.partys.get(selParty).setRing(item);

		}
		inventory.remove(item.getItemCode());

	}

	private void unequipItem(int code, int selParty) { // code는 입고있는 장비의 코드이다
		// 선택한 파티원의 장비타입을 해제시킨다
		// 해제된 장비는 인벤토리로 이동한다
		Item item = ItemDAO.items.get(code);
		int type = item.getType();

		Item empty = new Item();

		if (type == Item.WEAPON) { // 무기를 장착중
			inventory.put(item.getItemCode(), item);
			UnitParty.partys.get(selParty).setWeapon(empty);

		} else if (type == Item.ARMOUR) { // 아머를 장착중
			inventory.put(item.getItemCode(), item);
			UnitParty.partys.get(selParty).setArmour(empty);

		} else if (type == Item.RING) { // 링을 장착중
			inventory.put(item.getItemCode(), item);
			UnitParty.partys.get(selParty).setRing(empty);

		}

	}

	private int selItem() {
		System.out.print("아이템 선택 :");
		int sel = GameManager.scan.nextInt();

		if (inventory.containsKey(sel)) {
			System.out.println(inventory.get(sel).getName() + "을 선택했습니다");
			return sel;
		}
		System.out.println("일치하는 아이템이 없습니다");
		return QUIT;
	}

}
