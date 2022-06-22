package rpg_final_test;

import java.util.Map;
import java.util.Set;

public class ItemManager { // ��� �����۵��� ��Ƴ��� ���
	private ItemDAO itemDAO = new ItemDAO();

	private static final int ADDWEAPON = 1;
	private static final int ADDARMOUR = 2;
	private static final int ADDRING = 3;
	private static final int ADDPOTION = 4;
	private static final int BACK = 0;

	private Map<Integer, Item> items = ItemDAO.items;

	public void ItemMenu() {
		while (true) {
			printItemMenu();
			if (selItemMenu() == BACK)
				break;
		}
	}

	private int rCode() { // ������DAO�� �������� �ʴ� ������ �ڵ� ����
		while (true) {
			boolean dup = true;
			Set<Integer> keys = this.items.keySet();
			int rCode = GameManager.rand.nextInt(1000) + 8999;

			for (Integer key : keys) {
				if (key == rCode)
					dup = false;
			}
			if (dup)
				return rCode;

		}
	}

	private void printItemMenu() {
		System.out.println("=====[�����۰�����]=====");
		System.out.println("1. ���� �߰�");
		System.out.println("2. �� �߰�");
		System.out.println("3. ���� �߰�");
		System.out.println("4. ���� �߰�");
		System.out.println("5. �ڷΰ���");
	}

	private int selItemMenu() {
		int sel = GameManager.scan.nextInt();

		if (sel == ADDWEAPON) {
			itemDAO.addWeapon(rCode());
			System.out.println("���Ⱑ �߰��Ǿ����ϴ�");
		} else if (sel == ADDARMOUR) {
			itemDAO.addArmour(rCode());
			System.out.println("���� �߰��Ǿ����ϴ�");
		} else if (sel == ADDRING) {
			itemDAO.addRing(rCode());
			System.out.println("���� �߰��Ǿ����ϴ�");
		} else if (sel == ADDPOTION) {
			itemDAO.addPotion(rCode());
			System.out.println("������ �߰��Ǿ����ϴ�");
		} else if (sel == BACK) {
			return BACK;
		}

		return -1;
	}

}
