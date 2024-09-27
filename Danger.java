import mayflower.*;
/**
 * Write a description of class Danger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Danger extends Actor
{
    int respawnX;
    int respawnY;
    
    public Danger(int width, int height, int x, int y, String image)
    {
        MayflowerImage img = new MayflowerImage(image);
        img.crop(0,0,width,height);
        setImage(img);
        respawnX = x;
        respawnY = y;
    }
        
    public void act()
    {
        if(isTouching(Cat.class) || isTouching(Dog.class))
        {
           playerEnter();
        }   
    }
    
    public void playerEnter()
    {
        MovableAnimatedActor player =  getOneIntersectingObject(MovableAnimatedActor.class);
        World w = getWorld();
        player.decreaseLives(1);
        respawn(player);
        w.removeObject(this);
    }
    
    public void respawn(MovableAnimatedActor player)
    {
        player.setLocation(respawnX, respawnY);
    }
}
