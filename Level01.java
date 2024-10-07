import mayflower.*;
import java.util.*;

public class Level01 extends World 
{
    private Cat cat;
    private Block blockA;
    private Ladder ladder;
    private Yarn yarn;
    private String[][] tiles;
    private boolean canBeRandomized;
    private ArrayList<Actor> movingObjects; 
    private ArrayList<Actor> possibleMovingObjects;
    
    
    public Level01() 
    {
        setBackground("img/BG/BG.png");
        
        //possibleMovingObjects = new ArrayList<>(Arrays.asList(new Yarn(), new Block(), new Danger((128, 128, 800, 600, "img\NolanStuff\Spike.png"))));
        
        movingObjects = new ArrayList<Actor>();
        
        canBeRandomized = false;
        
        tiles = new String[6][8];
        
        cat = new Cat(15f, 0.45f, 1f);
        addObject(cat, 400, 0);
        
        buildWorld();
        addRandomObjects();
        
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
        }
        
        for (int i = 0; i < tiles.length; i++)
        {
            for (int j = 0; j < tiles[i].length; j++)
            {
                if (tiles[i][j].equals("ground"))
                {
                    Actor a = new Block();
                    addObject(a, 125*j, 95*5);
                    movingObjects.add(a);
                }
            }
        }
        canBeRandomized = true;
        
    }
    
    public void act()
    {
        moveObjects();
    }
    
    public void addRandomObjects()
    {
        if(canBeRandomized)
        {
            Actor a = new Yarn();
            addObject(a, 800, 300);
            movingObjects.add(a);
        }
    }
    
    public void moveObjects()
    {
        for(int i = 0; i < movingObjects.size(); i++)
        {
            Actor currentActor = movingObjects.get(i);
            int x = currentActor.getX();
            int y = currentActor.getY();
            int w = currentActor.getWidth();
            currentActor.setLocation(x-5, y);
            if (x + w < 0 && i <= 7)
                currentActor.setLocation(7*122, 95*5);
        }
    }
}