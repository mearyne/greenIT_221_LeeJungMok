package rpg_final_test;

public class Item {
	private int itemCode;

	private String name;
	private int type; // 해당 아이템의 타입

	public static final int WEAPON = 1;
	public static final int ARMOUR = 2;
	public static final int RING = 3;
	public static final int POTION = 4;

	public Item() {
		name = "비어있음";
		type = 10000;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String printItem() {
		String item = String.format("%s", this.name);
		return item;
	}
}
