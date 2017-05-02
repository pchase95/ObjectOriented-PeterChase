public class Hillary extends GameObject
{
	private static java.util.Random r = new java.util.Random();
	public Hillary(int x, int y)
	{
		super("../images/hillary.png", "Hillary", x, y, 30, 30);
		randomizeMovement();
	}

	@Override
	public void tickCallback(int maxw, int maxh)
	{
		if (m_ticks % (30) == 0)
		{
			randomizeMovement();
		}
		
		if (m_ticks % (30 * 3) == 0)
		{
			m_x = r.nextInt(maxw) -5;
			m_y = r.nextInt(maxh) -5;	
		}
	}

	private void randomizeMovement()
	{		
		m_dX = r.nextInt(12) + 1;
		if (r.nextBoolean())
			m_dX *= -1;
		m_dY = r.nextInt(12) + 1;
		if (r.nextBoolean())
			m_dY *= -1;
	}
}
