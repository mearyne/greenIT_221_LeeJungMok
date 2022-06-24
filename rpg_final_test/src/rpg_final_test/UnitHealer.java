package rpg_final_test;

public class UnitHealer extends Unit {
	
	public UnitHealer() {
		super.setName("힐러");
		super.setHp(500);
		super.setAtk(25);
		super.setDef(10);
		super.setMaxHp(getHp());
		super.setTeam(true);

		super.setWeapon(new Item());
		super.setArmour(new Item());
		super.setRing(new Item());
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
