import mayflower.*;

public class Water extends Danger
{
    
    boolean playerEnter;
    MayflowerImage image;
    public Water(int width, int height, int x, int y)
    {
        super(width, height, x, y, "img/NolanStuff/Water.png");
        image = new MayflowerImage("img/NolanStuff/Water.png");
        playerEnter = false;
    }


    public void act()
    {
        super.act();
        if(playerEnter)
            if(!isTouching(Dog.class))
                playerExit();
    }
    
    @Override public void playerEnter()
    {
        if(isTouching(Dog.class))
        {
            image.setTransparency(30);
            setImage(image);
        }
        
        if(isTouching(Cat.class))
        {
            Cat player = getOneInterceptingObject(Cat.class);
            player.decreaseLives(1);
            respawn(player);
        }
    }
    
    public void playerExit()
    {
        playerEnter = false;
        image.setTransparency(0);
        setImage(image);
    }
}
