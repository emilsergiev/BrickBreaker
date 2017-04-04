package brickbreaker.source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import javax.swing.JPanel;

class Board extends JPanel implements Commons
{
	private static final long serialVersionUID = 1L;
	private int ingame = 1;
	private int level = 1;
	private int score = 0;
	private int highScore;
	private boolean play;
	private boolean paused;
	private Timer timer;
	private Paddle paddle;
	private Random random = new Random();
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private ArrayList<Brick> bricks = new ArrayList<Brick>();
	private ArrayList<Spider> spiders = new ArrayList<Spider>();
	private String message = "Press <ENTER> to play";
	private FreeGift gift;

	Board()
	{
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new MyAdapter());
	}

	void playGame()
	{
		if (!play)
		{
			setBricks();
			timer = new Timer();
			timer.scheduleAtFixedRate(new Animate(this), DELAY, PERIOD);
			paddle = new Paddle();
			balls.add(new Ball());
			play = true;
		}
	}

	void setBricks()
	{
		for (int i = 0; i < 8; i++)
		{
			bricks.add(new Brick((i * 60 + 7), 50, BRICK));
		}
		for (int i = 0; i < 7; i++)
		{
			bricks.add(new Brick((i * 60 + 37), 75, BRICK));
		}
		for (int i = 0; i < 8; i++)
		{
			bricks.add(new Brick((i * 60 + 7), 100, BRICK));
		}
		for (int i = 0; i < 7; i++)
		{
			bricks.add(new Brick((i * 60 + 37), 125, BRICK));
		}
		for (int i = 0; i < 8; i++)
		{
			bricks.add(new Brick((i * 60 + 7), 150, BRICK));
		}
		for (int i = 0; i < 6; i++)
		{
			bricks.get(random.nextInt(WALL)).setSpider(true);
		}

		for (Brick b : bricks)
		{
			if (b.isSpider())
			{
				b.setImage(BRICK_SPIDER);
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Commons.WIDTH, Commons.HEIGHT);

		if (play)
		{
			drawObjects(g2d);
		}
		else
		{
			displayMessage(g2d);
		}
		g2d.dispose();
		Toolkit.getDefaultToolkit().sync();
	}

	private void displayMessage(Graphics2D g2d)
	{
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Verdana", Font.BOLD, 17));
		g2d.drawString(message, MESSAGE_X, MESSAGE_Y);
	}

	private void drawObjects(Graphics2D g2d)
	{
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Verdana", Font.BOLD, 17));
		g2d.drawString("Level: " + level, 5, 20);
		g2d.drawString("Score: " + score, 350, 20);

		g2d.drawImage(paddle.image, paddle.x, paddle.y, paddle.width, paddle.height, this);

		if (gift != null)
		{
			g2d.drawImage(gift.image, gift.x, gift.y, gift.width, gift.height, this);
		}

		for (Brick brick : bricks)
		{
			if (!brick.isDestroyed())
			{
				g2d.drawImage(brick.image, brick.x, brick.y, brick.width, brick.height, this);
			}
		}
		for (Ball ball : balls)
		{
			if (!ball.isDestroyed())
			{
				ball.move();
				g2d.drawImage(ball.image, ball.x, ball.y, ball.width, ball.height, this);
			}
		}
		for (Spider spider : spiders)
		{
			if (!spider.isDestroyed())
			{
				spider.move();
				g2d.drawImage(spider.image, spider.x, spider.y, spider.width, spider.height, this);
			}
		}
	}

	void update()
	{
		if (ingame <= 0)
		{
			endGame();
		}
		if (gift != null){
			gift.move();
			catchTheGift();
		}
		paddle.move();
		checkBrickCount();
		catchTheSpiders();
		checkBallCollisions();
	}

	private void catchTheGift()
	{
		if (gift.getRect().intersects(paddle.getRect()))
		{
			gift = null;
			for (Ball ball : balls) {
				if (ball.getSpeed() >= 3)
				{
					ball.setSpeed(BALL_SPEED);
					ball.setImage(BALL);
				}
				else if (paddle.width <= 50)
				{
					Sound.SIZEUP.play();
					paddle.setWidth(75);
				}
				else
				{
					score += 10;
				}
			}
		}
	}

	private void checkBrickCount()
	{
		int brickCount = 0;
		for (Brick brk : bricks)
		{
			if (brk.isDestroyed())
			{
				brickCount++;
			}
			if (brickCount == WALL)
			{
				score += 10;
				level++;
				bricks.clear();
				setBricks();
				giveFreeGift();
			}
		}
	}

	private void giveFreeGift()
	{
		if (gift == null)
		{
			gift = new FreeGift();
		}
		else
		{
			score += 20;
		}
	}

	private void catchTheSpiders()
	{
		for (Spider spider : spiders)
		{
			if (spider.getRect().intersects(paddle.getRect()) && !spider.isDestroyed())
			{
				spider.setDestroyed(true);
				if (spider.isExtraBall())
				{
					Sound.BOING.play();
					balls.add(new Ball(spider.getX(), spider.getY()));
				}
				else if (paddle.width < 125)
				{
					Sound.SIZEUP.play();
					paddle.setWidth(paddle.width + 25);
					ingame--;
				}
				else
				{
					Sound.BOING.play();
					balls.add(new Ball(spider.getX(), spider.getY()));
				}
			}
			if (spider.getRect().getMaxY() > BOTTOM && !spider.isDestroyed())
			{
				ingame--;
				spider.setDestroyed(true);
				if (paddle.width > 25){
					Sound.SIZEDOWN.play();
					paddle.setWidth(paddle.width - 25);
				}
			}
		}
	}

	private void checkBallCollisions()
	{
		for (Ball ball : balls)
		{
			if (ball.getRect().getMaxY() > BOTTOM && !ball.isDestroyed())
			{
				ball.setDestroyed(true);
				ingame--;
				if (paddle.width > 25){
					Sound.SIZEDOWN.play();
					paddle.setWidth(paddle.width - 25);
				}
			}
			if (ball.getRect().intersects(paddle.getRect()))
			{
				Sound.BOING.play();
				ball.setYdir(ball.getYdir() * -1);
				ball.setY(BALL_Y);
			}
			for (Brick brick : bricks)
			{
				if ((brick.getLeft().intersects(ball.getRect()) || brick.getRight().intersects(ball.getRect()))
						&& !brick.isDestroyed())
				{
					ball.setXdir(ball.getXdir() * -1);
					ball.move();
					score++;
					if (brick.isSpider())
					{
						Sound.BOUNCE.play();
						brick.setImage(BRICK);
						brick.setSpider(false);
						spiders.add(new Spider(brick.x, brick.y, getRandomBoolean()));
						ingame++;
					}
					else
					{
						Sound.BREAK.play();
						brick.setDestroyed(true);
					}
				}
				else if (ball.getRect().intersects(brick.getRect()) && !brick.isDestroyed())
				{
					ball.setYdir(ball.getYdir() * -1);
					ball.move();
					score++;
					if (brick.isSpider())
					{
						Sound.BOUNCE.play();
						brick.setImage(BRICK);
						brick.setSpider(false);
						spiders.add(new Spider(brick.x, brick.y, getRandomBoolean()));
						ingame++;
					}
					else
					{
						Sound.BREAK.play();
						brick.setDestroyed(true);
					}
				}
			}
		}
	}

	private boolean getRandomBoolean()
	{
		return random.nextBoolean();
	}

	private class MyAdapter extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e)
		{
			if (play)
			{
				paddle.keyReleased(e);
			}
		}
		@Override
		public void keyPressed(KeyEvent e)
		{
			if (play)
			{
				paddle.keyPressed(e);
			}

			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				if (!paused) { pause(); }
				else { resume(); }
			}

			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				playGame();
			}
		}
	}

	void pause()
	{
		if (play)
		{
			timer.cancel();
			paused = true;
		}
	}

	void resume()
	{
		timer = new Timer();
		timer.scheduleAtFixedRate(new Animate(this), DELAY, PERIOD);
		paused = false;
	}

	private void endGame()
	{
		highScore = score;
		score = 0;
		level = 1;
		ingame = 1;
		balls.clear();
		bricks.clear();
		spiders.clear();
		play = false;
		message = "Game Over! score: " + highScore;
		timer.cancel();
		timer.purge();
	}

	@Override
	public void move() {}
}
