package brickbreaker.source;

class Spider extends GameObject implements Commons {
	private boolean extraBall;

	Spider(int x, int y, boolean extra) {
		super();
		this.x = x;
		this.y = y;
		setImage(SPIDER);
		setExtraBall(extra);
	}

	boolean isExtraBall() {
		return extraBall;
	}

	void setExtraBall(boolean extra) {
		extraBall = extra;
	}

	@Override
	public void move() {
		y++;
	}
}
