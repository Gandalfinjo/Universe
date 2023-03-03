package simulator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	private static final long serialVersionUID = 1L;
	private Svemir svemir = new Svemir();
	private Panel panel = new Panel();
	private Generator generator = new Generator(svemir);
	private Thread tsvemir = new Thread(svemir);
	
	private void populateWindow() {
		Button pokreni = new Button("Pokreni!");
		
		pokreni.addActionListener(ae -> {
			generator.start();
			tsvemir.start();
			pokreni.setEnabled(false);
		});
		
		panel.add(pokreni);
		
		add(panel, BorderLayout.SOUTH);
		add(svemir, BorderLayout.CENTER);
	}

	public Simulator() {
		setSize(200, 400);
		setResizable(false);
		populateWindow();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				generator.interrupt();
				tsvemir.interrupt();
				dispose();
			}
		});
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Simulator();
	}

}
