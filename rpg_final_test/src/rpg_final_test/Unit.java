package rpg_final_test;

import java.util.ArrayList;

public abstract class Unit { // 모든 유닛들의 부모클래스
	private String name;
	private int hp;
	private int atk;
	private int def;
	ArrayList<Item> wear = new ArrayList<>();

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

}
