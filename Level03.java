import mayflower.*;

public class Level03 extends World
{
    // instance variables - replace the example below with your own
    private Cat cat;
    private Dog dog;

    private Block blockA;
    private Block blockB;
    private Timer animationTimer;
    private Potion p;
    
    
    private String[][] tiles;

    /**
     * Constructor for objects of class Level03
     */
    public Level03()
    {
        // initialise instance variables
        setBackground("img/BG/BG.png");
        p = new Potion();
        p.scale(0.5);
        addObject(p, 100, 100);
        tiles = new String[6][8];
        Mayflower.showBounds(true);
        cat = new Cat(10f, 0.1f, 1f);
        addObject(cat, 5, 13);
        showText("Lives: " + cat.getLives() + " Score: " + cat.getScore(), 80, 30, Color.BLACK);
        cat.setTextPosition(80, 25);
        
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
    
    public void randomizePotionLocation()
    {
        /**int index = (int)(Math.random() * itemSpawnSpots.size());
        Integer[] pos = itemSpawnSpots.get(index);
        int randomYIncrease = (int)(Math.random() * 4);
        **/
    }
    
    public void act()
    {
        
    }
}
