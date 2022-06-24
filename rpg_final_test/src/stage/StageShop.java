package stage;

import java.util.ArrayList;

import item.Item;
import item.ItemArmour;
import item.ItemDAO;
import item.ItemManager;
import item.ItemPotion;
import item.ItemRing;
import item.ItemWeapon;
import rpg_final_test.GameManager;

public class StageShop extends Stage {
	private ItemManager itemManager = new ItemManager();
	private ItemDAO itemDAO = new ItemDAO();
	private Inventory inventory = new Inventory();

	private static final int BUY = 1;
	private static final int SELL = 2;

	private ArrayList<Item> shopList = new ArrayList<>();

	public StageShop() {
		super("가게");
	}

	@Override
	public void play() {
		while (true) {
			printMenu();
			if (selMenu() == QUIT) {
				break;
			}

		}

	}

	@Override
	public void init() { // 상점에서 판매하는 아이템 목록
		shopList.add(new ItemWeapon(1, 100));
		shopList.add(new ItemArmour(2, 100));
		shopList.add(new ItemRing(3, 50, 50));
		shopList.add(new ItemPotion(4, 500));
	}

	private void printMenu() {
		System.out.println("1. 구매하기");
		System.out.println("2. 판매하기");
		System.out.println("0. 마을로");
	}

	private int selMenu() {
		System.out.print("선택 :");
		int sel = GameManager.scan.nextInt();

		if (sel == BUY) {
			buyItem();
		} else if (sel == SELL) {
			selItem();
		}

		return sel;
	}

	private void selItem() {
		inventory.printInventory();
		System.out.print("선택 :");
		int sel = GameManager.scan.nextInt();

		inventory.inventory.remove(sel);
		System.out.println("판매하였습니다");
	}

	private void buyItem() {
		printShopList();
		System.out.print("선택 :");
		int sel = GameManager.scan.nextInt() - 1;

		if (sel >= 0 && sel < shopList.size()) {
			// 내 인벤토리에 저장
			Item item = copyItem(shopList.get(sel));

			itemDAO.addItem(item.getItemCode(), item);
			System.out.println(item.getName() + "을 구매했습니다");
		}
	}

	private void printShopList() {
		for (int i = 0; i < shopList.size(); i++) {
			System.out.printf("%d. %s\n", shopList.get(i).getItemCode(), shopList.get(i).getName());
		}
	}

	private Item copyItem(Item item) {

		int rCode = itemManager.rCode();

		if (item.getType() == Item.WEAPON) {
			ItemWeapon weapon = (ItemWeapon) item;
			int atk = weapon.getPlusAtk();

			ItemWeapon copy = new ItemWeapon(rCode, atk);
			return copy;

		} else if (item.getType() == Item.ARMOUR) {
			ItemArmour armour = (ItemArmour) item;
			int def = armour.getPlusDef();

			ItemArmour copy = new ItemArmour(rCode, def);
			return copy;

		} else if (item.getType() == Item.RING) {
			ItemRing ring = (ItemRing) item;

			int atk = ring.getPlusAtk();
			int def = ring.getPlusDef();

			ItemRing copy = new ItemRing(rCode, atk, def);
			return copy;

		} else if (item.getType() == Item.POTION) {
			ItemPotion potion = (ItemPotion) item;

			int healing = potion.getHealing();

			ItemPotion copy = new ItemPotion(rCode, healing);
			return copy;

		}

		return null;

	}

}
