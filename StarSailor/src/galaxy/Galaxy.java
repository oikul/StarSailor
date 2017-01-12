package galaxy;

import java.awt.Graphics;

import javax.swing.JPanel;

import main.State;

public class Galaxy extends JPanel {

	private static final long serialVersionUID = 1L;
	private long seed;
	private int numOfStars = 4096, maxPlanets = 12, maxMoons = 8, currentStar, currentPlanet, currentMoon;
	private Star[] galaxy = new Star[numOfStars];
	private Planet[][] solarSystems = new Planet[numOfStars][maxPlanets];
	private Planet[][][] planets = new Planet[numOfStars][maxPlanets][maxMoons];

	public Galaxy(long seed) {
		this.seed = seed;
	}
	
	private void initialiseGalaxy(){
		for(int i = 0; i < numOfStars; i++){
			galaxy[i] = new Star(seed);
		}
	}

	public void update(float time) {
		switch(State.state){
		case GAME_GALAXY:
			for(Star s:galaxy){
				s.update(time);
			}
		default:
			break;
		}
	}

	public void draw(Graphics g) {

	}

}
