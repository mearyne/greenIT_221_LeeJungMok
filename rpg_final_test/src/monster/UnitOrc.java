package monster;

import party.Unit;
import rpg_final_test.GameManager;
import stage.StageBattle;

public class UnitOrc extends UnitMonster {

	public UnitOrc() {
		super.setName("오크");
		super.setHp(800);
		super.setAtk(80);
		super.setDef(10);
		super.setMaxHp(getHp());
		super.setSpeed(40);
		super.setTeam(false);

	}

	@Override
	public void skill() {
		System.out.println("오크는 강한 공격을 했다!");

		int cntAlly = 0;
		for (Unit unit : StageBattle.battleUnits) {
			if (unit.getTeam())
				cntAlly++;
		}

		int randAlly = GameManager.rand.nextInt(cntAlly);
		Unit ally = StageBattle.battleUnits.get(randAlly);

		setMyFinalAtk(2 * getAtk());

		normalAttack(ally);

	}

}
