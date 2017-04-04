package brickbreaker.source;

import java.awt.event.KeyEvent;

class Paddle extends GameObject implements Commons
{
	private static int dx;

	Paddle()
	{
		super();
		x = PADDLE_X;
		y = PADDLE_Y;
		setImage(PADDLE);
	}

	@Override
	public void move()
	{
		x += dx;

		if (x <= 0)
		{
			x = 0;
		}

		if (x >= WIDTH - width)
		{
			x = WIDTH - width;
		}
	}

	void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			dx = -PADDLE_SPEED;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			dx = PADDLE_SPEED;
		}
	}

	void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			dx = 0;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			dx = 0;
		}
	}
}
