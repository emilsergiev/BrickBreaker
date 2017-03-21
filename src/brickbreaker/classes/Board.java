package brickbreaker.classes;

import javax.swing.JPanel;

public class Board extends JPanel implements Commons
{
	private static final long serialVersionUID = 1L;

	protected Board()
	{
		initBoard();
		initGame();
	}

	private void initBoard()
	{
		//TODO init stuff...
	}

	private void initGame()
	{
		setBricks();
		//TODO set the ball and paddle
	}

	private void setBricks()
	{
		//TODO set the bricks...
	}

	protected void update()
	{
		//TODO the game logic here...
	}
}
