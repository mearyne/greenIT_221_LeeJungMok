package stage;

import rpg_final_main.GameManager;

public class StageForest extends Stage {

	private static final int DEEPER = 1;

	public StageForest() {
		super("숲속");
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
		System.out.println("1. 깊숙히");
		System.out.println("2. 마을로");
	}

	private int selMenu() {
		System.out.print("선택 :");
		int sel = GameManager.scan.nextInt();

		if (sel == DEEPER) {
			Stage stage = new StageBattle();
			stage.play();
		}

		return sel;
	}

}
