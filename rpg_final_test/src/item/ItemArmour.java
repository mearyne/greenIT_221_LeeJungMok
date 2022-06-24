package item;

public class ItemArmour extends Item {
	private int plusDef; // 추가되는 방어력
	
	public ItemArmour() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ItemArmour(int itemCode, int plusDef) {
		super.setItemCode(itemCode);
		this.plusDef = plusDef;
		super.setName(String.format("방어구[+%d]", plusDef));
		super.setType(ARMOUR);
	}

	public int getPlusDef() {
		return plusDef;
	}

	public void setPlusDef(int plusDef) {
		this.plusDef = plusDef;
	}

}
