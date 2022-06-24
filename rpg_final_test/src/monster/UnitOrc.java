package monster;

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
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		
	}

}
