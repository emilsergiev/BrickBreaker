package brickbreaker.classes;

public class FreeGift extends GameObject
{
	protected FreeGift()
	{
		x = 240;
		y = 5;

		setImage("/brickbreaker/resources/gift.png");
	}

	protected void move()
	{
		y++;
	}
}
