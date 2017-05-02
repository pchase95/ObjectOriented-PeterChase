
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public interface IGameObject
{	
	public void tick(int maxw, int maxh);
	
	public void tickCallback(int maxw, int maxh);

	public BufferedImage getImage();

	public Rectangle getRectangle();

	public int getX();

	public int getY();

	public int getW();

	public int getH();

	public int getDX();

	public int getDY();
	
	public String getName();
	
	public void kill();
	
	public boolean isDead();
}
