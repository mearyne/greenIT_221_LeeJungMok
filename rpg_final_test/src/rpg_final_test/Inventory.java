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
		super("�κ��丮");
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
		System.out.println("========== �κ��丮 ==========");
		for (Integer key : keys) {
			System.out.printf("%d. %s\n", this.inventory.get(key).getItemCode(), this.inventory.get(key).getName());
		}
	}

	private void printMenu() {
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. ���ǸԱ�");
		System.out.println("0. �ڷΰ���");
	}

	private int selMenu() {
		System.out.print("���� :");
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
		System.out.print("���� :");
		int sel = GameManager.scan.nextInt();
		return sel;
	}

	private void remove() {

	}

}
