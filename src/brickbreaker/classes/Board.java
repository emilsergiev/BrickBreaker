package brickbreaker.classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import javax.swing.JPanel;

public class Board extends JPanel implements Commons
{
	private static final long serialVersionUID = 1L;
	private String message = "Welcome ^.^";
	private static Timer timer;
	private Graphics2D g;
	private Paddle paddle;
	private boolean play;
	private int score = 0;
	private int level = 1;
	private int ingame = 1;

	Random random = new Random();

	ArrayList<Ball> balls = new ArrayList<Ball>();
	ArrayList<Brick> bricks = new ArrayList<Brick>();
	ArrayList<Spider> spiders = new ArrayList<Spider>();

	protected Board()
	{
		initBoard();
		initGame();
	}

	private void initBoard()
	{
		//TODO init stuff...

		//timer = new Timer();
		//timer.scheduleAtFixedRate(new Animate(this), 1000, 10);
	}

	private void initGame()
	{
		setBricks();
		//TODO set the ball and paddle
	}

	private void setBricks()
	{
		//TODO set the bricks...
	}

	protected void update()
	{
		//TODO the game logic here...
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		//TODO draw objects...

//		drawStart(g2d);

		displayMessage(g2d);
		
		g2d.dispose();
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void drawStart(Graphics2D g2d)
	{
		for (int i = 100; i > 0; i--)
		{
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, Commons.WIDTH, Commons.HEIGHT);
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("Courier New", Font.BOLD, i));
			g2d.drawString("Start!", Commons.WIDTH / 2 - i * 2 + 20, Commons.HEIGHT / 2);
			repaint();
			try { Thread.sleep(20); }
			catch (Exception e) { e.printStackTrace(); }
		}
	}

	private void displayMessage(Graphics2D g2d)
	{
		Font font = new Font("Verdana", Font.BOLD, 18);
		FontMetrics metr = this.getFontMetrics(font);
		g2d.setColor(Color.RED);
		g2d.setFont(font);
		g2d.drawString(message, (Commons.WIDTH - metr.stringWidth(message)) / 2, Commons.WIDTH / 2);
	}

	private boolean getRandomBoolean()
	{
		return random.nextBoolean();
	}

	protected void setPlay(boolean p)
	{
		play = p;
	}
}
