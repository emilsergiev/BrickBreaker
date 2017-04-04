package brickbreaker.source;

class FreeGift extends GameObject implements Commons {
	FreeGift() {
		super();
		x = 240;
		y = 5;
		setImage(GIFT);
	}

	@Override
	public void move() {
		y++;
	}
}
