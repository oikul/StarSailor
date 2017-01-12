package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import handlers.InputHandler;
import handlers.ResourceHandler;
import menus.Button;
import menus.Label;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image background;
	private Label title;
	private Button play, connect, exit;
	private final int PLAY = 1, CONNECT = 2; 

	public MainMenu(String bg) {
		background = ResourceHandler.getImage(bg);
		this.setLayout(null);
		int width = InputHandler.screenSize.width / 2, height = InputHandler.screenSize.height / 8;
		int x = (int) (InputHandler.midPoint.x - (width / 2)), y = (int) (InputHandler.midPoint.y / 2 - (height / 2));
		title = new Label("Game Title", "Verdana", Font.BOLD, 100, Color.white, x, y, width, height);
		width = InputHandler.screenSize.width / 10;
		height = InputHandler.screenSize.height / 14;
		x = (int) (InputHandler.midPoint.x - (width / 2));
		y = (int) (InputHandler.midPoint.y - (height / 2));
		play = new Button("Play", x, y, width, height);
		y = (int) ((InputHandler.midPoint.y / 3) * 4 - (height / 2));
		connect = new Button("Connect", x, y, width, height);
		y = (int) ((InputHandler.midPoint.y / 3) * 5 - (height / 2));
		exit = new Button("Exit", x, y, width, height);
		this.add(title);
		this.add(play);
		this.add(connect);
		this.add(exit);
	}

	public int update(float time) {
		if(play.buttonPressed()){
			return PLAY;
		}
		if(connect.buttonPressed()){
			return CONNECT;
		}
		if(exit.buttonPressed()){
			System.exit(0);
		}
		return 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height, null);
	}

}
