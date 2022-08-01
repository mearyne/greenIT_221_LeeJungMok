package party;

import java.util.ArrayList;

import rpg_final_main.GameManager;
import stage.StageBattle;

public class UnitTeam extends Unit {
	private ArrayList<Unit> battleUnits = StageBattle.battleUnits;
	private int n = 0;

	@Override
	public void skill() {
	}

	@Override
	public void normalAttack() {
		printEnemyList();
		int sel = selEnemy() + 2; // 유효한 몬스터를 선택했을때만 반환시킨다

		Unit enemy = battleUnits.get(sel);
		calculateMyFinalAtk();
		normalAttack(enemy);
	}

	public int selEnemy() {
		while (true) {
			System.out.print("선택 :");
			int sel = GameManager.scan.nextInt();

			if (sel >= 1 && sel <= battleUnits.size() - 3) {
				return sel;
			}

		}
	}

	public void printEnemyList() {
		n = 1;
		for (Unit unit : battleUnits) {
			if (unit.getTeam() == false)
				System.out.printf("%d. [%s] %d/%d\n", n++, unit.getName(), unit.getHp(), unit.getMaxHp());
		}

	}

	
}
