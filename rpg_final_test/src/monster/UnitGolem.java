package monster;

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
	public void attack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub

	}

}
