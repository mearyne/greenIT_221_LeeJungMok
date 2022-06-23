package rpg_final_test;

public class StageItemManager extends Stage {
	private ItemManager itemManager = new ItemManager();

	public StageItemManager() {
		super("아이템관리자");
	}

	@Override
	public void play() {
		while (true) {
			itemManager.printItems();
			itemManager.printItemMenu();
			int sel = itemManager.selItemMenu();

			if (sel == QUIT)
				break;
		}
	}

	@Override
	public void init() {

	}

}
