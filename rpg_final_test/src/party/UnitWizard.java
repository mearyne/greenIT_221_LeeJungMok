package party;

import item.Item;
import item.ItemWeapon;
import stage.StageBattle;

public class UnitWizard extends UnitTeam {

	public UnitWizard() {
		super.setName("마법사");
		super.setHp(700);
		super.setAtk(60);
		super.setDef(10);
		super.setMaxHp(getHp());
		super.setTeam(true);
		super.setSpeed(20);

		super.setWeapon(new ItemWeapon());
		super.setArmour(new Item());
		super.setRing(new Item());
	}

	@Override
	public void skill() { // 일반 공격력으로 전체공격을 가한다
		calculateMyFinalAtk();
		System.out.println("마법으로 전체공격!");
		for (int i = 3; i < StageBattle.battleUnits.size(); i++) {
			Unit enemy = StageBattle.battleUnits.get(i);
			normalAttack(enemy);
		}
	}

}
