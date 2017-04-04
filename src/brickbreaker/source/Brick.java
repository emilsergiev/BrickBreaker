package brickbreaker.source;

class Brick extends GameObject {
	private boolean spider;

	Brick(int x, int y, String img) {
		super();
		this.x = x;
		this.y = y;
		setImage(img);
		setSpider(false);
	}

	boolean isSpider() {
		return spider;
	}

	void setSpider(boolean spider) {
		this.spider = spider;
	}
}
