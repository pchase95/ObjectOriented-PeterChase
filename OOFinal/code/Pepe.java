import java.awt.Point;
import java.awt.event.MouseEvent;
import java.applet.*;

public class Pepe extends Hero
{
	private AudioClip shot = Applet.newAudioClip(getClass().getResource("shot.wav"));
	public Pepe(int x, int y)
	{
		super("../images/pepe.png", "Pepe", x, y, 40, 40, 45);
	}
	
	public void mousePressed(MouseEvent e)
	{
		if (m_cd == 0 && !m_dead)
		{
			shot.play();
			for (IGameObject go : m_objects)
				if (go.getRectangle().contains(new Point(e.getX(), e.getY())))
				{
					go.kill();
					m_kills++;
				}
			
			m_cd = m_cdlength;
		}
	}

	@Override
	public void keyPressedCallback(char ch) { }

	@Override
	public void tickCallback(int maxw, int maxh) { }
}
