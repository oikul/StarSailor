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

public class PlayMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image background;
	private Label title;
	private Button play, back;

	public PlayMenu(String bg) {
		background = ResourceHandler.getImage(bg);
		this.setLayout(null);
		int width = InputHandler.screenSize.width / 2, height = InputHandler.screenSize.height / 8;
		int x = (int) (InputHandler.midPoint.x / 2 - (width / 2)), y = (int) (InputHandler.midPoint.y / 2 - (height / 2));
		title = new Label("Play", "Verdana", Font.BOLD, 70, Color.white, x, y, width, height);
		width = InputHandler.screenSize.width / 10;
		height = InputHandler.screenSize.height / 14;
		x = (int) (InputHandler.midPoint.x / 2 - (width / 2));
		y = (int) ((InputHandler.midPoint.y/2) * 3 - (height / 2));
		play = new Button("play", x, y, width, height);
		x = (int) ((InputHandler.midPoint.x / 2) * 3 - (width / 2));
		back = new Button("Back", x, y, width, height);
		this.add(title);
		this.add(play);
		this.add(back);
	}

	public int update(float time) {
		if(play.buttonPressed()){
			
		}
		return 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height, null);
	}

}
