package galaxy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.Random;

import handlers.InputHandler;
import handlers.MathHandler;
import main.State;

public class Star {

	private int size;
	private double distance, angle;
	private Point2D.Double position;
	private Random random;
	private Color color;

	public Star(long seed) {
		random = new Random(seed);
		size = random.nextInt(3) + 1;
		distance = random.nextDouble() * 1000;
		angle = random.nextDouble() * 360;
		position = MathHandler.convertPolarToCartesian(angle, distance, InputHandler.midPoint.x,
				InputHandler.midPoint.y);
		color = chooseRandomColor(random.nextInt(15));
	}

	public void update(float time) {
		switch (State.state) {
		case GAME_GALACTIC:
			if(angle < 360.0){
				angle += 0.0001;
			}else{
				angle = 0;
			}
			position = MathHandler.convertPolarToCartesian(angle, distance, InputHandler.midPoint.x,
					InputHandler.midPoint.y);
			break;
		default:
			break;
		}
	}

	public void draw(Graphics g) {
		switch (State.state) {
		case GAME_GALACTIC:
			g.setColor(color);
			g.fillOval((int) position.x, (int) position.y, size, size);
			break;
		default:
			break;
		}
	}
	
	private Color chooseRandomColor(int c){
		if(c >= 0 && c < 6){
			return Color.white;
		}else if(c >= 6 && c < 8){
			return Color.yellow;
		}else if(c >= 8 && c < 10){
			return Color.orange;
		}else if(c >= 10 && c < 14){
			return Color.red;
		}else{
			return Color.cyan;
		}
	}

}
