import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberView extends JPanel implements IGameView
{
	private int m_ticks = 0;
	private JLabel time_text = new JLabel("0 seconds");
	private JPanel enemy_status = new JPanel();
	private JLabel kills = new JLabel("Kills: ");
	private JLabel enemy_text = new JLabel("Enemies: 2/10");
	private JLabel m_status = new JLabel("Cooldown: xx/xx");
	private Hero m_hero;
	List<IGameObject> m_objects;

	public NumberView(Hero hero, List<IGameObject> objects)
	{
		m_objects = objects;
		m_hero = hero;
		setLayout(new BorderLayout());
		add(m_status, BorderLayout.WEST);
		
		enemy_status.setLayout(new BorderLayout());
		enemy_status.add(enemy_text, BorderLayout.WEST);
		enemy_status.add(time_text, BorderLayout.EAST);
		add(kills, BorderLayout.EAST);
		add(enemy_status, BorderLayout.NORTH);
	}

	@Override
	public void tick()
	{
		if (!m_hero.isDead())
		{
			m_ticks++;
			m_status.setText(String.format("Cooldown: %d/%d", m_hero.getCooldown(), m_hero.getCooldownLength()));
			String kill_taly = "";
			for (int i = 0; i < m_hero.getKills(); i++)
				kill_taly += "| ";
			kills.setText("Kills: " + kill_taly);
		}
		else
		{
			m_status.setText("Cooldown: xx/xx");
		}
		
		time_text.setText(String.format("%d seconds", m_ticks / 30));
		enemy_text.setText(String.format("Enemies: %d/10", m_objects.size()));
	}

	@Override
	public JPanel getJPanel()
	{
		return this;
	}
}
