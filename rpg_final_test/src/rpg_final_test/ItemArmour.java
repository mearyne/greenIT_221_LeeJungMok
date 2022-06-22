package rpg_final_test;

public class ItemArmour extends Item {
	private int plusDef; // �߰��Ǵ� ����

	public ItemArmour(int itemCode, int plusDef) {
		super.setItemCode(itemCode);
		this.plusDef = plusDef;
		super.setName(String.format("��[+%d]", plusDef));
		super.setType(ARMOUR);
	}

	public int getPlusDef() {
		return plusDef;
	}

	public void setPlusDef(int plusDef) {
		this.plusDef = plusDef;
	}

}
