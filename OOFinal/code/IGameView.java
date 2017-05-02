

import javax.swing.JPanel;

public interface IGameView
{
	public void tick();

	public int getWidth();

	public int getHeight();

	public JPanel getJPanel();
}
