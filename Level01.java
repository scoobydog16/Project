import mayflower.*;
public class Level01 extends World 
{
    private Cat cat;
    private Dog dog;
    private Jack jack;
    private Ninja ninja;
    private MovingBlock blockA;
    private Bomb bomb;
    private Ladder ladder;
    private Yarn yarn;
    private String[][] tiles;
    private boolean canBeRandomized;
    
    
    public Level01() 
    {
        setBackground("img/BG/BG.png");
        
        canBeRandomized = false;
        
        tiles = new String[6][8];
        
        yarn = new Yarn();
        addObject(yarn, 200, 399);
        
        cat = new Cat(15f, 0.45f, 1f);
        addObject(cat, 400, 0);
        
        buildWorld();
        
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);

    }
    
    public void buildWorld()
    {
        for (int i = 0; i < tiles.length; i++)
        {
            for (int j = 0; j < tiles[i].length; j++)
            {
                tiles[i][j] = "";
            }
        }
        
        for (int i = 0; i < tiles[5].length; i++)
        {
            tiles[5][i] = "ground";
            addObject(new MovingBlock(), 125*i, 95*5);
            canBeRandomized = true;
        }
    }
    
    public void act()
    {
        
    }
    
    public void addRandomObjects()
    {
        if(canBeRandomized)
        {
            
        }
    }
}