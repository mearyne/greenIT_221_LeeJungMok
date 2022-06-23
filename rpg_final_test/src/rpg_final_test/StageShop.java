package rpg_final_test;

public class StageShop extends Stage {

	private static final int BUY = 1;
	private static final int SELL = 2;

	public StageShop() {
		super("가게");
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
		System.out.println("1. 구매하기");
		System.out.println("2. 판매하기");
		System.out.println("0. 마을로");
	}

	private int selMenu() {
		System.out.print("선택 :");
		int sel = GameManager.scan.nextInt();

		if (sel == BUY) {
//			buyItem();
		} else if (sel == SELL) {
//			selItem();
		}

		return sel;
	}

}
