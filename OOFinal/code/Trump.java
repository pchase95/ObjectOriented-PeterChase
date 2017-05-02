public class Trump extends GameObject
{
	private final int max_width = m_w * 3;
	private final int max_height = m_h * 3;
	private final int std_width = m_w;
	private final int std_height = m_h;
	private boolean growing = true;
	private boolean shrinking = false;
	private static java.util.Random r = new java.util.Random();
	public Trump(int x, int y)
	{
		super("../images/trump.png", "Trump", x, y, 30, 30);
		randomizeMovement();
	}

	@Override
	public void tickCallback(int maxw, int maxh)
	{
		if (m_ticks % (30 * 3) == 0)
		{
			randomizeMovement();
		}
		
		if (growing)
		{
			m_w += 2;
			m_h += 2;
			if (m_w >= max_width || m_h >= max_height)
			{
				m_w = max_width;
				m_h = max_height;
				growing = false;
				shrinking = true;
			}
		}
		
		else if (shrinking)
		{
			m_w -= 2;
			m_h -= 2;
			if (m_w <= std_width || m_h <= std_height)
			{
				m_w = std_width;
				m_h = std_height;
				shrinking = false;
				growing = true;
			}
		}
	}
	
	private void randomizeMovement()
	{		
		m_dX = r.nextInt(7) + 1;
		if (r.nextBoolean())
			m_dX *= -1;
		m_dY = r.nextInt(7) + 1;
		if (r.nextBoolean())
			m_dY *= -1;
	}
}
