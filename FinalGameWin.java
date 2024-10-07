import mayflower.*;

public class FinalGameWin extends World
{
    
    NextLevel levelLoader;
    private Timer blinkTimer;
    boolean colorBlack;
    public FinalGameWin()
    {
       //setImage... 
       showText("YOU WON!!!! VERY COOL :)", 70, 300);
       showText("CLICK ENTER TO RESTART", 70, 350);
       showText("Press Enter to Play Again", 220, 500, Color.BLACK);
       colorBlack = true;
       levelLoader = new NextLevel();
       blinkTimer = new Timer(999999);
       blinkTimer.set(1000000000);
    }
    
    /*
     * will check if there is an input (enter) if there is one it loads the next level (title)
     * also makes the text object change colors to blink
     */
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
                showText("Press Enter To Play Again", 220, 500, Color.BLUE);
                colorBlack = false;
            }
            else
            {
                removeText(220,500);
                showText("Press Enter To Play Again", 220, 500, Color.BLACK);
                colorBlack = true;
            }
                
        }
    }
}