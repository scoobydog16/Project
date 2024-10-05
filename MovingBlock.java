import mayflower.*;
public class MovingBlock extends Block
{
    public MovingBlock()
    {
        setImage("img/longtile");
    }

    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        setLocation(x-5, y);
        if (getX() + getWidth() < 0)
            {
                setLocation(800, 200);
            }
    }
}
