import mayflower.*;


public class Bomb extends Actor

{
    private int lives;

    
    public Bomb()
    {
        
        
    }

    
    public void act()
    {
       if(isTouching(Cat.class))
        {
            //This block of code will only execute if this Yarn is touching a
            // Cat object
            MovableAnimatedActor a = getOneIntersectingObject(MovableAnimatedActor.class);
            // Now you can call Cat methods on the c variable
            Cat c = (Cat) a;
            World w = getWorld(); // get this Actor's World
            c.decreaseLives(1);
            w.removeObject(this); // remove this Actor from the World
            
            
            
          
        }
    }
    
    
    
   
}
