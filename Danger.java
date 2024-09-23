import mayflower.*;
/**
 * Write a description of class Danger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Danger extends Actor
{

    public Danger()
    {

    }
        
    public void act()
    {
        if(isTouching(Cat.class))
        {
           Cat c =  getOneIntersectingObject(Cat.class);
           World w = getWorld();
           w.removeObject(this);
           c.decreaseLives(1);
        }   
    }
}
