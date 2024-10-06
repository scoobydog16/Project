import mayflower.*;

public class GameOverWorld extends World
{
    NextLevel levelLoader;
    private Timer blinkTimer;
    boolean colorBlack;
    public GameOverWorld()
    {
       //setImage... 
       showText("GAME OVER", 285, 300);
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
                showText("Press Enter to Restart", 220, 500, Color.RED);
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
