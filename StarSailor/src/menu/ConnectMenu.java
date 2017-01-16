package menu;

import java.awt.Color;
import java.awt.Font;

import handlers.InputHandler;
import menus.Button;
import menus.Label;
import menus.Menu;

public class ConnectMenu extends Menu {

	private static final long serialVersionUID = 1L;
	private Label title;
	private Button connect, back;

	public ConnectMenu(String bg) {
		super(bg);
		this.setLayout(null);
		int width = InputHandler.screenSize.width / 2, height = InputHandler.screenSize.height / 8;
		int x = (int) (InputHandler.midPoint.x / 2 - (width / 2)),
				y = (int) (InputHandler.midPoint.y / 2 - (height / 2));
		title = new Label("Connect", "Verdana", Font.BOLD, 70, Color.white, x, y, width, height);
		width = InputHandler.screenSize.width / 10;
		height = InputHandler.screenSize.height / 14;
		x = (int) (InputHandler.midPoint.x / 2 - (width / 2));
		y = (int) ((InputHandler.midPoint.y / 2) * 3 - (height / 2));
		connect = new Button("Connect", x, y, width, height);
		x = (int) ((InputHandler.midPoint.x / 2) * 3 - (width / 2));
		back = new Button("Back", x, y, width, height);
		this.add(title);
		this.add(connect);
		this.add(back);
	}

	public int update(float time) {
		if (connect.buttonPressed()) {
			
		}
		return 0;
	}

}
