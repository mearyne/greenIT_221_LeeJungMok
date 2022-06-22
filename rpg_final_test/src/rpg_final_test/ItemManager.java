package rpg_final_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ItemManager { // ��� �����۵��� ��Ƴ��� ���

	private static final int ADDWEAPON = 1;
	private static final int ADDARMOUR = 2;
	private static final int ADDRING = 3;
	private static final int ADDPOTION = 4;
	private static final int BACK = 0;

	public static Map<Integer, Item> items = new HashMap<>(); // �ߺ��Ǵ� �����۵� ������� ��� ������ �������� ��Ƴ��´�
	Set<Integer> keys;

	public void ItemMenu() {
		while (true) {
			printItemMenu();
			if (selItemMenu() == BACK)
				break;
		}
	}

	private int rCode() {
		while (true) {
			boolean dup = true;
			this.keys = items.keySet();
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
			addWeapon();
		} else if (sel == ADDARMOUR) {
			addArmour();
		} else if (sel == ADDRING) {
			addRing();
		} else if (sel == ADDPOTION) {
			addPotion();
		} else if (sel == BACK) {
			return BACK;
		}

		return -1;
	}

	private void addWeapon() {
		System.out.print("�߰��� ���� ���ݷ� �Է�: ");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			int rCode = rCode();
			Item weapon = new ItemWeapon(rCode, input);
			
			UnitPlayer.getInstance().getInventory().put(rCode, weapon); 
			items.put(rCode, weapon);
		} else {
			System.out.println("���� ���ݷ��� �ʹ� �����ϴ�");
		}
	}

}
