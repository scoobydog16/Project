import mayflower.*;

public class NextLevel extends World
{
    // instance variables - replace the example below with your own
    
    World nextWorld;
    /**
     * Constructor for objects of class NextLevel
     */
    public NextLevel(World nextWorld)
    {
        System.out.print("Loading next World, enter to start");
        this.nextWorld = nextWorld;
    }
    
    public void act() 
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
            Mayflower.setWorld(nextWorld);
    }
}
