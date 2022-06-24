package stage;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import item.Item;
import item.ItemDAO;
import party.Unit;
import party.UnitParty;

public class Save extends Stage {
	private String fileName = "rpgGameData";
	private String data = "";

	public Save() {
		super("세이브");
	}

	@Override
	public void play() {
		// 실제 저장 실행
		try {
			FileWriter fWriter = new FileWriter(fileName);
			fWriter.write(data);
			fWriter.close();

			System.out.println("저장 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("저장 실패");
		}

	}

	@Override
	public void init() {
		// 데이터 불러오기
		bringPartyInfo();
		bringInventoryInfo();
	}

	private void bringPartyInfo() {
		ArrayList<Unit> partys = UnitParty.partys;
		for (Unit party : partys) {
			data += party;
			data += "\n";
		}
	}

	private void bringInventoryInfo() {
		Map<Integer, Item> items = ItemDAO.items;
		Set<Integer> keys = items.keySet();
		for (Integer key : keys) {
			data += items.get(key);
			data += "\n";
		}
		data = data.substring(0, data.length() - 1);

	}

}
