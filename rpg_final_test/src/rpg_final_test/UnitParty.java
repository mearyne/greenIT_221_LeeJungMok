package rpg_final_test;

import java.util.ArrayList;

public class UnitParty {
//	private static UnitParty instance = new UnitParty();
//
//	private UnitParty() {
//	}
//
//	public static UnitParty getInstance() {
//		return instance;
//	}

	public static ArrayList<Unit> party = new ArrayList<>();

	public void printPartyWearing() {
		for (Unit unit : party) {
			String name = unit.getName();
			Item weapon = unit.getWeapon();
			Item armour = unit.getArmour();
			Item ring = unit.getRing();

			System.out.printf("[%s]\n", name);
			System.out.printf("ㄴ무기[%d] :%s\n", weapon.getItemCode(), weapon.getName());
			System.out.printf("ㄴ방어구[%d] :%s\n", armour.getItemCode(), armour.getName());
			System.out.printf("ㄴ링[%d] :%s\n", ring.getItemCode(), ring.getName());

		}
	}
}
