import mayflower.*;

public class Water extends Danger
{
    
    boolean playerEnter;
    MayflowerImage image;
    public Water(int width, int height, int x, int y)
    {
        super(width, height, x, y, "img/Tiles/18.png");
        image = new MayflowerImage("img/Tiles/18.png");
        playerEnter = false;
    }


    public void act()
    {
        super.act();
        if(playerEnter)
            if(!isTouching(Dog.class))
            {
                System.out.println("left");
                playerExit();
            }
    }
    
    @Override public void playerEnter()
    {
        if(isTouching(Dog.class) && !playerEnter)
        {
            System.out.println("swimming");
            image.setTransparency(30);
            setImage(image);
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
        image.setTransparency(0);
        setImage(image);
    }
}
