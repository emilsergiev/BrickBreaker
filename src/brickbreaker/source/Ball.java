package brickbreaker.source;

class Ball extends GameObject implements Commons
{
	private int xDir;
	private int yDir;
	private int speed;

	Ball()
	{
		super();
		x = BALL_X;
		y = BALL_Y;
		speed = BALL_SPEED;
		xDir = speed;
		yDir = -speed;
		setImage(BALL);
	}

	Ball(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
		speed = BALL_SPEED + 1;
		xDir = -speed;
		yDir = -speed;
		setImage(FAST_BALL);
	}

	@Override
	public void move()
	{
		x += xDir;
		y += yDir;

		if (x <= 0)
		{
			Sound.BOUNCE.play();
			setXdir(speed);
		}
		if (x >= WIDTH - width)
		{
			Sound.BOUNCE.play();
			setXdir(-speed);
		}
		if (y <= 0)
		{
			Sound.BOUNCE.play();
			setYdir(speed);
		}
	}

	int getXdir()
	{
		return xDir;
	}

	void setXdir(int x)
	{
		xDir = x;
	}

	int getYdir()
	{
		return yDir;
	}

	void setYdir(int y)
	{
		yDir = y;
	}

	int getSpeed()
	{
		return speed;
	}

	void setSpeed(int speed)
	{
		this.speed = speed;
	}
}
