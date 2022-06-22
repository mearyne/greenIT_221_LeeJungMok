package rpg_final_test;

import java.util.Map;
import java.util.Set;

public class ItemManager { // 모든 아이템들을 모아놓은 장소
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

	private int rCode() { // 아이템DAO에 존재하지 않는 랜덤한 코드 생성
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
			itemDAO.addWeapon(rCode());
			System.out.println("무기가 추가되었습니다");
		} else if (sel == ADDARMOUR) {
			itemDAO.addArmour(rCode());
			System.out.println("방어구가 추가되었습니다");
		} else if (sel == ADDRING) {
			itemDAO.addRing(rCode());
			System.out.println("링이 추가되었습니다");
		} else if (sel == ADDPOTION) {
			itemDAO.addPotion(rCode());
			System.out.println("포션이 추가되었습니다");
		} else if (sel == BACK) {
			return BACK;
		}

		return -1;
	}

}
