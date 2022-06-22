package rpg_final_test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameManager { // ������ ��ü���� ���������

	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();

	public static ArrayList<Stage> stageList = new ArrayList<>();

	public GameManager() {
		// �������� �߰�
		stageList.add(new StageLobby());
		stageList.add(new StageForest());
		stageList.add(new StageShop());
		stageList.add(new Inventory());
		stageList.add(new BattleStage());

		// ��Ƽ �迭�� ��Ƽ���� �߰��ϱ�
		UnitParty.party.add(new UnitHealer());
		UnitParty.party.add(new UnitWizard());
		UnitParty.party.add(UnitPlayer.getInstance());
	}

	public void run() {
		System.out.println("���� ����!");

		stageList.get(0).init(); // ���� ����
		stageList.get(0).play();
	}

}
