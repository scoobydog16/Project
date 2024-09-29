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
    private Tree tree;
    private Danger danger;
    private Water water;
    
    Trigger button;
    
    public NolanTestWorld() 
    {
        setBackground("img/BG/BG.png");
        
        danger = new Danger( 20, 30, 100, 100, "img/NolanStuff/Empty.png");
        addObject(danger, 500, 200);
        blockA = new Block();
        addObject(blockA, 400,500);
        blockB = new Block();
        addObject(blockB, 528,372);
        Block b = new Block();
        addObject(b, 200,500);
        
        ladder = new Ladder();
        addObject(ladder, 200, 400);
        tree = new Tree();
        addObject(tree, 500, 300);
        
        water = new Water(100, 100, 0,0);
        addObject(water, 300,300);

        button = new Trigger(water, Trigger.TriggerType.holdDeactivate, new int[] {300 , 300});
        addObject(button, 400,400);
        Mayflower.showBounds(true);
        
        cat = new Cat(7f, 0.1f);
        addObject(cat, 400, 0);
        
        dog = new Dog(7f, 0.1f);
        addObject(dog, 200, 100);
        
        showText("Cat ", 10, 30, Color.BLACK);
        showText("Lives: " + cat.getLives(), 80, 30, Color.BLACK);
        cat.setTextPosition(80, 30);
        showText("Dog ", 10, 60, Color.BLACK);
        showText("Lives: " + cat.getLives(), 80, 60, Color.BLACK);
        dog.setTextPosition(80, 60);
    }
    
    public void act()
    {
    }
}
