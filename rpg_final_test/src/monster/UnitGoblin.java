package monster;

public class UnitGoblin extends UnitMonster {

	public UnitGoblin() {
		super.setName("고블린");
		super.setHp(300);
		super.setAtk(30);
		super.setDef(0);
		super.setMaxHp(getHp());
		super.setSpeed(39);
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
		System.out.println("고블린은 딴짓을 하기 시작했다");
		System.out.println();
	}

}
