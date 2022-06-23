package rpg_final_test;

public abstract class Unit { // 모든 유닛들의 부모클래스
	private String name;
	private int hp;
	private int atk;
	private int def;
	private Item weapon;
	private Item armour;
	private Item ring;

	public abstract void attack();

	public abstract void skill();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmour() {
		return armour;
	}

	public void setArmour(Item armour) {
		this.armour = armour;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	public void printWearing() {
		System.out.printf("[%s]\n", this.name);
		System.out.printf("ㄴ%s\n", this.weapon.getName());
		System.out.printf("ㄴ%s\n", this.armour.getName());
		System.out.printf("ㄴ%s\n", this.ring.getName());

	}
}


