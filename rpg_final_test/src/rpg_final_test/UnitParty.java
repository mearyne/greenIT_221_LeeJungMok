package rpg_final_test;

import java.util.ArrayList;

public class UnitParty {

	public static ArrayList<Unit> partys = new ArrayList<>();

	public void printParty() {
		int n = 0;
		for (Unit party : partys) {
			System.out.printf("%d. [%s] %d/%d\n", n++, party.getName(), party.getHp(), party.getMaxHp());

			Item weapon = party.getWeapon();
			Item armour = party.getArmour();
			Item ring = party.getRing();

			System.out.printf("ㄴ무기[%d] :%s\n", weapon.getItemCode(), weapon.getName());
			System.out.printf("ㄴ방어구[%d] :%s\n", armour.getItemCode(), armour.getName());
			System.out.printf("ㄴ링[%d] :%s\n", ring.getItemCode(), ring.getName());
		}

	}

	public int selParty() {
		System.out.print("파티원 선택 :");
		int sel = GameManager.scan.nextInt();

		if (sel >= 0 && sel <= partys.size()) {
			return sel;
		}
		System.out.println("선택 오류");
		return -1;
	}
}
