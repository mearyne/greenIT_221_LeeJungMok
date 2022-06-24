package party;

import item.Item;
import item.ItemArmour;
import item.ItemRing;
import item.ItemWeapon;
import rpg_final_test.GameManager;

public abstract class Unit { // 모든 유닛들의 부모클래스

	private String name;
	private int hp;
	private int maxHp;
	private int atk;
	private int def;
	private Item weapon;
	private Item armour;
	private Item ring;
	private boolean team;
	private int speed;
	private int myFinalAtk;

	public void attack() {
		while (true) {
			printAttackMenu();
			int sel = selAttackMenu();

			if (sel == 1) {
				normalAttack();
				break;
			} else if (sel == 2) {
				skill();
				break;
			}

		}
	}

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
		System.out.printf("[%s]\n", name);
		System.out.printf("ㄴ%s\n", weapon.getName());
		System.out.printf("ㄴ%s\n", armour.getName());
		System.out.printf("ㄴ%s\n", ring.getName());

	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public boolean getTeam() {
		return team;
	}

	public void setTeam(boolean team) {
		this.team = team;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	private void printAttackMenu() {
		System.out.printf("[%s]의 차례입니다. \n", name);
		System.out.println("1. 공격");
		System.out.println("2. 스킬");
	}

	private int selAttackMenu() {
		while (true) {
			System.out.print("선택 :");
			int sel = GameManager.scan.nextInt();

			if (sel == 1 || sel == 2) {
				return sel;
			} else {
				System.out.println("잘못입력했습니다");
			}

		}
	}

	public void attackMenu() {

	}

	public abstract void normalAttack();

	public int getMyFinalAtk() {
		return myFinalAtk;
	}

	public void setMyFinalAtk(int myFinalAtk) {
		this.myFinalAtk = myFinalAtk;
	}

	public void normalAttack(Unit enemy) {
		System.out.println();
		System.out.printf("%s는 %s에게 %d의 데미지를 입혔다\n", getName(), enemy.getName(), getMyFinalAtk() - enemy.getDef());
		System.out.println();
		enemy.setHp(enemy.getHp() - (getMyFinalAtk() - enemy.getDef()));
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void calculateMyFinalAtk() {
		ItemWeapon weapon = (ItemWeapon) getWeapon();

		ItemRing ring = (ItemRing) getRing();

		setMyFinalAtk(getAtk() + weapon.getPlusAtk() + ring.getPlusAtk());

	}

	public int getPlusAtk() {
		return 0;
	}

	public int getPlusDef() {
		return 0;
	}

}
