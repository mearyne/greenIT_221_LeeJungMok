
package rpg_final_test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameManager { // 게임의 전체적인 통괄관리자

	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();

	public static ArrayList<Stage> stageList = new ArrayList<>();

	public GameManager() {
		// 스테이지 추가
		stageList.add(new StageLobby());
		stageList.add(new StageForest());
		stageList.add(new StageShop());
		stageList.add(new Inventory());
		stageList.add(new BattleStage());
		stageList.add(new StageItemManager());

		// 파티 배열에 파티원들 추가하기
		UnitParty.party.add(new UnitHealer());
		UnitParty.party.add(new UnitWizard());
		UnitParty.party.add(UnitPlayer.getInstance());
	}

	public void run() {
		System.out.println("게임 시작!");

		stageList.get(0).init(); // 게임 시작
		stageList.get(0).play();
	}

}
