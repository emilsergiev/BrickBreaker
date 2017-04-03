package brickbreaker.test;

import org.junit.Assert;
import org.junit.Test;

import brickbreaker.classes.Ball;

public class BallMovementTest {
	@Test
	public void testBallMovement () {
		Ball ball = new Ball();
		ball.moveBall();
		Assert.assertEquals(252, ball.getX());
		Assert.assertEquals(352, ball.getY());
	}
	
	@Test
	public void testBallReflectionMovement () {
		Ball ball = new Ball();
		ball.moveBall();
		for (int i = 0; i < 250; i++) {
			ball.moveBall();
		}
		Assert.assertTrue(ball.getX() > 0);;
		Assert.assertTrue(ball.getY() > 0);
	}
	
}
