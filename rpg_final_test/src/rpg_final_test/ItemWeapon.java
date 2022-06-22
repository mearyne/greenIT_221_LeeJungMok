package rpg_final_test;

public class ItemWeapon extends Item {
	private int plusAtk; // ���ݷ� ������

	public ItemWeapon(int itemCode, int plusAtk) {
		super.setItemCode(itemCode);
		this.setPlusAtk(plusAtk);
		super.setType(WEAPON);
		super.setName(String.format("����[+%d]", plusAtk));
	}

	public int getPlusAtk() {
		return plusAtk;
	}

	public void setPlusAtk(int plusAtk) {
		this.plusAtk = plusAtk;
	}
}
