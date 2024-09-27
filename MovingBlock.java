import mayflower.*;
public class MovingBlock extends Block
{
    public MovingBlock()
    {
        
    }

    public void act()
    {
        Timer animationTimer = new Timer(100000000); 
        int x = getX();
        int y = getY();
        int w = getWidth();
        setLocation(x-10, y);
    }
}
