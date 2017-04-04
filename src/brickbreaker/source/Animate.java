package brickbreaker.source;

import java.util.TimerTask;

class Animate extends TimerTask
{
	Board gameBoard;

	Animate(Board board)
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
