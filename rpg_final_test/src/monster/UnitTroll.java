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
	public void skill() {
		int healing = 0;
		if (getHp() + 300 > getMaxHp())
			healing = getMaxHp() - getHp();
		else {
			healing = 300;
		}

		setHp(getHp() + healing);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.printf("트롤은 %d만큼 체력을 회복했다!", healing);
	}

}
