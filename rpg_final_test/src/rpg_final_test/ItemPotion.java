package rpg_final_test;

public class ItemPotion extends Item {
	private int healing; // ȸ����

	public ItemPotion(int itemCode, int healing) {
		super.setItemCode(itemCode);
		super.setName(String.format("��������[%d]", healing));
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
