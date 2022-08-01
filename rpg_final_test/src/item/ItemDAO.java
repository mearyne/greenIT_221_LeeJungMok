package item;

import java.util.HashMap;
import java.util.Map;

import party.UnitPlayer;
import rpg_final_main.GameManager;

public class ItemDAO {
	public static Map<Integer, Item> items = new HashMap<>(); // 중복되는 아이템도 상관없이 모든 종류의 아이템을 모아놓는다

	public void addWeapon(int rCode) {
		System.out.print("추가할 무기 공격력 입력: ");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item weapon = new ItemWeapon(rCode, input);

//			UnitPlayer.getInstance().getInventory().put(rCode, weapon); // 인벤토리에 저장
//			items.put(rCode, weapon); // 아이템DAO에 저장
			addItem(rCode, weapon);

			System.out.println(weapon.getName() + "추가에 성공했습니다");
		} else {
			System.out.println("추가 실패했습니다");
		}
	}

	public void addArmour(int rCode) {
		System.out.println("추가할 방어구 방어력 입력 :");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item armour = new ItemArmour(rCode, input);

//			UnitPlayer.getInstance().getInventory().put(rCode, armour);
//			items.put(rCode, armour);

			addItem(rCode, armour);
			System.out.println(armour.getName() + "이 추가되었습니다");
		} else {
			System.out.println("추가에 실패했습니다");
		}

	}

	public void addRing(int rCode) {
		System.out.println("추가할 링의 공격력 입력 :");
		int inputAtk = GameManager.scan.nextInt();
		System.out.println("추가할 링의 방어력 입력 :");
		int inputDef = GameManager.scan.nextInt();

		if ((inputAtk >= 0 || inputDef >= 0) && (inputAtk != 0 && inputDef != 0)) {
			Item ring = new ItemRing(rCode, inputAtk, inputDef);

//			UnitPlayer.getInstance().getInventory().put(rCode, ring);
//			items.put(rCode, ring);
			addItem(rCode, ring);

			System.out.println(ring.getName() + "이 추가되었습니다");

		} else {
			System.out.println("링 추가에 실패했습니다");
		}

	}

	public void addPotion(int rCode) {
		System.out.println("추가할 포션의 힐 수치 입력 :");
		int input = GameManager.scan.nextInt();

		if (input > 0) {
			Item potion = new ItemPotion(rCode, input);

//			UnitPlayer.getInstance().getInventory().put(rCode, potion);
//			items.put(rCode, potion);

			addItem(rCode, potion);
			System.out.println("포션이 추가되었습니다");
		} else {
			System.out.println("포션추가가 실패했습니다");
		}

	}

	public void addItem(int rCode, Item item) {
		UnitPlayer.getInstance().getInventory().put(rCode, item); // 인벤토리에 저장
		items.put(rCode, item); // 아이템DAO에 저장
	}

}
