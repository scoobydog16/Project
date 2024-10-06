import mayflower.*;

public class Ledge extends Actor
{
    /*
     * this class was used to generate a ledge with a trigger, it helps store a width variable
     */
    public int width;
    public Ledge(int w)
    {
        width = w;
    }
    public int getWidth()
    {
        return width;
    }
    public void act(){}
}
