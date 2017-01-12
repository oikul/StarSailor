package main;

public class State {
	
	public static STATE state = STATE.MENU_MAIN;

	public static enum STATE {
		MENU_MAIN, MENU_PLAY, MENU_CONNECT, MENU_CHARACTERCREATOR, MENU_INVENTORY
	};
	
	public static void changeState(STATE s){
		state = s;
	}

}
