import mayflower.*;

public class GameWin extends World
{
    
    NextLevel levelLoader;
    private Timer blinkTimer;
    boolean colorBlack;
    public GameWin()
    {
       //setImage... 
       showText("GG, YOU WON!", 250, 300);
       showText("Press Enter to Restart", 220, 500, Color.BLACK);
       colorBlack = true;
       levelLoader = new NextLevel();
       blinkTimer = new Timer(999999);
       blinkTimer.set(1000000000);
    }
    
    public void act() 
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
            levelLoader.Restart();
        if(blinkTimer.isDone())
        {
            blinkTimer.reset();
            if(colorBlack)
            {
                removeText(220,500);
                showText("Press Enter to Restart", 220, 500, Color.BLUE);
                colorBlack = false;
            }
            else
            {
                removeText(220,500);
                showText("Press Enter to Restart", 220, 500, Color.BLACK);
                colorBlack = true;
            }
                
        }
    }
}
