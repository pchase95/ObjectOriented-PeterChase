import java.applet.*;

public class Elf extends Hero
{
	private AudioClip elf = Applet.newAudioClip(getClass().getResource("elf.wav"));
	private final int max_width = m_w * 3;
	private final int max_height = m_h * 3;
	private final int std_width = m_w;
	private final int std_height = m_h;
	private boolean growing = false;
	private boolean shrinking = false;
	public Elf(int x, int y)
	{
		super("../images/elf.png", "Elf", x, y, 40, 40, 5 * 30);
	}

	@Override
	public void keyPressedCallback(char ch)
	{
		if (ch == ' ' && m_cd == 0 && !m_dead)
		{
			elf.play();
			growing = true;
			m_cd = m_cdlength;
		}
	}

	@Override
	public void tickCallback(int maxw, int maxh)
	{
		if (growing || shrinking)
			invulnerable = true;
		else
			invulnerable = false;
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
			}
		}
	}

}
