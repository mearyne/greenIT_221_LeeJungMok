package rpg_final_test;

import java.util.HashMap;
import java.util.Map;

public class UnitPlayer extends Unit {
	private static UnitPlayer instance = new UnitPlayer();

	private Map<Integer, Item> inventory = new HashMap<>();

	private UnitPlayer() {
		super.setName("ฟ๋ป็");
		super.setHp(1000);
		super.setAtk(50);
		super.setDef(10);

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

	public static UnitPlayer getInstance() {
		return instance;
	}

	public Map<Integer, Item> getInventory() {
		return inventory;
	}

}
