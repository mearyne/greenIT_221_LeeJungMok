package rpg_final_test;

import java.util.HashMap;
import java.util.Map;

public class ItemDAO {
	public static Map<Integer, Item> items = new HashMap<>(); // 중복되는 아이템도 상관없이 모든 종류의 아이템을 모아놓는다

	public void addWeapon(int rCode) {
		System.out.print("추가할 무기 공격력 입력: ");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item weapon = new ItemWeapon(rCode, input);

			UnitPlayer.getInstance().getInventory().put(rCode, weapon); // 인벤토리에 저장
			items.put(rCode, weapon); // 아이템DAO에 저장
		} else {
			System.out.println("무기 공격력이 너무 낮습니다");
		}
	}

	public void addArmour(int rCode) {
		System.out.println("추가할 방어구 방어력 입력 :");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item armour = new ItemArmour(rCode, input);

			UnitPlayer.getInstance().getInventory().put(rCode, armour);
			items.put(rCode, armour);
		}
	}

	public void addRing(int rCode) {
		System.out.println("추가할 링의 공격력 입력 :");
		int inputAtk = GameManager.scan.nextInt();
		System.out.println("추가할 링의 방어력 입력 :");
		int inputDef = GameManager.scan.nextInt();

		if (inputAtk >= 0 && inputDef >= 0 && (inputAtk == 0 && inputDef == 0)) {
			Item ring = new ItemRing(rCode, inputAtk, inputDef);

			UnitPlayer.getInstance().getInventory().put(rCode, ring);
			items.put(rCode, ring);
		}

	}

	public void addPotion(int rCode) {
		System.out.println("추가할 포션의 힐 수치 입력 :");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item potion = new ItemPotion(rCode, input);

			UnitPlayer.getInstance().getInventory().put(rCode, potion);
			items.put(rCode, potion);
		}

	}

}
