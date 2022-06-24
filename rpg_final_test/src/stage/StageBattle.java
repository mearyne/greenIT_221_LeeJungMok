package stage;

import java.util.ArrayList;

import party.Unit;
import party.UnitParty;
import rpg_final_test.GameManager;
//import monster.UnitGoblin;
//import monster.UnitGolem;
//import monster.UnitTroll;
//import monster.UnitOrc;

public class StageBattle extends Stage {
	public static ArrayList<Unit> battleUnits = new ArrayList<>();
	private int[] turnArr; // 전투시에 전투 순서를 알려주는 배열

	public StageBattle() {
		super("결투장");
	}

	@Override
	public void play() {
		init();
		int turn = 0;

		while (true) {
			calculateTurnArr();

			System.out.println("========== 전투 ==========");
			printBattle();
			printTurnArr(turn);

			battleUnits.get(turn++).attack();
			if (turn == battleUnits.size())
				turn = 0;

			deleteDeathUnit();
			if (calculateEnd())
				break;
		}

	}

	private void deleteDeathUnit() {
		for (int i = 0; i < battleUnits.size(); i++) {
			if (battleUnits.get(i).getHp() <= 0) {
				System.out.println(battleUnits.get(i).getName() + "가 죽었다!");
				battleUnits.remove(i);
			}
		}

	}

	private void printTurnArr(int turn) {
		System.out.print("순서 : ");
		for (int i = 0; i < turnArr.length; i++) {
			Unit unit = battleUnits.get(turnArr[i]);
			if (turn == i) {
				System.out.printf("%s(현재턴) ", unit.getName());
			} else {
				System.out.printf("%s ", unit.getName());
			}
		}
		System.out.println();
	}

	private void printBattle() {
		for (Unit unit : battleUnits) {
			System.out.printf("[%s] %d/%d \n", unit.getName(), unit.getHp(), unit.getMaxHp());
		}

	}

	private boolean calculateEnd() {
		// 적들이 전부 죽으면 게임종료
		int cnt = 0;
		for (Unit unit : battleUnits) {
			// 용사가 죽으면 게임종료
//			if (UnitPlayer.getInstance().getHp() <= 0) {
//				System.out.println("용사가 사망했습니다");
//				System.out.println("-Game Over-");
//				System.exit(0);
//			}

			if (unit.getTeam() == false) {
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("전투에서 승리했습니다");
			return true;
		}

		return false;
	}

	private void calculateTurnArr() {
		int n = 0;
		int min = battleUnits.get(0).getSpeed();
		int minIdx = 0;
		for (int i = 0; i < battleUnits.size(); i++) {
			for (int j = 0; j < battleUnits.size(); j++) {
				if (min > battleUnits.get(j).getSpeed()) {
					min = battleUnits.get(j).getSpeed();
					minIdx = j;
				}
			}

			turnArr[n++] = minIdx;

		}
	}

	@Override
	public void init() {
		addPartyInBattle();
		addRandMonsterInBattle();
		turnArr = new int[battleUnits.size()];

	}

	private void addPartyInBattle() {
		ArrayList<Unit> partys = UnitParty.partys;
		for (Unit party : partys) {
			battleUnits.add(party);
		}

	}

	private void addRandMonsterInBattle() {
		String path = "monster.";
		String[] monsterNames = { "UnitOrc", "UnitGoblin", "UnitGolem", "UnitTroll" };

		for (int i = 0; i < monsterNames.length; i++) {
			int num = GameManager.rand.nextInt(monsterNames.length);
			try {
				Class<?> clazz = Class.forName(path + monsterNames[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;

				battleUnits.add(temp);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
