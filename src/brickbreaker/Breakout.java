package brickbreaker;

import javax.swing.JFrame;

public class Breakout extends JFrame {

	public Breakout() {

		initGUI();
	}

	private void initGUI() {

		add(new Board());
		setTitle("Brick Breaker - Breakout");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
