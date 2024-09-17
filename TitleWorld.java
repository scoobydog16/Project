import mayflower.*;
/**
 * Write a description of class TitleWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TitleWorld extends World
{

    public TitleWorld()
    {
       //setImage... 
       System.out.print("Title World");
    }
    
    public void act() 
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
            Mayflower.setWorld(new MyWorld());
    }

}
