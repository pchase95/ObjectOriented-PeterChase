

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	private static JFrame frame = null;
	public static void main(String args[])
	{
		restart();
	}
	
	public static void restart()
	{
		if (frame != null)
			frame.dispose();
		frame = new MainFrame();
		frame.setVisible(true);
	}

	public MainFrame()
	{
		super("Game Engine Example");
		setSize(800, 450);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// model
		List<IGameObject> objects = new ArrayList<IGameObject>();
		objects.add(Factory.getInstance().createEnemy('A', 10, 10));
		objects.add(Factory.getInstance().createEnemy('B', 100, 40));
		Hero hero = Factory.getInstance().createHero(objects, 400, 200);

		// view
		IGameView view = Factory.getInstance().createMainView(hero, objects);
		IGameView barView = Factory.getInstance().createStatusView(hero, objects);
		List<IGameView> views = new ArrayList<IGameView>();
		views.add(view);
		views.add(barView);

		// controller
		final int interval = 34;
		IGameController controller = Factory.getInstance().createController(interval, hero, objects, views);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(view.getJPanel(), BorderLayout.CENTER);
		getContentPane().add(barView.getJPanel(), BorderLayout.SOUTH);

		controller.startGame();
	}
}
