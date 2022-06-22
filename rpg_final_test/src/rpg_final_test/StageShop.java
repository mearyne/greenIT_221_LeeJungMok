package rpg_final_test;

public class StageShop extends Stage {

	private static final int BUY = 1;
	private static final int SELL = 2;

	public StageShop() {
		super("����");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		while (true) {
			printMenu();
			if (selMenu() == QUIT) {
				break;
			}

		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	private void printMenu() {
		System.out.println("1. �����ϱ�");
		System.out.println("2. �Ǹ��ϱ�");
		System.out.println("0. ������");
	}

	private int selMenu() {
		System.out.print("���� :");
		int sel = GameManager.scan.nextInt();

		if (sel == BUY) {
			buyItem();
		} else if (sel == SELL) {
			selItem();
		}

		return sel;
	}

}
