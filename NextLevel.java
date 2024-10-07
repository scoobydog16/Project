import mayflower.*;

public class NextLevel
{
    // instance variables - replace the example below with your own
    // static variables, meaning they won't change, always those variables, so they are constant between worlds
    private static World allWorlds[] = new World[] { new TitleWorld(), new Level01(), new GameWin(), new Level02(), new GameWin(), new Level03(), new FinalGameWin(),
        new GameOverWorld()};
    private static int index = 0;

    public NextLevel()
    {

    }
    
    // will load the next level by increasing the index
    public void LoadNextLevel()
    {
        index++;
        if(index == allWorlds.length)
            index = 0;
        Mayflower.setWorld(allWorlds[index]);
    }
    // will load the last world which is game over
    public void GameOver()
    {
        index = allWorlds.length - 1;
        Mayflower.setWorld(allWorlds[index]);
    }
    // will load the first world which is the title world and restarts the worlds (so they aren't the
    // same ones we already completed which would have their pickups already picked up)
    public void Restart()
    {
        index = 0;
        allWorlds = new World[] { new TitleWorld(), new Level01(), new GameWin(), new Level02(), new GameWin(), new Level03(), new FinalGameWin(), new GameOverWorld()};
        Mayflower.setWorld(allWorlds[index]);
    }
}
