package brickbreaker.source;

public interface Commons {
	int WALL = 38;
	int WIDTH = 500;
	int HEIGHT = 700;
	int BOTTOM = 650;
	int MESSAGE_X = 130;
	int MESSAGE_Y = 300;
	int PADDLE_X = 200;
	int PADDLE_Y = 600;
	int PADDLE_SPEED = 3;
	int BALL_X = 230;
	int BALL_Y = 580;
	int BALL_SPEED = 2;
	int DELAY = 1000;
	int PERIOD = 10;
	String BALL = "/brickbreaker/images/ball.png";
	String BRICK = "/brickbreaker/images/brick.png";
	String PADDLE = "/brickbreaker/images/paddle.png";
	String FAST_BALL = "/brickbreaker/images/fast-ball.png";
	String BRICK_SPIDER = "/brickbreaker/images/brick-spider.png";
	String GIFT = "/brickbreaker/images/gift.png";
	String SPIDER = "/brickbreaker/images/spider.png";

	void move();
}
