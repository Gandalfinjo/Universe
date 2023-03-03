package simulator;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	protected int x, y;
	protected Color color;
	
	public Objekat(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int dohvatiX() {
		return x;
	}
	
	public int dohvatiY() {
		return y;
	}
	
	public Color dohvatiBoju() {
		return color;
	}
	
	public void promeniX(int pomeraj) {
		x += pomeraj;
	}
	
	public void promeniY(int pomeraj) {
		y += pomeraj;
	}
	
	public abstract void paint(Graphics g);
	
}
