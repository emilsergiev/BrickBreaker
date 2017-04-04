package brickbreaker.source;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Breakout game = new Breakout();
				game.setVisible(true);
			}
		});
	}
}
