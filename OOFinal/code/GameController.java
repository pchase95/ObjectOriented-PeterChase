

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.applet.*;

import javax.swing.Timer;

public class GameController implements ActionListener, IGameController, KeyListener, MouseListener
{
	private AudioClip tunuk = Applet.newAudioClip(getClass().getResource("tunuk.wav"));
	private static java.util.Random r = new java.util.Random();
	private Timer m_timer;
	private List<IGameObject> m_objects;
	private List<IGameView> m_views;
	private Hero m_hero;
	private int m_tick = 0;
	private int difficulty = 30 * 7;
	
	public GameController(int interval, Hero hero, List<IGameObject> objects, List<IGameView> views)
	{
		m_hero = hero;
		m_objects = objects;
		m_views = views;
		m_timer = new Timer(interval, this);
		views.get(0).getJPanel().addKeyListener(this);
		views.get(0).getJPanel().addMouseListener(this);
	}

	@Override
	public void startGame()
	{
		tunuk.loop();
		m_timer.start();
	}
	
	private void killObjects(List<IGameObject> objects)
	{
		for (IGameObject obj : objects)
			m_objects.remove(obj);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		List<IGameObject> dead_objects = new ArrayList<>();
		m_tick++;
		for (IGameObject obj : m_objects)
		{
			
			if (!obj.isDead())
				obj.tick(m_views.get(0).getWidth(), m_views.get(0).getHeight());
			else
				dead_objects.add(obj);
		}
		
		killObjects(dead_objects);
		if (!m_hero.isDead())
			m_hero.tick(m_views.get(0).getWidth(), m_views.get(0).getHeight());
		else
			tunuk.stop();
		
		for (IGameView obj : m_views)
		{
			obj.tick();
		}
				
		if (difficulty != 0 && m_tick % difficulty == 0 && m_objects.size() < 10)
		{
			if (difficulty >= 85)
				difficulty *= .9;
			boolean e_type = r.nextBoolean();
			if (e_type)
			{
				m_objects.add(Factory.getInstance().createEnemy(
					'A', r.nextInt(m_views.get(0).getWidth() - 20), m_views.get(0).getHeight() - 20)
				);
			}
			else
			{
				m_objects.add(Factory.getInstance().createEnemy(
					'B', r.nextInt(m_views.get(0).getWidth() - 20), m_views.get(0).getHeight() - 20)
				);				
			}
		}
	}
	
	

	@Override
	public void keyPressed(KeyEvent e)
	{
		m_hero.keyPressed(e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e)
	{
		m_hero.keyReleased(e.getKeyChar());
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		m_hero.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		m_hero.mouseReleased(e);
	}
}
