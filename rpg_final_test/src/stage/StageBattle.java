package stage;

import java.util.ArrayList;

import party.Unit;
import party.UnitParty;
import rpg_final_main.GameManager;

public class StageBattle extends Stage {
	
	public static ArrayList<Unit> battleUnits = new ArrayList<>();
	private int[] turnArr; // 전투시에 전투 순서를 알려주는 배열

	public StageBattle() {
		super("결투장");
	}

	@Override
	public void init() {
		addPartyInBattle();
		addRandMonsterInBattle();

	}
	
	@Override
	public void play() {
		init();
		int turn = 0;

		while (true) {
			calculateTurnArr();

			System.err.println("========== 전투 ==========");
			printBattle();
			printTurnArr(turn);

			battleUnits.get(turnArr[turn++]).attack();
			if (turn == battleUnits.size())
				turn = 0;

			deleteDeathUnit();
			if (calculateEnd())
				break;
		}

		battleUnits.clear();

	}

	private void deleteDeathUnit() {
		for (int i = 0; i < battleUnits.size(); i++) {
			if (battleUnits.get(i).getHp() <= 0) {
				System.out.println(battleUnits.get(i).getName() + "가 죽었다!");
				battleUnits.remove(i);
				i--;
			}
		}

	}

	private void calculateTurnArr() {
		turnArr = new int[battleUnits.size()];
		Integer[] temp = new Integer[battleUnits.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = battleUnits.get(i).getSpeed();
		}

		for (int i = 0; i < temp.length; i++) {
			int min = temp[i];
			int minIdx = i;
			for (int j = 0; j < temp.length; j++) {
				if (min > temp[j]) {
					min = temp[j];
					minIdx = j;
				}
			}
			turnArr[i] = minIdx;
			temp[minIdx] = 1000;
		}

	}

	private void printTurnArr(int turn) {
		System.out.print("순서 -> ");
		for (int i = 0; i < turnArr.length; i++) {
			if (i == turn) {
				System.out.printf("[%s] ", battleUnits.get(turnArr[i]).getName());
			} else {
				System.out.printf("%s ", battleUnits.get(turnArr[i]).getName());
			}
		}
		System.out.println();

	}

	private void printBattle() {
		boolean tmp = true;
		for (Unit unit : battleUnits) {
			if (unit.getTeam() == false && tmp == true) {
				System.out.println();
				tmp = false;
			}
			System.out.printf("[%s] %d/%d \n", unit.getName(), unit.getHp(), unit.getMaxHp());
		}

	}

	private boolean calculateEnd() {
		// 적들이 전부 죽으면 게임종료
		int cnt = 0;
		int cntAlly = 0;

		for (Unit unit : battleUnits) {
			if (unit.getTeam() == false) {
				cnt++;
			} else {
				cntAlly++;
			}
		}
		if (cntAlly == 0) {
			System.err.println("전투에서 패배했습니다");
			System.err.println("-Game Over-");
			System.exit(0);
		}

		if (cnt == 0) {
			System.out.println("전투에서 승리했습니다");
			return true;
		}

		return false;
	}


	private void addPartyInBattle() {
		// TODO 주소값을 넣는건 어떤가? 넣었다. 실제로 어떻게 바뀌는지 확인 바람
		ArrayList<Unit> partys = UnitParty.partys;
		int n = 0;

		for (Unit party : partys) {
			battleUnits.add(party);
			battleUnits.set(n, partys.get(n++));
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
