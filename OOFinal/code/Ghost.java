public class Ghost extends GameObject
{
	private static java.util.Random r = new java.util.Random();
	public Ghost(int x, int y)
	{
		super("../images/blinky.png", "Ghost", x, y, 30, 30);
		m_dX = 7;
	}

	@Override
	public void tickCallback(int maxw, int maxh)
	{
		if (m_x >= maxw - 5)
		{
			m_y = r.nextInt(maxh);
		}
	}
}
