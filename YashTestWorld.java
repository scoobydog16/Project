import mayflower.*;
/**
 * Write a description of class NolanTestWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class YashTestWorld extends World
{
    private Cat cat;
    private Dog dog;
    private Jack jack;
    private Ninja ninja;
    private Block blockA;
    private Block blockB;
    private Bomb bomb;
    private Ladder ladder;
    private Yarn yarn;
    
    
    
    
    public YashTestWorld() 
    {
        setBackground("img/BG/BG.png");
        
        bomb = new Bomb();
        addObject(bomb, 399, 200);
        
        yarn = new Yarn();
        addObject(yarn, 200, 399);
        
        cat = new Cat(20f, 0.09f, 1f);
        addObject(cat, 400, 0);
        

        addObject(dog, 200, 100);
        
        jack = new Jack();
        //addObject(jack, 300, 100);
        
        ninja = new Ninja();
        //addObject(ninja, 400,100);
        
        blockA = new Block();
        addObject(blockA, 400,500);
        blockB = new Block();
        addObject(blockB, 528,372);
        Block b = new Block();
        addObject(b, 200,500);
        
        
        Mayflower.showBounds(true);
        
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        showText("Score: " + cat.getScore(), 40, 30, Color.BLACK);

    }
    
    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_Y))
            Mayflower.setWorld(new Level03());
    }
    
    public void addRandomObject(Actor bomb)
    {
        int x = 1;//random
        int y = 2; //random
        addObject(bomb, x , y);
        
        
    }
    
}
