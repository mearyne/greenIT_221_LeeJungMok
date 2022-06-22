package rpg_final_test;

import java.util.ArrayList;

public class StageLobby extends Stage {
	private ArrayList<Stage> stageList = GameManager.stageList;

	public StageLobby() {
		super("로비");
	}

	@Override
	public void play() {
		while (true) {
			printStage();
			int sel = selStage();

			if (sel == QUIT)
				break;
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	private void printStage() {
		System.out.println("==== 움직일 곳을 입력하세요 ====");
		for (int i = 1; i < this.stageList.size(); i++) {
			System.out.printf("%d. %s\n", i, this.stageList.get(i).getName());
		}

	}

	private int selStage() {
		System.out.print("선택 :");
		int sel = GameManager.scan.nextInt();

		if (sel >= 0 && sel < this.stageList.size()) {
			this.stageList.get(sel).init();
			this.stageList.get(sel).play();
		}

		return sel;
	}

}
