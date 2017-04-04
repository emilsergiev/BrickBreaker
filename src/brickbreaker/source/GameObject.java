package brickbreaker.source;

import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;

abstract class GameObject
{
	int x;
	int y;
	int width;
	int height;
	Image image;
	boolean destroyed;

	GameObject()
	{
		destroyed = false;
	}

	void setX(int x)
	{
		this.x = x;
	}

	int getX()
	{
		return x;
	}

	void setY(int y)
	{
		this.y = y;
	}

	int getY()
	{
		return y;
	}

	void setWidth(int width)
	{
		this.width = width;
	}

	int getWidth()
	{
		return width;
	}

	void setHeight(int height)
	{
		this.height = height;
	}

	int getHeight()
	{
		return height;
	}

	Rectangle getRect()
	{
		return new Rectangle(x, y, width, height);
	}

	Rectangle getLeft()
	{
		return new Rectangle(x - 1, y, 1, height);
	}

	Rectangle getRight()
	{
		return new Rectangle(x + width + 1, y, 1, height);
	}

	boolean isDestroyed()
	{
		return destroyed;
	}

	void setDestroyed(boolean destroyed)
	{
		this.destroyed = destroyed;
	}

	void setImage(String img)
	{
		ImageIcon ii = new ImageIcon(getURL(img));
		image = ii.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	URL getURL(String filename)
	{
		URL url = null;
		try { url = this.getClass().getResource(filename); }
		catch (Exception e) { e.printStackTrace(); }
		return url;
	}
}
