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
            Cat c =  getOneIntersectingObject(Cat.class);
            World w = getWorld();
           w.removeObject(this);
           c.decreaseLives(1);
           
           
        }   
    }
    
    
    
   
}
