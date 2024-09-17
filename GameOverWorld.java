import mayflower.*;

public class GameOverWorld extends World
{

    public GameOverWorld()
    {
       //setImage... 
    }
    
    public void act() 
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE))
            Mayflower.setWorld(new MyWorld());
    }

}
