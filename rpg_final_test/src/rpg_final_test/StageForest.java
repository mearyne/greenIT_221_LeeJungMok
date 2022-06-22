package rpg_final_test;

public class StageForest extends Stage {

	private static final int DEEPER = 1;

	public StageForest() {
		super("����");
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
		System.out.println("1. �����");
		System.out.println("2. ������");
	}

	private int selMenu() {
		System.out.print("���� :");
		int sel = GameManager.scan.nextInt();

		if (sel == DEEPER) {
			Stage stage = GameManager.stageList.get(BATTLE);
			stage.init();
			stage.play();
		}

		return sel;
	}

}
