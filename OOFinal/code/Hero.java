import java.awt.event.MouseEvent;
import java.util.List;

public abstract class Hero extends GameObject
{
	protected int m_cd;
	protected int m_cdlength;
	protected int m_kills = 0;
	protected boolean invulnerable = false;
	protected List<IGameObject> m_objects;

	public Hero(String image, String name, int x, int y, int w, int h, int cdlength)
	{
		super(image, name, x, y, w, h);
		m_cd = 0;
		m_cdlength = cdlength;
	}
	
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
		
		if (m_cd > 0)
			m_cd--;
		
		for (IGameObject go : m_objects)
			if (go.getRectangle().intersects(getRectangle()))
				if (invulnerable)
				{
					go.kill();
					m_kills++;
				}
				else
					kill();

		tickCallback(maxw, maxh);
	}
	
	public abstract void keyPressedCallback(char ch);
	
	public void keyPressed(char ch)
	{
		if (ch == 'a')
			m_dX = -5;
		if (ch == 's')
			m_dY = 5;
		if (ch == 'w')
			m_dY = -5;
		if (ch == 'd')
			m_dX = 5;
		
		keyPressedCallback(ch);
	}
	  
	public void keyReleased(char ch)
	{
		if (ch == 'a')
			m_dX = 0;
		if (ch == 's')
			m_dY = 0;
		if (ch == 'w')
			m_dY = 0;
		if (ch == 'd')
			m_dX = 0;
	}
	
	public void mousePressed(MouseEvent e) { }
	
	public void mouseReleased(MouseEvent e) { }
	
	public int getCooldown()
	{
		return m_cd;
	}
	
	public int getCooldownLength()
	{
		return m_cdlength;
	}

	public void setObjects(List<IGameObject> objects)
	{
		m_objects = objects;
	}

	public int getKills()
	{
		return m_kills;
	}
}
