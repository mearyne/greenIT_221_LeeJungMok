package rpg_final_test;

public abstract class Stage { // 제각기 스테이지들의 부모클래스
	
	public abstract void play(); // 스테이지를 실행했을때 작동됨
	
	public abstract void init(); // 스테이치를 불러올때 초기화 시킬것들을 초기화 시키는 메소드
	
	
}
