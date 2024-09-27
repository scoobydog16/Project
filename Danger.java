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
        setImage("img/NolanStuff/Empty.png");
    }
        
    public void act()
    {
        if(isTouching(Cat.class) || isTouching(Dog.class))
        {
           MovableAnimatedActor c =  getOneIntersectingObject(MovableAnimatedActor.class);
           World w = getWorld();
           c.decreaseLives(1);
           w.removeObject(this);
           
        }   
    }
}
