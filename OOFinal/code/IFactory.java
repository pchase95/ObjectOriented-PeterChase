

import java.util.List;

public interface IFactory
{
	public IGameObject createEnemy(char type, int x, int y);

	public Hero createHero(List<IGameObject> objects, int x, int y);

	public IGameView createMainView(Hero hero, List<IGameObject> objects);

	public IGameView createStatusView(Hero hero, List<IGameObject> objects);

	public IGameController createController(int interval, Hero hero, List<IGameObject> objects, List<IGameView> views);
}
