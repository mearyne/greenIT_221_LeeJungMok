package monster;

public class UnitTroll extends UnitMonster {

	public UnitTroll() {
		super.setName("트롤");
		super.setHp(1500);
		super.setAtk(100);
		super.setDef(30);
		super.setMaxHp(getHp());
		super.setSpeed(50);
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
