
package rpg_final_test;

public class ItemRing extends Item {
	private int plusAtk; // 공격력 증가량
	private int plusDef; // 방어력 증가량

	public ItemRing(int itemCode, int plusAtk, int plusDef) {
		this.plusAtk = plusAtk;
		this.plusDef = plusDef;
		super.setItemCode(itemCode);
		super.setName(String.format("반지[+%d, +%d]", plusAtk, plusDef));
		super.setType(RING);
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
