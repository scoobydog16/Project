import mayflower.*;
/**
 * Write a description of class NolanTestWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NolanTestWorld extends World
{
    private Cat cat;
    private Dog dog;
    private Jack jack;
    private Ninja ninja;
    private Block blockA;
    private Block blockB;
    private Bomb bomb;
    	private Ladder ladder;
    
    
    
    public NolanTestWorld() 
    {
        setBackground("img/BG/BG.png");
        
        bomb = new Bomb();
        addObject(bomb, 399, 200);
        
        
        cat = new Cat();
        addObject(cat, 400, 0);
        
        dog = new Dog();
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

    }
    
    public void act()
    {
    }
}
