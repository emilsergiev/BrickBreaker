package brickbreaker.classes;

import java.util.TimerTask;

public class Animate extends TimerTask
{
	Board gameBoard;

	protected Animate(Board board)
	{
		super();
		gameBoard = board;
	}

	@Override
	public void run()
	{
		gameBoard.update();
		gameBoard.repaint();
	}
}
