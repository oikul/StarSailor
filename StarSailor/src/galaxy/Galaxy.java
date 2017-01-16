package galaxy;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import handlers.InputHandler;
import main.State;

public class Galaxy extends JPanel {

	private static final long serialVersionUID = 1L;
	private long seed;
	private int numOfStars = 512, maxPlanets = 12, maxMoons = 8, currentStar, currentPlanet, currentMoon;
	private Star[] galaxy = new Star[numOfStars];
	private Planet[][] solarSystems = new Planet[numOfStars][maxPlanets];
	private Planet[][][] planets = new Planet[numOfStars][maxPlanets][maxMoons];
	private boolean created = false;

	public Galaxy(long seed) {
		this.seed = seed;
		initialiseGalaxy();
	}

	public void initialiseGalaxy() {
		for (int i = 0; i < numOfStars; i++) {
			galaxy[i] = new Star(seed + (i * 15485863));
		}
		setCreated(true);
	}

	public void update(float time) {
		switch (State.state) {
		case GAME_GALACTIC:
			for (Star s : galaxy) {
				s.update(time);
			}
			break;
		case GAME_SOLAR:
			galaxy[currentStar].update(time);
			for (Planet p : solarSystems[currentStar]) {
				p.update(time);
			}
			break;
		case GAME_PLANETARY:
			solarSystems[currentStar][currentPlanet].update(time);
			for (Planet p : planets[currentStar][currentPlanet]) {
				p.update(time);
			}
			break;
		case GAME_LUNAR:
			planets[currentStar][currentPlanet][currentMoon].update(time);
			break;
		case GAME_SURFACE_PLANET:
			solarSystems[currentStar][currentPlanet].update(time);
			break;
		case GAME_SURFACE_MOON:
			planets[currentStar][currentPlanet][currentMoon].update(time);
			break;
		default:
			break;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height);
		switch(State.state){
		case GAME_GALACTIC:
			for (Star s : galaxy) {
				s.draw(g);
			}
			break;
		case GAME_SOLAR:
			break;
		case GAME_PLANETARY:
			break;
		case GAME_LUNAR:
			break;
		case GAME_SURFACE_PLANET:
			break;
		case GAME_SURFACE_MOON:
			break;
		case GAME_BATTLE:
			break;
		default:
			break;
		}
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}

}
