import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class BarView extends JPanel implements IGameView
{
	private int m_ticks = 0;
	private JLabel time_count = new JLabel("0");
	private JProgressBar enemy_bar;
	private JLabel kills = new JLabel("Kills: 0");
	private JPanel enemy_status = new JPanel();
	private JLabel enemy_text = new JLabel("Enemies:   ");
	private JLabel m_status = new JLabel("Cooldown: ");
	private JProgressBar cd_bar;
	private Hero m_hero;
	List<IGameObject> m_objects;

	public BarView(Hero hero, List<IGameObject> objects)
	{
		m_objects = objects;
		m_hero = hero;
		setLayout(new BorderLayout());
		add(m_status, BorderLayout.WEST);
		cd_bar = new JProgressBar(0, m_hero.getCooldownLength());
		add(cd_bar, BorderLayout.CENTER);
		add(kills, BorderLayout.EAST);
		
		enemy_bar = new JProgressBar(0, 10);
		enemy_status.setLayout(new BorderLayout());
		enemy_status.add(enemy_text, BorderLayout.WEST);
		enemy_status.add(enemy_bar, BorderLayout.CENTER);
		enemy_status.add(time_count, BorderLayout.EAST);
		add(enemy_status, BorderLayout.NORTH);
	}

	@Override
	public void tick()
	{
		if (!m_hero.isDead())
		{
			m_ticks++;
			cd_bar.setValue(m_hero.getCooldown());
		}
		else
		{
			cd_bar.setValue(0);
		}
		
		time_count.setText(Integer.toString(m_ticks / 30) + " seconds");
		kills.setText("Kills: " + m_hero.getKills());
		enemy_bar.setValue(m_objects.size());
	}

	@Override
	public JPanel getJPanel()
	{
		return this;
	}
}
