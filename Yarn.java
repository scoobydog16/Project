import mayflower.*;
public class Yarn extends Actor
{
    

    /**
     * Constructor for objects of class Yarn
     */
    public Yarn()
    {
        setImage("img/yarn.png");// initialise instance variables
       
    }

    public void act()
    {
       
            if(isTouching(Cat.class))
        {
            //This block of code will only execute if this Yarn is touching a
            // Cat object
            Object a = getOneIntersectingObject(Cat.class);
            // Now you can call Cat methods on the c variable
            Cat c = (Cat) a;
            World w = getWorld(); // get this Actor's World
            w.removeObject(this); // remove this Actor from the World
            c.increaseScore(1);
            
          
        }
    }
}
