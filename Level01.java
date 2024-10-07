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
    private boolean firstObject;
    private int randomNum;
    private ArrayList<Actor> movingObjects; 
    private ArrayList<Actor> possibleMovingObjects;
    private ArrayList<Actor> possibleMovingObjects2;
    private int currentAction;
    private int yAmount;
    private int bAmount;
    private int dAmount;
    NextLevel levelLoader;
    
    public Level01() 
    {
        setBackground("img/BG/BG.png");
        
        movingObjects = new ArrayList<Actor>();
        possibleMovingObjects = new ArrayList<Actor>();
        possibleMovingObjects.add(new Yarn());
        possibleMovingObjects.add(new Block());
        possibleMovingObjects.add(new Danger(128, 128, 400, 100, "img/NolanStuff/Spike.png"));
        possibleMovingObjects2 = new ArrayList<Actor>();
        possibleMovingObjects2.add(new Yarn());
        possibleMovingObjects2.add(new Block());
        possibleMovingObjects2.add(new Danger(128, 128, 400, 100, "img/NolanStuff/Spike.png"));
        yAmount = 10;
        bAmount = 10;
        dAmount = 10;
        currentAction = 8;
        
        canBeRandomized = false;
        firstObject = true;
        
        tiles = new String[6][8];
        
        cat = new Cat(15f, 0.45f, 1f);
        addObject(cat, 400, 0);
        
        levelLoader = new NextLevel();
        
        buildWorld();
        addObjectstoList();
        cat.setLives(1);
        showText("Lives: " + cat.getLives() + " Score: " + cat.getScore() , 10, 30, Color.BLACK);

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
        addRandomObjects();
        moveObjects();
        
        if (cat.getScore() >= 8)
        {
            levelLoader.LoadNextLevel();
        }
        if (cat.getLives() <= 0)
        {
            levelLoader.GameOver();
        }
        
        showText("Lives: " + cat.getLives() + " Score: " + cat.getScore() , 10, 30, Color.BLACK);
    }
    
    public void addObjectstoList()
    {
        if(canBeRandomized)
        {
            for (int i = 0; i < 30; i++)
            {
                randomNum = (int)(Math.random() * possibleMovingObjects.size());
                if (randomNum == 0 && yAmount > 0)
                {
                    movingObjects.add(possibleMovingObjects.get(randomNum));
                    yAmount--;
                }
                else if (randomNum == 1 && bAmount > 0)
                {
                    movingObjects.add(possibleMovingObjects.get(randomNum));
                    bAmount--;
                }
                else if (randomNum == 2 && dAmount > 0)
                {
                    movingObjects.add(possibleMovingObjects.get(randomNum));
                    dAmount--;
                }
                else if (randomNum == 0 && possibleMovingObjects.contains(new Yarn()))
                {
                    possibleMovingObjects.remove(new Yarn());
                    i--;
                }
                else if (randomNum == 1 && possibleMovingObjects.contains(new Block()))
                {
                    possibleMovingObjects.remove(new Block());
                    i--;
                }
                else if (randomNum == 2 && possibleMovingObjects.contains(new Danger(128, 128, 400, 100, "img/NolanStuff/Spike.png")))
                {
                    possibleMovingObjects.remove(new Danger(128, 128, 400, 100, "img/NolanStuff/Spike.png"));
                    i--;
                }
                else
                    i--;
            }
        }
    }
    
    public void addRandomObjects()
    {
        if(firstObject || movingObjects.get(currentAction - 1).getX() + movingObjects.get(currentAction - 1).getWidth() <= 0)
        {
            if(movingObjects.get(currentAction).equals(possibleMovingObjects.get(2)))
            {
                addObject(movingObjects.get(currentAction), 800, 7*50);
            }
            else
            {
                addObject(movingObjects.get(currentAction), 800, 250);
            }
            if (currentAction < 38)
                currentAction++;
            firstObject = false;
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
            if (i <= 7)
                currentActor.setLocation(x-5, y);
            else if (currentActor.equals(possibleMovingObjects2.get(2)))
                currentActor.setLocation(x-0.25, y);
            else
                currentActor.setLocation(x-1, y);
            if (x + w < 0 && i <= 7)
                currentActor.setLocation(7*122, 95*5);
        }
    }
}