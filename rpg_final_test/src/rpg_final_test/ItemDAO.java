package rpg_final_test;

import java.util.HashMap;
import java.util.Map;

public class ItemDAO {
	public static Map<Integer, Item> items = new HashMap<>(); // �ߺ��Ǵ� �����۵� ������� ��� ������ �������� ��Ƴ��´�

	public void addWeapon(int rCode) {
		System.out.print("�߰��� ���� ���ݷ� �Է�: ");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item weapon = new ItemWeapon(rCode, input);

			UnitPlayer.getInstance().getInventory().put(rCode, weapon); // �κ��丮�� ����
			items.put(rCode, weapon); // ������DAO�� ����
		} else {
			System.out.println("���� ���ݷ��� �ʹ� �����ϴ�");
		}
	}

	public void addArmour(int rCode) {
		System.out.println("�߰��� �� ���� �Է� :");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item armour = new ItemArmour(rCode, input);

			UnitPlayer.getInstance().getInventory().put(rCode, armour);
			items.put(rCode, armour);
		}
	}

	public void addRing(int rCode) {
		System.out.println("�߰��� ���� ���ݷ� �Է� :");
		int inputAtk = GameManager.scan.nextInt();
		System.out.println("�߰��� ���� ���� �Է� :");
		int inputDef = GameManager.scan.nextInt();

		if (inputAtk >= 0 && inputDef >= 0 && (inputAtk == 0 && inputDef == 0)) {
			Item ring = new ItemRing(rCode, inputAtk, inputDef);

			UnitPlayer.getInstance().getInventory().put(rCode, ring);
			items.put(rCode, ring);
		}

	}

	public void addPotion(int rCode) {
		System.out.println("�߰��� ������ �� ��ġ �Է� :");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item potion = new ItemPotion(rCode, input);

			UnitPlayer.getInstance().getInventory().put(rCode, potion);
			items.put(rCode, potion);
		}

	}

}
