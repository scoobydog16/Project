import mayflower.*;
/**
 * Write a description of class NolanTestWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level02 extends World
{

    
    private Cat cat;
    private Dog dog;

    private Block blockA;
    private Block blockB;
    private Ladder ladder;
    private Tree tree;
    private Danger danger;
    private Water water;
    
    Trigger button;
    
    private String[][] tiles;
    
    
    public Level02() 
    {
        setBackground("img/BG/BG.png");
        tiles = new String[15][20];
        // danger = new Danger( 20, 30, 100, 100, "img/NolanStuff/Empty.png");
        // addObject(danger, 500, 200);
        
        // blockA = new Block(40,40);
        // addObject(blockA, 400,500);
        // blockB = new Block();
        // addObject(blockB, 528,372);
        // Block b = new Block();
        // addObject(b, 200,500);
        
        // ladder = new Ladder();
        // addObject(ladder, 200, 400);
        // tree = new Tree();
        // addObject(tree, 500, 300);
        
        // water = new Water(100, 100, 0,0);
        // addObject(water, 300,300);

        // button = new Trigger(water, Trigger.TriggerType.holdDeactivate, new int[] {300 , 300});
        // addObject(button, 400,400);
        Mayflower.showBounds(true);
        
        cat = new Cat(5f, 0.1f, 0.625f);
        addObject(cat, 5, 13);
        dog = new Dog(3f, 0.07f, 0.625f);
        addObject(dog, 6, 13);
        
        showText("Cat ", 10, 30, Color.BLACK);
        showText("Lives: " + cat.getLives(), 80, 30, Color.BLACK);
        cat.setTextPosition(80, 30);
        showText("Dog ", 10, 60, Color.BLACK);
        showText("Lives: " + cat.getLives(), 80, 60, Color.BLACK);
        dog.setTextPosition(80, 60);
        
        buildWorld();
    }
    
    public void act()
    {
        if(Mayflower.isKeyPressed(Keyboard.KEY_ENTER))
            for(String[] a : tiles)
            {
                for(String b : a)
                    System.out.print(b + ", ");
                System.out.println();
            }
    }
    
    public void buildWorld() 
    {
        for(int y = 0; y < tiles.length; y++)
            for(int x = 0; x < tiles[y].length; x++)
                tiles[y][x] = "";
        
        for(int i = 0; i < 16; i++)
            tiles[14][i + 4] = "Ground";
        
        for(int y = 11; y < 15; y++)
        {
            for(int x = 0; x < 4; x++)
            {
                tiles[y][x] = "Wall";
            }
            tiles[y][4] = "WallEdge";
        }
        tiles[14][4] = "WallEdgeB";
        for(int x = 0; x < 4; x++)
        {
            tiles[10][x] = "Ground";
        }
        tiles[10][4] = "WallEdgeT";
        
        tiles[10][13] = "LadderObject";
        tiles[11][13] = "Ladder";
        
        tiles[12][11] = "PlatformPiece";
        for(int x = 12; x < 14; x++)
            tiles[12][x] = "Platform";
        
        tiles[11][11] = "Yarn";
        tiles[11][12] = "Bone";
            
        tiles[13][15] = "Trigger-HA";
        
        // Above sets the tiles, below adds them to the world
        
        
        
        for(int x = 0; x < 20; x++)
        {
            for(int y = 14; y >= 0; y--)
            {
                if(tiles[y][x].equals("Ground"))
                    addObject(new Block(40,40), x, y);
                else if(tiles[y][x].equals("Wall"))
                    addObject(new Image("img/Tiles/5.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdge"))
                    addObject(new ImageBlock("img/Tiles/6.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdgeB"))
                    addObject(new ImageBlock("img/Tiles/10.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdgeT"))
                    addObject(new ImageBlock("img/Tiles/3.png",40,40), x, y);
                else if(tiles[y][x].equals("LadderObject"))
                    addObject(new Ladder(0.8f),x, y);
                else if(tiles[y][x].equals("PlatformPiece"))
                    addPlatform(x, y);
                else if(tiles[y][x].contains("Trigger"))
                {
                    if(tiles[y][x].contains("-HA"))
                        addObject(new Trigger(new Ladder(0.8f), Trigger.TriggerType.holdActivate, 
                        new int[]{ 10, 12 }, 0.4f), x, y);
                }
                else if(tiles[y][x].equals("Yarn"))
                    addObject(new Yarn(0.4f),x, y);
                else if(tiles[y][x].equals("Bone"))
                    addObject(new Bone(0.4f),x, y);
            }
        }
        
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
    
    public void addObject(Actor actor, int x, int y)
    {
        if(actor.getClass() == Ladder.class)
        {
            int height = actor.getHeight() / 40;
            int yPos = y;
            do
            {
                tiles[yPos][x] = "Ladder";
                yPos--;
                height--;
            }
            while(height > 0);
        }
        super.addObject(actor,x * 40,y * 40);
    }
    
    public void removeObject(Actor actor)
    {
        if(actor.getClass() == Ladder.class)
        {
            int height = actor.getHeight() / 40;
            int x = actor.getX() / 40;
            int y = actor.getY() / 40;
            do
            {
                tiles[y][x] = "";
                y--;
                height--;
            }
            while(height > 0);
        }
        super.removeObject(actor);
    }

}
