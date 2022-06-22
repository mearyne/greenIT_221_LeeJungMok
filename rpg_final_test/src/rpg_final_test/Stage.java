package rpg_final_test;

public abstract class Stage { // ������ ������������ �θ�Ŭ����
	public static final int QUIT = 0;
	public static final int FOREST = 1;
	public static final int SHOP = 2;
	public static final int INVENTORY = 3;
	public static final int BATTLE = 9;
	
	private String name;

	public Stage(String name) {
		this.name = name;
	}

	public abstract void play(); // ���������� ���������� �۵���

	public abstract void init(); // ������ġ�� �ҷ��ö� �ʱ�ȭ ��ų�͵��� �ʱ�ȭ ��Ű�� �޼ҵ�

	public String getName() {
		return name;
	}

}
