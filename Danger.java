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
    
    /*
     * initialises the variables of respawn points and sets the image
     * and its height/width to the ones provided
     */
    public Danger(int width, int height, int x, int y, String image)
    {
        MayflowerImage img = new MayflowerImage(image);
        img.scale(width,height);
        setImage(img);
        respawnX = x;
        respawnY = y;
    }
        
    public void act()
    {
        //runs when it collides with either a cat or dog class object
        if(isTouching(Cat.class) || isTouching(Dog.class))
        {
           playerEnter();
        }   
    }
    
    /*
     * finds the player object it touched, it decreases a life from them, and then respawns them
     */
    public void playerEnter()
    {
        MovableAnimatedActor player =  getOneIntersectingObject(MovableAnimatedActor.class);
        player.decreaseLives(1);
        respawn(player);
    }
    
    /*
     * sets the player's position to the x and y corrodinants given, and scales them to match the screen's
     * size (800x600) from the string of tile's index (20x16)
     */
    public void respawn(MovableAnimatedActor player)
    {
        player.setLocation(respawnX * 40, respawnY * 40);
    }
}
