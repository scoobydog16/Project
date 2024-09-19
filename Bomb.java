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
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w = getWorld();
           w.removeObject(this);
           c.increaseLives(1);
           
        }   
    }
    
    public void increaseLives(int amount)
    {
        
    }
    
    public int getLives(
}
