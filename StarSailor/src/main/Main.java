package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import handlers.InputHandler;
import menu.ConnectMenu;
import menu.MainMenu;
import menu.PlayMenu;
import utils.AbstractMain;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 1L;
	private static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	public static float ratio;
	private MainMenu mainMenu;
	private ConnectMenu connectMenu;
	private PlayMenu playMenu;

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
		connectMenu = new ConnectMenu("backgrounds/space");
		playMenu = new PlayMenu("backgrounds/space");
		this.add(mainMenu);
		this.setVisible(running);
	}

	@Override
	public void update(float time) { 
		int r;
		switch(State.state){
		case MENU_CHARACTERCREATOR:
			break;
		case MENU_CONNECT:
			break;
		case MENU_INVENTORY:
			break;
		case MENU_MAIN:
			r = mainMenu.update(time);
			if(r == 1){
				this.remove(mainMenu);
				this.add(playMenu);
				this.setVisible(running);
				State.changeState(State.STATE.MENU_PLAY);
			}else if(r == 2){
				this.remove(mainMenu);
				this.add(connectMenu);
				this.setVisible(running);
				State.changeState(State.STATE.MENU_CONNECT);
			}
			break;
		case MENU_PLAY:
			break;
		default:
			break;
		}
	}

	@Override
	public void draw() {
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
