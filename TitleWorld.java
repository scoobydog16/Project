import mayflower.*;
/**
 * Write a description of class TitleWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TitleWorld extends World
{
    NextLevel levelLoader;
    private Timer blinkTimer;
    boolean colorBlack;
    public TitleWorld()
    {
       //setImage... 
       showText("CAT ADVENTURE", 250, 300);
       showText("Press Enter to Begin", 220, 500, Color.BLACK);
       colorBlack = true;
       levelLoader = new NextLevel();
       blinkTimer = new Timer(999999);
       blinkTimer.set(1000000000);
    }
    
    public void act() 
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER)) //gameplay
            levelLoader.LoadNextLevel();
        if(Mayflower.isKeyDown(Keyboard.KEY_N))
            Mayflower.setWorld(new NolanTestWorld());
        if(Mayflower.isKeyDown(Keyboard.KEY_S))
           Mayflower.setWorld(new SamarthTestWorld());
        if(Mayflower.isKeyDown(Keyboard.KEY_Y))
            Mayflower.setWorld(new YashTestWorld());
            
        if(blinkTimer.isDone())
        {
            blinkTimer.reset();
            if(colorBlack)
            {
                removeText(220,500);
                showText("Press Enter to Begin", 220, 500, Color.YELLOW);
                colorBlack = false;
            }
            else
            {
                removeText(220,500);
                showText("Press Enter to Begin", 220, 500, Color.BLACK);
                colorBlack = true;
            }
                
        }
    }
}
    
    
 