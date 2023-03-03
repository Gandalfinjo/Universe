package simulator;

public class Generator extends Thread {
	private Svemir svemir;
	
	public Generator(Svemir svemir) {
		this.svemir = svemir;
	}
	
	@Override
	public void run() {		
		try {
			while (!isInterrupted()) {
				int x = (int)(Math.random() * 201);
				int r = 10 + (int)(Math.random() * 21);
				Kometa kometa = new Kometa(x, 0, r);
				svemir.dodajTelo(kometa);
				sleep(900);
			}
		} catch (InterruptedException e) {}
	}
	
}
