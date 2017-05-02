import java.applet.*;

public class Sanic extends Hero
{
	private AudioClip sanic = Applet.newAudioClip(getClass().getResource("sanic.wav"));
	private final int speed = 5;
	private final int boost_speed = 15;
	private final int boost_duration = 30 * 2;
	private int boost = 0;
	private boolean boosting = false;

	public Sanic(int x, int y)
	{
		super("../images/sanic.png", "Sanic", x, y,  40, 40, 5 * 30);
	}
	
	@Override
	public void tickCallback(int maxw, int maxh)
	{
		boosting = boost > 0;
		if (boosting)
		{
			invulnerable = true;
			boost--;
			m_dX = Integer.signum(m_dX) * boost_speed;
			m_dY = Integer.signum(m_dY) * boost_speed;
		}
		else
		{
			invulnerable = false;
			m_dX = Integer.signum(m_dX) * speed;
			m_dY = Integer.signum(m_dY) * speed;
		}
		
	}

	@Override
	public void keyPressedCallback(char ch)
	{
		if (ch == ' ' && boost == 0 && m_cd == 0 && !m_dead)
		{
			sanic.play();
			boost = boost_duration;
			m_cd = m_cdlength;
		}
	}


}
