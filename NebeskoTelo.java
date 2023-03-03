package simulator;

import java.awt.Color;

public abstract class NebeskoTelo extends Objekat {
	protected int r;
	protected boolean nacrtano = false;

	public NebeskoTelo(int x, int y, Color color, int r) {
		super(x, y, color);
		this.r = r;
	}
	
	public int dohvatiR() {
		return r;
	}
	
	public boolean nacrtano() {
		return nacrtano;
	}
	
	public void nacrtaj() {
		nacrtano = true;
	}

}
