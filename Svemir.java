package simulator;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private ArrayList<NebeskoTelo> nebeskaTela = new ArrayList<>();
	
	public Svemir() {
		setBackground(Color.BLACK);
	}
	
	@Override
	public void paint(Graphics g) {
		for (NebeskoTelo telo : nebeskaTela) {
			telo.paint(g);
			telo.promeniY(5);
		}
	}
	
	public synchronized void dodajTelo(NebeskoTelo telo) {
		nebeskaTela.add(telo);
		notify();
	}

	@Override
	public void run() {
		try {
			while (nebeskaTela == null) 
				synchronized (this) {
					wait();
				}
			
			while (!Thread.interrupted()) {
				repaint();
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {}
	}

}
