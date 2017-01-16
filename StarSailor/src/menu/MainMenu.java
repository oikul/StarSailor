package menu;

import java.awt.Color;
import java.awt.Font;

import handlers.InputHandler;
import main.State;
import menus.Button;
import menus.Label;
import menus.Menu;

public class MainMenu extends Menu {

	private static final long serialVersionUID = 1L;
	private Label title;
	private Button play, host, connect, exit;

	public MainMenu(String bg) {
		super(bg);
		this.setLayout(null);
		int width = InputHandler.screenSize.width / 2, height = InputHandler.screenSize.height / 8;
		int x = (int) (InputHandler.midPoint.x - (width / 2)), y = (int) (InputHandler.midPoint.y / 2 - (height / 2));
		title = new Label("Star Sailor", "URW Chancery L", Font.PLAIN, 100, Color.white, x, y, width, height);
		width = InputHandler.screenSize.width / 10;
		height = InputHandler.screenSize.height / 14;
		x = (int) (InputHandler.midPoint.x - (width / 2));
		y = (int) ((InputHandler.midPoint.y / 5) * 4 - (height / 2));
		play = new Button("Play", x, y, width, height);
		y = (int) ((InputHandler.midPoint.y / 5) * 5 - (height / 2));
		host = new Button("Host", x, y, width, height);
		y = (int) ((InputHandler.midPoint.y / 5) * 6 - (height / 2));
		connect = new Button("Connect", x, y, width, height);
		y = (int) ((InputHandler.midPoint.y / 5) * 7 - (height / 2));
		exit = new Button("Exit", x, y, width, height);
		this.add(title);
		this.add(play);
		this.add(host);
		this.add(connect);
		this.add(exit);
	}

	@Override
	public int update(float time) {
		if (play.buttonPressed()) {
			return State.PLAY;
		}
		if (host.buttonPressed()) {
			return State.HOST;
		}
		if (connect.buttonPressed()) {
			return State.CONNECT;
		}
		if (exit.buttonPressed()) {
			System.exit(0);
		}
		return 0;
	}

}
