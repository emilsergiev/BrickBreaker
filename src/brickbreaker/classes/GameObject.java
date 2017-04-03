package brickbreaker.classes;

import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;

public class GameObject
{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Image image;
	protected boolean destroyed;

	protected void setX(int x)
	{
		this.x = x;
	}

	public int getX()
	{
		return x;
	}

	protected void setY(int y)
	{
		this.y = y;
	}

	public int getY()
	{
		return y;
	}

	protected void setWidth(int width)
	{
		this.width = width;
	}

	protected int getWidth()
	{
		return width;
	}

	protected void setHeight(int height)
	{
		this.height = height;
	}

	protected int getHeight()
	{
		return height;
	}

	protected Image getImage()
	{
		return image;
	}

	protected Rectangle getRect()
	{
		return new Rectangle(x, y, width, height);
	}

	protected boolean isDestroyed()
	{
		return destroyed;
	}

	protected void setDestroyed(boolean destroyed)
	{
		this.destroyed = destroyed;
	}

	protected URL getURL(String filename)
	{
		URL url = null;
		try { url = this.getClass().getResource(filename); }
		catch (Exception e) { e.printStackTrace(); }
		return url;
	}
}
