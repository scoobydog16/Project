import mayflower.*;

public class Water extends Danger
{
    
    boolean playerEnter;
    MayflowerImage image;
    Image[] waterSprites;
    
    public Water(int width, int height, int x, int y, Image[] water)
    {
        super(width, height, x, y, "img/NolanStuff/Empty.png");
        waterSprites = water;
        playerEnter = false;
    }


    public void act()
    {
        super.act();
        if(playerEnter)
            if(!isTouching(Dog.class))
            {
                playerExit();
            }
    }
    
    @Override public void playerEnter()
    {
        if(isTouching(Dog.class) && !playerEnter)
        {
            for(Image a : waterSprites)
                a.getImage().setTransparency(30);
            playerEnter = true;
        }
        
        if(isTouching(Cat.class))
        {
            Cat player = getOneIntersectingObject(Cat.class);
            player.decreaseLives(1);
            respawn(player);
        }
    }
    
    public void playerExit()
    {
        playerEnter = false;
        for(Image a : waterSprites)
            a.getImage().setTransparency(0);
    }
}
