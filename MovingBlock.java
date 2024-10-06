import mayflower.*;
public class MovingBlock extends Block
{
    public MovingBlock()
    {
        
    }

    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        setLocation(x-5, y);
        if (x + w < 0)
            setLocation(7*122, 95*5);
    }
}
