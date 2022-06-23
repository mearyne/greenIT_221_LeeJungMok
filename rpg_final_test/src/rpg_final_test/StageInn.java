package rpg_final_test;

import java.util.ArrayList;

public class StageInn extends Stage {
	private ArrayList<Unit> partys = UnitParty.partys;

	public StageInn() {
		super("여관");
	}

	@Override
	public void play() { // 모든 파티원들의 체력을 최대로 올린다

		for (Unit party : partys) {
			party.setHp(party.getMaxHp());
		}
		System.out.println("휴식을 완료했습니다");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
