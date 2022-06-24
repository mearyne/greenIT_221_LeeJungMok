package party;

import java.util.HashMap;
import java.util.Map;

import item.Item;
import stage.StageBattle;

public class UnitPlayer extends UnitTeam {
	private static UnitPlayer instance = new UnitPlayer();

	private Map<Integer, Item> inventory = new HashMap<>();

	private UnitPlayer() {
		super.setName("용사");
		super.setHp(1000);
		super.setAtk(50);
		super.setDef(10);
		super.setMaxHp(getHp());
		super.setSpeed(10);
		super.setTeam(true);

		super.setWeapon(new Item());
		super.setArmour(new Item());
		super.setRing(new Item());
	}

	@Override
	public void skill() {
		printEnemyList();
		int sel = selEnemy();

		calculateMyFinalAtk();
		Unit enemy = StageBattle.battleUnits.get(sel);
		int damage = getMyFinalAtk() - enemy.getDef(); // 실제 입히는 데미지

		enemy.setHp(enemy.getHp() - damage);
		System.out.println("강공격!");
		System.out.printf("용사는 %s에게 %d의 데미지를 입혔다", enemy.getName(), damage);

	}

	public static UnitPlayer getInstance() {
		return instance;
	}

	public Map<Integer, Item> getInventory() {
		return inventory;
	}

}
