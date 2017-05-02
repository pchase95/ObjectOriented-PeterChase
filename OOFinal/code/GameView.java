import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JPanel implements IGameView
{
	private List<IGameObject> m_objects;
	private JLabel m_game_over = new JLabel("Game Over");
	private JButton m_play = new JButton("Play Again");
	private Hero m_hero;

	public GameView(Hero hero, List<IGameObject> objects)
	{
		m_game_over.setVisible(false);
		setOpaque(true);
		setIgnoreRepaint(true);
		setFocusable(true);
		requestFocusInWindow();
		m_objects = objects;
		m_hero = hero;
		m_play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				MainFrame.restart();
			}
		});
		m_play.setVisible(false);
		add(m_game_over);
		add(m_play);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Image bufferedImage = createImage(getWidth(), getHeight());
		Graphics2D buffer = (Graphics2D) bufferedImage.getGraphics();

		for (IGameObject obj : m_objects)
		{
			if (!obj.isDead())
				buffer.drawImage(obj.getImage(), obj.getX(), obj.getY(), obj.getW(), obj.getH(), this);
		}
		if (!m_hero.isDead())
			buffer.drawImage(m_hero.getImage(), m_hero.getX(), m_hero.getY(), m_hero.getW(), m_hero.getH(), this);
		else
		{
			m_game_over.setVisible(true);
			m_play.setVisible(true);
		}

		g.drawImage(bufferedImage, 0, 0, this);
	}

	@Override
	public void tick()
	{
		repaint();
	}

	@Override
	public JPanel getJPanel()
	{
		return this;
	}
}
