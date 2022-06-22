package rpg_final_test;

public class ItemRing extends Item {
	private int plusAtk; // ���ݷ� ������
	private int plusDef; // ���� ������

	public ItemRing(int itemCode, int plusAtk, int plusDef) {
		this.plusAtk = plusAtk;
		this.plusDef = plusDef;
		super.setItemCode(itemCode);
		super.setName(String.format("����[+%d, +%d]", plusAtk, plusDef));

	}

	public int getPlusAtk() {
		return plusAtk;
	}

	public void setPlusAtk(int plusAtk) {
		this.plusAtk = plusAtk;
	}

	public int getPlusDef() {
		return plusDef;
	}

	public void setPlusDef(int plusDef) {
		this.plusDef = plusDef;
	}

}
