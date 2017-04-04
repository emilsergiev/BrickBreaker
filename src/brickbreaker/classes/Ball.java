package brickbreaker.classes;

public class Ball extends GameObject {
	private int speedX;
	private int speedY;

	public Ball() {
		this.speedX = Commons.BALL_SPEED;
		this.speedY = Commons.BALL_SPEED;
		this.width = 15;
		this.height = 15;
		this.x = Commons.BALL_X;
		this.y = Commons.BALL_Y;	
	}

	public Ball(int x, int y) {
		this.speedX = 3;
		this.speedY = 3;
		this.width = 15;
		this.height = 15;
		this.x = x;
		this.y = y;
	}

	public void moveBall() {
		checkAndChangeXPosition();
		checkAndChangeYPosition();
	}

	public void checkAndChangeYPosition() {
		//check of the ball is out of bound
		if (y <= 0 || y >= Commons.HEIGHT - height) {
			speedY = -speedY;
		} 
		y += speedY;
	}

	public void checkAndChangeXPosition() {
		//check is ball is out of bound
		if (x <= 0 || x >= Commons.WIDTH - width) {
			speedX = - speedX;
		} 
		x += speedX;
	}
}
