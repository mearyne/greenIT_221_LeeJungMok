package party;

import item.ItemArmour;
import item.ItemRing;
import item.ItemWeapon;
import stage.StageBattle;

public class UnitHealer extends UnitTeam {
	private UnitParty unitParty = new UnitParty();

	public UnitHealer() {
		super.setName("힐러");
		super.setHp(500);
		super.setAtk(25);
		super.setDef(10);
		super.setMaxHp(getHp());
		super.setTeam(true);
		super.setSpeed(40);

		super.setWeapon(new ItemWeapon());
		super.setArmour(new ItemArmour());
		super.setRing(new ItemRing());
	}

	@Override
	public void skill() { // 아군을 300만큼 힐한다
		unitParty.printParty();
		int sel = unitParty.selParty();

		Unit target = StageBattle.battleUnits.get(sel);
		int healing = 0;
		if (target.getHp() + 300 > getMaxHp())
			healing = getMaxHp() - target.getHp();
		else {
			healing = 300;
		}

		target.setHp(target.getHp() + 300);

		System.out.printf("힐러는 %s의 체력을 %d만큼 회복시켰다\n", target.getName(), healing);
		delay(1000);
	}

}
