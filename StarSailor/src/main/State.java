package main;

public class State {
	
	public static STATE state = STATE.MENU_MAIN;

	public static enum STATE {
		MENU_MAIN, MENU_PLAY, MENU_CONNECT, MENU_CHARACTERCREATOR, MENU_INVENTORY,
		GAME_GALAXY, GAME_SOLAR, GAME_PLANETARY, GAME_MOON, GAME_SURFACE, GAME_BATTLE
	};
	
	public static void changeState(STATE s){
		state = s;
	}

}
