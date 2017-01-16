package menu;

import java.awt.Color;
import java.awt.Font;

import handlers.InputHandler;
import main.State;
import menus.Button;
import menus.Label;
import menus.Menu;

public class PlayMenu extends Menu {

	private static final long serialVersionUID = 1L;
	private Label title;
	private Button play, back;

	public PlayMenu(String bg) {
		super(bg);
		this.setLayout(null);
		int width = InputHandler.screenSize.width / 2, height = InputHandler.screenSize.height / 8;
		int x = (int) (InputHandler.midPoint.x / 2 - (width / 2)),
				y = (int) (InputHandler.midPoint.y / 2 - (height / 2));
		title = new Label("Play", "Verdana", Font.BOLD, 70, Color.white, x, y, width, height);
		width = InputHandler.screenSize.width / 10;
		height = InputHandler.screenSize.height / 14;
		x = (int) (InputHandler.midPoint.x / 2 - (width / 2));
		y = (int) ((InputHandler.midPoint.y / 2) * 3 - (height / 2));
		play = new Button("play", x, y, width, height);
		x = (int) ((InputHandler.midPoint.x / 2) * 3 - (width / 2));
		back = new Button("Back", x, y, width, height);
		this.add(title);
		this.add(play);
		this.add(back);
	}

	public int update(float time) {
		if (play.buttonPressed()) {
			return State.PLAY;
		}
		if(back.buttonPressed()){
			return State.MAIN;
		}
		return 0;
	}

}
