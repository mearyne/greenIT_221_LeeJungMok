package rpg_final_test;

public class UnitWizard extends Unit {

	public UnitWizard() {
		super.setName("마법사");
		super.setHp(700);
		super.setAtk(60);
		super.setDef(10);

		super.setWeapon(new ItemWeapon());
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
