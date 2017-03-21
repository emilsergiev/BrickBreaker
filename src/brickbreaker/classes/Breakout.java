package brickbreaker.classes;

import javax.swing.JFrame;

public class Breakout extends JFrame
{
	private static final long serialVersionUID = 1L;

	protected Breakout()
	{
		initGUI();
	}

	private void initGUI()
	{
		add(new Board());
		setTitle("Brick Breaker - Breakout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Commons.WIDTH, Commons.HEIGTH);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
