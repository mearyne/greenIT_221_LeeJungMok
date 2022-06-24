package stage;

public abstract class Stage { // 제각기 스테이지들의 부모클래스
	public static final int QUIT = 0;
	public static final int FOREST = 1;
	public static final int SHOP = 2;
	public static final int INVENTORY = 3;
	public static final int BATTLE = 9;
	
	private String name;

	public Stage(String name) {
		this.name = name;
	}

	public abstract void play(); // 스테이지를 실행했을때 작동됨

	public abstract void init(); // 스테이치를 불러올때 초기화 시킬것들을 초기화 시키는 메소드

	public String getName() {
		return name;
	}

}
