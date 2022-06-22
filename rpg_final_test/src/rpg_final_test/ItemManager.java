package rpg_final_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ItemManager { // 모든 아이템들을 모아놓은 장소

	private static final int ADDWEAPON = 1;
	private static final int ADDARMOUR = 2;
	private static final int ADDRING = 3;
	private static final int ADDPOTION = 4;
	private static final int BACK = 0;

	public static Map<Integer, Item> items = new HashMap<>(); // 중복되는 아이템도 상관없이 모든 종류의 아이템을 모아놓는다
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
		System.out.println("=====[아이템관리자]=====");
		System.out.println("1. 무기 추가");
		System.out.println("2. 방어구 추가");
		System.out.println("3. 반지 추가");
		System.out.println("4. 포션 추가");
		System.out.println("5. 뒤로가기");
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
		System.out.print("추가할 무기 공격력 입력: ");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			int rCode = rCode();
			Item weapon = new ItemWeapon(rCode, input);
			
			UnitPlayer.getInstance().getInventory().put(rCode, weapon); 
			items.put(rCode, weapon);
		} else {
			System.out.println("무기 공격력이 너무 낮습니다");
		}
	}

}
