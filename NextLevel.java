import mayflower.*;

public class NextLevel
{
    // instance variables - replace the example below with your own
    
    private static World allWorlds[] = new World[] { new TitleWorld(), new Level02(), 
        new GameOverWorld(), new GameWin() };
    private static int index = 0;

    public NextLevel()
    {

    }
    
    public void LoadNextLevel()
    {
        index++;
        Mayflower.setWorld(allWorlds[index]);
    }
}
