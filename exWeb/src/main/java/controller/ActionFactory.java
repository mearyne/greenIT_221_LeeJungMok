package controller;

public class ActionFactory {
	
	// 공장도 여러개 있을 필요가 없기 때문에 싱글톤 패턴 사용함
	
	private ActionFactory() {
		// TODO Auto-generated constructor stub
	}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if (command.equals("join")) action = new JoinAction();
		else if (command.equals("login")) action = null;
		else if (command.equals("logout")) action = null;
		else if (command.equals("writeBoard")) action = null;
		else if (command.equals("")) action = null;
		else if (command.equals("login")) action = null;
		else if (command.equals("login")) action = null;
		
		return action;
	}
	
}
