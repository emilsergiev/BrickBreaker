package brickbreaker.classes;

public class Brick extends GameObject
{
	private boolean powerup;

	Brick(int x, int y, String img)
	{
		super();
		this.x = x;
		this.y = y;
		setImage(img);
		setPowerup(false);
	}

	boolean isPowerup()
	{
		return powerup;
	}

	void setPowerup(boolean powerup)
	{
		this.powerup = powerup;
	}
}
