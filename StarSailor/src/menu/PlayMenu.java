package menu;

import java.awt.Color;
import java.awt.Font;
import generators.NameGenerator;
import handlers.InputHandler;
import handlers.MathHandler;
import main.State;
import menus.Button;
import menus.Label;
import menus.Menu;
import menus.TextBox;

public class PlayMenu extends Menu {

	private static final long serialVersionUID = 1L;
	private Label name, seed;
	private TextBox nameBox, seedBox;
	private Button play, back;

	public PlayMenu(String bg) {
		super(bg);
		this.setLayout(null);
		int width = InputHandler.screenSize.width / 10, height = InputHandler.screenSize.height / 14;
		int x = (int) (InputHandler.midPoint.x / 2 - (width / 2)),
				y = (int) (InputHandler.midPoint.y / 2 - (height / 2));
		name = new Label("Game Name: ", "Verdana", Font.BOLD, 20, Color.white, x, y, width, height);
		x = x + width;
		width = width * 4;
		height = InputHandler.screenSize.height / 20;
		y = (int) (InputHandler.midPoint.y / 2 - (height / 2));
		nameBox = new TextBox(NameGenerator.generateName(3), x, y, width, height);
		width = InputHandler.screenSize.width / 10;
		height = InputHandler.screenSize.height / 14;
		x = (int) (InputHandler.midPoint.x / 2 - (width / 2));
		y = y + height;
		seed = new Label("Seed: ", "Verdana", Font.BOLD, 20, Color.white, x, y, width, height);
		x = x + width;
		width = width * 4;
		height = InputHandler.screenSize.height / 20;
		seedBox = new TextBox("" + MathHandler.random.nextLong(), x, y, width, height);
		width = InputHandler.screenSize.width / 10;
		height = InputHandler.screenSize.height / 14;
		x = (int) (InputHandler.midPoint.x / 2 - (width / 2));
		y = (int) ((InputHandler.midPoint.y / 2) * 3 - (height / 2));
		play = new Button("play", x, y, width, height);
		x = (int) ((InputHandler.midPoint.x / 2) * 3 - (width / 2));
		back = new Button("Back", x, y, width, height);
		this.add(name);
		this.add(nameBox);
		this.add(seed);
		this.add(seedBox);
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
	
	public long getSeed(){
		return Long.parseLong(seedBox.getText());
	}

}
