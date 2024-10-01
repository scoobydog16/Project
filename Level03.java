import mayflower.*;

public class Level03 extends MyWorld
{
    // instance variables - replace the example below with your own
    private Cat cat;
    private Dog dog;

    private Block blockA;
    private Block blockB;
    
    
    
    private String[][] tiles;

    /**
     * Constructor for objects of class Level03
     */
    public Level03()
    {
        // initialise instance variables
        Mayflower.showBounds(true);
        cat = new Cat(5f, 0.1f, 1f);
        addObject(cat, 5, 13);
        showText("Lives: " + cat.getLives() + " Score: " + cat.getScore(), 80, 30, Color.BLACK);
        cat.setTextPosition(80, 25);
    }

   
    public void buildWorld()
    {
        
        for(int y = 0; y < tiles.length; y++)
            for(int x = 0; x < tiles[y].length; x++)
                tiles[y][x] = "";
        
        for(int i = 0; i < 12; i++)
            tiles[14][i + 4] = "Ground";
        
        for(int y = 11; y < 15; y++)
        {
            for(int x = 0; x < 4; x++)
            {
                tiles[y][x] = "Wall";
            }
            tiles[y][4] = "WallEdgeR";
        }
        tiles[14][4] = "WallEdgeRB";
        for(int x = 0; x < 4; x++)
        {
            tiles[10][x] = "Ground";
        }
        tiles[10][4] = "WallEdgeRT";
        
        for(int y = 11; y < 14; y++)
        {
            tiles[y][16] = "WallEdgeL";
        }
        tiles[14][16] = "WallEdgeLB";
        tiles[10][16] = "WallEdgeLT";
        
        
    }
    
    public void addPlatform(int x, int y)
    {
        tiles[y][x] = "Platform";
        addObject(new ImageBlock("img/Tiles/13.png",40,30), x, y);
        x++;
        do
        {
            tiles[y][x] = "Platform";
            addObject(new ImageBlock("img/Tiles/14.png",40,30), x, y);
            x++;
        }
        while (tiles[y][x].equals("Platform"));
        tiles[y][x] = "Platform";
        addObject(new ImageBlock("img/Tiles/15.png",40,30), x, y);
    }
    
    public void addPlatform(int x, int y, int width)
    {
        System.out.print(width);
        tiles[y][x] = "Platform";
        super.addObject(new ImageBlock("img/Tiles/13.png",40,30), x * 40, y * 40);
        x++;
        width--;
        do
        {
            tiles[y][x] = "Platform";
            addObject(new ImageBlock("img/Tiles/14.png",40,30), x, y);
            x++;
            width--;
        }
        while (width > 1);
        tiles[y][x] = "Platform";
        addObject(new ImageBlock("img/Tiles/15.png",40,30), x, y);
    }

}
