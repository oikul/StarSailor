package main;

import utils.AbstractMain;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 1L;

	@Override
	public void initialise() {
		running = true;
		this.setTitle("Star Sailor");
	}

	@Override
	public void update(float time) { 
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
