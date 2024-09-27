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

    private Block blockA;
    private Block blockB;
    private Ladder ladder;
    
    private Danger danger;
    
    
    
    public NolanTestWorld() 
    {
        setBackground("img/BG/BG.png");
        
        cat = new Cat(7f, 0.1f);
        addObject(cat, 400, 0);
        
        dog = new Dog(7f, 0.1f);
        addObject(dog, 200, 100);
        
        danger = new Danger();
        addObject(danger, 200, 200);
        blockA = new Block();
        addObject(blockA, 400,500);
        blockB = new Block();
        addObject(blockB, 528,372);
        Block b = new Block();
        addObject(b, 200,500);
        
        
        Mayflower.showBounds(true);
        
        showText("Cat Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        showText("Dog Lives: " + cat.getLives(), 10, 60, Color.BLACK);

    }
    
    public void act()
    {
    }
}
