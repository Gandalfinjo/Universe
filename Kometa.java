package simulator;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {
	private int petougaoX[] = new int[5];
	private int petougaoY[] = new int[5];
	private double random;
	private double ugao = 2 * Math.PI / 5;

	public Kometa(int x, int y, int r) {
		super(x, y, Color.GRAY, r);
		
		random = (Math.random() * 360 + 1);
		for (int i = 0; i < 5; i++) {
			petougaoX[i] = x + (int)(r * Math.cos(random * 2 * Math.PI / 4 - ugao * i));
			petougaoY[i] = y + (int)(r * Math.sin(random * 2 * Math.PI / 4 - ugao * i));
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(color);

		for (int i = 0; i < 5; i++)
			petougaoY[i] = y + (int)(r * Math.sin(random * 2 * Math.PI / 4 - ugao * i));
		
		g.drawPolygon(petougaoX, petougaoY, 5);
		g.fillPolygon(petougaoX, petougaoY, 5);
		
	}

}
