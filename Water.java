import mayflower.*;

public class Water extends Danger
{
    
    boolean playerEnter;
    
    public Water(int width, int height, int x, int y)
    {
        super(width, height, x, y, "img/NolanStuff/Empty.png");
        playerEnter = false;
    }


    public void act()
    {
        super.act();
    }
    
    public void playerEnter(MovableAnimatedActor player)
    {
        if(isTouching(Dog.class))
            System.out.print("hi");
    }
    
    public void playerExit()
    {
        playerEnter = false;
    }
}
