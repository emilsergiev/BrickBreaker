package brickbreaker.classes;

public class FreeGift extends GameObject
{
	FreeGift()
	{
		super();
		x = 240;
		y = 5;
		setImage("/brickbreaker/resources/gift.png");
	}

	void move()
	{
		y++;
	}
}
