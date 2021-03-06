package item;

public class ItemWeapon extends Item {

	public ItemWeapon(int itemCode, int plusAtk) {
		super.setItemCode(itemCode);
		this.setPlusAtk(plusAtk);
		super.setType(WEAPON);
		super.setName(String.format("무기[+%d]", plusAtk));
	}

	public ItemWeapon() {
		super();
		plusAtk = 0;
	}

	public int getPlusAtk() {
		return plusAtk;
	}

	public void setPlusAtk(int plusAtk) {
		this.plusAtk = plusAtk;
	}
}