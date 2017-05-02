

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class GameObject implements IGameObject
{
	protected BufferedImage m_image;
	protected int m_x;
	protected int m_y;
	protected int m_w;
	protected int m_h;
	protected int m_dX; // x velocity in pixels per interval
	protected int m_dY; // y velocity in pixels per interval
	protected int m_ticks;
	protected boolean m_dead;
	protected String m_name;

	public GameObject(String image, String name, int x, int y, int w, int h)
	{
		m_dead = false;
		m_ticks = 0;
		m_x = x;
		m_y = y;
		m_w = w;
		m_h = h;
		m_dX = m_dX = 0;
		m_name = name;
		try
		{
			m_image = ImageIO.read(new File(image));
		}
		catch (IOException ex)
		{
			throw new Error(ex);
		}
	}
	
	public abstract void tickCallback(int maxw, int maxh);

	@Override
	public void tick(int maxw, int maxh)
	{
		m_ticks++;
		
		m_x = m_x + m_dX;
		m_y = m_y + m_dY;

		if (m_x > maxw)
			m_x = 0;
		else if (m_x < 0)
			m_x = maxw;

		if (m_y > maxh)
			m_y = 0;
		else if (m_y < 0)
			m_y = maxh;

		tickCallback(maxw, maxh);
	}

	@Override
	public BufferedImage getImage()
	{
		return m_image;
	}

	@Override
	public Rectangle getRectangle()
	{
		return new Rectangle(m_x, m_y, m_w, m_h);
	}

	@Override
	public int getX()
	{
		return m_x;
	}

	@Override
	public int getY()
	{
		return m_y;
	}

	@Override
	public int getW()
	{
		return m_w;
	}

	@Override
	public int getH()
	{
		return m_h;
	}

	@Override
	public int getDX()
	{
		return m_dX;
	}

	@Override
	public int getDY()
	{
		return m_dY;
	}
	
	@Override
	public String getName()
	{
		return m_name;
	}
	
	@Override
	public void kill()
	{
		m_dead = true;
	}
	
	@Override
	public boolean isDead()
	{
		return m_dead;
	}
}
