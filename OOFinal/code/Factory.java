
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Factory implements IFactory
{
	private static IFactory m_instance;
	private int hero_type;
	private int enemyA_type;
	private int enemyB_type;
	private int view_type;
  
	public static IFactory getInstance()
	{
		if (m_instance == null)
			m_instance = new Factory();
		return m_instance;
	}
  
	private Factory()
	{
		Random r = new Random();
		try
		{
			Scanner s = new Scanner(new File("../options.txt"));
			while (s.hasNextLine())
			{
				String line = s.nextLine().trim();
				String[] tokens = line.split(":");
				if (tokens.length > 1 && !line.contains("#") && !line.equals(""))
				{
					if (tokens[0].equals("hero"))
						hero_type = Integer.parseInt(tokens[1]);
					else if (tokens[0].equals("enemyA"))
						enemyA_type = Integer.parseInt(tokens[1]);
					else if (tokens[0].equals("enemyB"))
						enemyB_type = Integer.parseInt(tokens[1]);
					else if (tokens[0].equals("view"))
						view_type = Integer.parseInt(tokens[1]);
				}
				if (hero_type == 0) hero_type = r.nextInt(3) + 1;
				if (enemyA_type == 0) enemyA_type = r.nextInt(4) + 1;
				if (enemyB_type == 0) enemyB_type = r.nextInt(4) + 1;
				if (view_type == 0) view_type = r.nextInt(2) + 1;		
			}
			s.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public IGameObject createEnemy(char type, int x, int y)
	{
		IGameObject enemy;
		int enemy_type = enemyA_type;
		if (type == 'B') enemy_type = enemyB_type;
		switch (enemy_type)
		{
		case 1:
			enemy = new Ball(x, y);
			break;
		case 2:
			enemy = new Ghost(x, y);
			break;
		case 3:
			enemy = new Trump(x, y);
			break;
		case 4:
			enemy = new Hillary(x, y);
			break;
		default:
			enemy = new Ball(x, y);
			System.out.println("Invalid enemy type, loading Ball...");
			break;
		}
		return enemy;
	}
	  
	@Override
	public Hero createHero(List<IGameObject> objects, int x, int y)
	{
		Hero hero;
		switch (hero_type)
		{
		case 1:
			hero = new Pepe(x, y);
			break;
		case 2:
			hero = new Sanic(x, y);
			break;	
		case 3:
			hero = new Elf(x, y);
			break;
		default:
			hero = new Elf(x, y);
			System.out.println("Invalid hero type, loading Elf...");
			break;
		}
		hero.setObjects(objects);
		return hero;
	}
	
	@Override
	public IGameView createMainView(Hero hero, List<IGameObject> objects)
	{
		return new GameView(hero, objects);
	}
	
	@Override
	public IGameView createStatusView(Hero hero, List<IGameObject> objects)
	{
		IGameView view;
		switch (view_type)
		{
		case 1:
			view = new BarView(hero, objects);
			break;
		case 2:
			view = new NumberView(hero, objects);
			break;
		default:
			view = new BarView(hero, objects);
			System.out.println("Invalid view type, loading Bar View...");
			break;
		}
		return view;
	}
	
	@Override
	public IGameController createController(int interval, Hero hero, List<IGameObject> objects, List<IGameView> views)
	{
		return new GameController(interval, hero, objects, views);
	}
}
