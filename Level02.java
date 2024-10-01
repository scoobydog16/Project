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
        tiles = new String[16][20];
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
        buildWorld();
        
        
        showText("Cat ", 10, 30, Color.BLACK);
        showText("Lives: " + cat.getLives() + " Score: " + cat.getScore(), 80, 30, Color.BLACK);
        cat.setTextPosition(80, 30);
        showText("Dog ", 10, 60, Color.BLACK);
        showText("Lives: " + dog.getLives() + " Score: " + dog.getScore(), 80, 60, Color.BLACK);
        dog.setTextPosition(80, 60);
        

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
        
        int waterCount = 0;
        for(int i = 0; i < 3; i++)
        {
            tiles[10][17 + i] = "WaterTop";
            waterCount++;
            for(int j = 11; j < 15; j++)
            {
                tiles[j][17 + i] = "Water";
                waterCount++;
            }
            tiles[15][17 + i] = "Ground";
        }
        Image[] waterSprites = new Image[waterCount];
        int currentWaterIndex = 0;
        
        tiles[14][18] += "+Bone";
        tiles[10][13] = "LadderObject";
        tiles[11][13] = "Ladder";
        
        tiles[12][11] = "PlatformPiece";
        for(int x = 12; x < 14; x++)
            tiles[12][x] = "Platform";
        
        tiles[11][11] = "Yarn";
        tiles[11][12] = "Bone";
            
        tiles[13][15] = "Trigger-HA";
        
        tiles[14][19] += "+Trigger-PD";
        
        tiles[9][3] = "DeactivateDanger";
        tiles[9][4] = "DeactivateDangerPart";
        
        tiles[9][0] = "Trigger-PA";
        tiles[5][1] = "Yarn";
        
        tiles[6][9] = "Bone";
        tiles[6][10] = "Yarn";
        
        tiles[6][1] = "TreeObject";
        // Above sets the tiles, below adds them to the world
        
        
        Actor deactivateActor = new Danger(80,40,5, 11, "img/NolanStuff/Spike.png");;
        for(int x = 0; x < 20; x++)
        {
            for(int y = 0; y < 15; y++)
            {
                if(tiles[y][x].equals("Ground"))
                    addObject(new Block(40,40), x, y);
                else if(tiles[y][x].equals("Wall"))
                    addObject(new Image("img/Tiles/5.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdgeR"))
                    addObject(new ImageBlock("img/Tiles/6.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdgeRB"))
                    addObject(new ImageBlock("img/Tiles/10.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdgeRT"))
                    addObject(new ImageBlock("img/Tiles/3.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdgeL"))
                    addObject(new ImageBlock("img/Tiles/4.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdgeLB"))
                    addObject(new ImageBlock("img/Tiles/8.png",40,40), x, y);
                else if(tiles[y][x].equals("WallEdgeLT"))
                    addObject(new ImageBlock("img/Tiles/1.png",40,40), x, y);
                else if(tiles[y][x].equals("LadderObject"))
                    addObject(new Ladder(0.8f),x, y);
                else if(tiles[y][x].equals("TreeObject"))
                    addObject(new Tree(1.8f),x, y);
                else if(tiles[y][x].equals("PlatformPiece"))
                    addPlatform(x, y);
                else if(tiles[y][x].contains("Trigger"))
                {
                    if(tiles[y][x].contains("-HA"))
                        addObject(new Trigger(new Ladder(0.8f), Trigger.TriggerType.holdActivate, 
                        new int[]{ 10, 12 }, 0.4f), x, y);
                    if(tiles[y][x].contains("-PA"))
                        addObject(new Trigger(5, Trigger.TriggerType.pressActivate, 
                        new int[]{ 8, 9 }, 0.4f), x, y);
                    if(tiles[y][x].contains("-PD"))
                        addObject(new Trigger(deactivateActor, Trigger.TriggerType.pressDeactivate, 
                        new int[]{ 10, 12 }, 0.4f), x, y);
                }
                else if(tiles[y][x].equals("DeactivateDanger"))
                    addObject(deactivateActor, x, y);
                else if(tiles[y][x].equals("Yarn"))
                    addObject(new Yarn(0.4f),x, y);
                else if(tiles[y][x].contains("Bone"))
                    addObject(new Bone(0.4f),x, y);
                if(tiles[y][x].contains("WaterTop"))
                {
                    Image img = new Image("img/Tiles/17.png", 40, 40);
                    waterSprites[currentWaterIndex++] = img;
                    addObject(img,x, y);
                }
                else if(tiles[y][x].contains("Water"))
                {    
                    Image img = new Image("img/Tiles/18.png", 40, 40);
                    waterSprites[currentWaterIndex++] = img;
                    addObject(img,x, y);
                }
            }
        }
        makeWater(waterSprites[0].getX()/40, waterSprites[0].getY()/40, waterSprites);
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
    
    public void addObject(Actor actor, int x, int y)
    {
        if(actor.getClass() == Ladder.class || actor.getClass() == Tree.class)
        {
            String name = actor.getClass() == Ladder.class ? "Ladder" : "Tree";
            int height = actor.getHeight() / 40;
            int yPos = y;
            do
            {
                tiles[yPos][x] = name;
                yPos++;
                height--;
            }
            while(height > 0);
        }
        if(actor.getClass() == Ledge.class)
            addPlatform(x,y,actor.getWidth());
        else
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
        tiles[actor.getY()/40][actor.getX()/40] = "";
        super.removeObject(actor);
    }
    
    public void makeWater(int x, int  y, Image[] waterSprites)
    {
        int height = waterSprites[waterSprites.length - 1].getY() + waterSprites[0].getHeight() - waterSprites[0].getY();
        int width  = waterSprites[waterSprites.length - 1].getX() + waterSprites[0].getWidth() - waterSprites[0].getX();
        addObject(new Water(width, height, 15, 11, waterSprites), x, y);
    }

}
