package brickbreaker.classes;

import javax.swing.ImageIcon;

public class Brick extends GameObject
{
	private boolean powerup;

	protected Brick(int x, int y, String img)
	{
		super();
		this.x = x;
		this.y = y;

		setImage(img);

		width = image.getWidth(null);
		height = image.getHeight(null);

		setDestroyed(false);
		setPowerup(false);
	}

	protected void setImage(String img)
	{
		ImageIcon ii = new ImageIcon(getURL(img));
		image = ii.getImage();
	}

	protected boolean isPowerup()
	{
		return powerup;
	}

	protected void setPowerup(boolean powerup)
	{
		this.powerup = powerup;
	}
}
