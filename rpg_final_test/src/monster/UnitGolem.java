package monster;

import party.Unit;
import stage.StageBattle;

public class UnitGolem extends UnitMonster {

	public UnitGolem() {
		super.setName("골렘");
		super.setHp(2000);
		super.setAtk(20);
		super.setDef(60);
		super.setMaxHp(getHp());
		super.setSpeed(70);
		super.setTeam(false);
	}

	@Override
	public void skill() {
		System.out.println();
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("골렘은 충격파를 가했다!");

		int cntAlly = 0;
		for (Unit unit : StageBattle.battleUnits) {
			if (unit.getTeam())
				cntAlly++;
		}
		for (int i = 0; i < cntAlly; i++) {
			Unit ally = StageBattle.battleUnits.get(i);
			normalAttack(ally);

		}

	}

}
