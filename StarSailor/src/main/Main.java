package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import galaxy.Galaxy;
import handlers.InputHandler;
import menu.ConnectMenu;
import menu.HostMenu;
import menu.MainMenu;
import menu.PlayMenu;
import menus.Menu;
import utils.AbstractMain;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 1L;
	private static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	public static float ratio;
	private Menu mainMenu, playMenu, hostMenu, connectMenu;
	private Galaxy galaxy;

	@Override
	public void initialise() {
		running = true;
		this.setTitle("Star Sailor");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		device.setFullScreenWindow(this);
		ratio = Math.min(InputHandler.screenSize.width, InputHandler.screenSize.height) / 14f / 16f;
		mainMenu = new MainMenu("backgrounds/space");
		this.add(mainMenu);
		this.setVisible(running);
	}

	@Override
	public void update(float time) {
		int switchState;
		switch (State.state) {
		case MENU_MAIN:
			switchState = mainMenu.update(time);
			if (switchState == State.PLAY) {
				playMenu = new PlayMenu("backgrounds/space");
				State.changeState(State.STATE.MENU_PLAY);
				this.remove(mainMenu);
				this.add(playMenu);
				this.setVisible(running);
			} else if (switchState == State.HOST) {
				hostMenu = new HostMenu("backgrounds/space");
				State.changeState(State.STATE.MENU_HOST);
				this.remove(mainMenu);
				this.add(hostMenu);
				this.setVisible(running);
			} else if (switchState == State.CONNECT) {
				connectMenu = new ConnectMenu("backgrounds/space");
				State.changeState(State.STATE.MENU_CONNECT);
				this.remove(mainMenu);
				this.add(connectMenu);
				this.setVisible(running);
			}
			break;
		case MENU_PLAY:
			switchState = playMenu.update(time);
			if(switchState == State.PLAY){
				
			}else if(switchState == State.MAIN){
				mainMenu = new MainMenu("backgrounds/space");
				State.changeState(State.STATE.MENU_MAIN);
				this.remove(playMenu);
				this.repaint();
				this.add(mainMenu);
				this.setVisible(true);
			}
			break;
		case MENU_HOST:
			break;
		case MENU_CONNECT:
			break;
		case GAME_GALAXY:
			break;
		default:
			break;
		}
	}

	@Override
	public void draw() {
		Graphics g = this.getGraphics();
		BufferedImage bImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) bImage.getGraphics();
		switch(State.state){
		case GAME_GALAXY:
			galaxy.draw(g2d);
			break;
		case GAME_SOLAR:
			galaxy.draw(g2d);
			break;
		case GAME_PLANETARY:
			galaxy.draw(g2d);
			break;
		case GAME_MOON:
			galaxy.draw(g2d);
			break;
		case GAME_SURFACE:
			galaxy.draw(g2d);
			break;
		case GAME_BATTLE:
			galaxy.draw(g2d);
			break;
		default:
			break;
		}
		g.drawImage(bImage, 0, 0, null);
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	@Override
	public void close() {
		this.dispose();
	}

}
