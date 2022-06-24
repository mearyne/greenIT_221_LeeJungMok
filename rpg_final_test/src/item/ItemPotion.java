package item;

public class ItemPotion extends Item {
	private int healing; // 회복량

	public ItemPotion(int itemCode, int healing) {
		super.setItemCode(itemCode);
		super.setName(String.format("힐링포션[%d]", healing));
		super.setType(POTION);
		this.healing = healing;
	}

	public int getHealing() {
		return healing;
	}

	public void setHealing(int healing) {
		this.healing = healing;
	}

}
