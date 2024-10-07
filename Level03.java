import mayflower.*;

public class Level03 extends World
{
    // instance variables - replace the example below with your own
    private Cat cat;
    private Dog dog;

    private Block blockA;
    private Block blockB;
    private Timer countdownTimer;
    private int time = 1000000000;
    private Potion p;
    
    
    private String[][] tiles;
    private String[][] spawnSpots;
    
    NextLevel levelLoader;

    /**
     * Constructor for objects of class Level03
     */
    public Level03()
    {
        // initialise instance variables
        setBackground("img/BG/BG.png");
        
        countdownTimer = new Timer(time);
        
        p = new Potion();
        addObject(p, 100, 100);
        
        tiles = new String[6][8];
        spawnSpots = new String[6][7];
        
        Mayflower.showBounds(true);
        cat = new Cat(10f, 0.1f, 1f);
        addObject(cat, 5, 13);
        cat.setLives(1);
        showText("Lives: " + cat.getLives() + " Score: " + cat.getScore(), 10, 30, Color.BLACK);
        showText("Time Left: " + time, 10, 60, Color.BLACK);
        
        cat.setTextPosition(10, 30);
        
        randomizePotionLocation(p);
        
        levelLoader = new NextLevel();
        
        buildWorld();
    }

   
    public void buildWorld()
    {
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[i].length; j++)
            {
                tiles[i][j] = "";
            }
        }
        
        for (int i = 0; i < tiles[5].length; i++)
            tiles[5][i] = "ground";
        
            for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[i].length; j++)
            {
                if(tiles[i][j] == "ground")
                    addObject(new Block(), 128*j, 472);
            }
        }
            
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[i].length; j++)
            {
                System.out.print(tiles[i][j]);
            }
            System.out.println();
        }
    }
    
    public void randomizePotionLocation(Actor a)
    {
        countdownTimer.reset();
        int row = (int)(Math.random() * spawnSpots.length);
        int col = (int)(Math.random() * spawnSpots[0].length);    
        a.setLocation(col * 80, row * 60);
    }
    
    public void removeObject(Actor a)
    {
        if(a.getClass() == Potion.class)
            randomizePotionLocation(a);
        else
            super.removeObject(a);
    }

    
    public void act()
    {
        if (cat.getScore() >= 12)
        {
            levelLoader.LoadNextLevel();
        }
        if (((countdownTimer.getTimeLeft()/1000000000) + 3) <= 0)
        {
            levelLoader.GameOver();
        }
        
        showText("Time Left: " + ((countdownTimer.getTimeLeft()/1000000000) + 3), 10, 60, Color.BLACK);
    }
}
