package rpg_final_test;

public class StageForest extends Stage {

	private static final int DEEPER = 1;

	public StageForest() {
		super("½£¼Ó");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		while (true) {
			printMenu();
			if (selMenu() - 2 == QUIT)
				break;
		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	private void printMenu() {
		System.out.println("1. ±í¼÷È÷");
		System.out.println("2. ¸¶À»·Î");
	}

	private int selMenu() {
		System.out.print("¼±ÅÃ :");
		int sel = GameManager.scan.nextInt();

		if (sel == DEEPER) {
			Stage stage = GameManager.stageList.get(BATTLE);
			stage.init();
			stage.play();
		}

		return sel;
	}

}
