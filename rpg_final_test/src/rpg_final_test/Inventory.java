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
		// TODO Auto-generated method stub

	}

	private void printInventory() {
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
			printInventory();
			sel = selItem();

		} else if (sel == REMOVE) {
			party.printPartyWearing();
			sel = selItem();

		} else if (sel == DRINKPOTION) {

		}

		return sel;
	}

	private int selItem() {
		System.out.print("선택 :");
		int sel = GameManager.scan.nextInt();
		return sel;
	}

	private void remove() {

	}

}
