import mayflower.*;

public class NextLevel
{
    // instance variables - replace the example below with your own
    
    private static World allWorlds[] = new World[] { new TitleWorld(), new Level02(), new GameWin(), 
        new GameOverWorld()};
    private static int index = 0;

    public NextLevel()
    {

    }
    
    public void LoadNextLevel()
    {
        index++;
        if(index == allWorlds.length)
            index = 0;
        Mayflower.setWorld(allWorlds[index]);
    }
    
    public void GameOver()
    {
        index = 3;
        Mayflower.setWorld(allWorlds[index]);
    }
    
    public void Restart()
    {
        index = 0;
        allWorlds = new World[] { new TitleWorld(), new Level02(), new GameWin(), new GameOverWorld()};
        Mayflower.setWorld(allWorlds[index]);
    }
}
