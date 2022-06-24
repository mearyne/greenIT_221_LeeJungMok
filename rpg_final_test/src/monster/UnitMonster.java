package monster;

import party.Unit;
import rpg_final_test.GameManager;
import stage.StageBattle;

public class UnitMonster extends Unit {
	private final int SKILLABLE = 4; // 스킬이 발동할 확률 1/4
	private final int ON = 0; // skill 발동

	@Override
	public void attack() {
		int skillAble = GameManager.rand.nextInt(SKILLABLE);
		if (skillAble == ON) {
			skill();
		} else {
			normalAttack();
		}
	}

	@Override
	public void skill() {
	}

	@Override
	public void normalAttack() {
		int cntAlly = 0;
		for (Unit unit : StageBattle.battleUnits) {
			if (unit.getTeam())
				cntAlly++;
		}

		int randAlly = GameManager.rand.nextInt(cntAlly);
		Unit ally = StageBattle.battleUnits.get(randAlly);

		setMyFinalAtk(getAtk());

		normalAttack(ally);

	}

}
