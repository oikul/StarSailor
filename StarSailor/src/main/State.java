package main;

public class State {
	
	public static STATE state = STATE.MENU_MAIN;
	
	public static final int MAIN = 1, PLAY = 2, HOST = 3, CONNECT = 4;

	public static enum STATE {
		MENU_MAIN, MENU_PLAY, MENU_HOST, MENU_CONNECT, MENU_INVENTORY,
		GAME_GALACTIC, GAME_SOLAR, GAME_PLANETARY, GAME_LUNAR, GAME_SURFACE_PLANET, GAME_SURFACE_MOON, GAME_BATTLE
	};
	
	public static void changeState(STATE s){
		state = s;
	}

}
