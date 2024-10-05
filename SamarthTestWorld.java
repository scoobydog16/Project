import mayflower.*;
public class SamarthTestWorld extends World 
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
    
    
    
    public SamarthTestWorld() 
    {
        setBackground("img/BG/BG.png");
        
        yarn = new Yarn();
        addObject(yarn, 200, 399);
        
        cat = new Cat(15f, 0.45f, 1f);
        addObject(cat, 400, 0);
        

        //addObject(dog, 200, 100);
        
        jack = new Jack();
        //addObject(jack, 300, 100);
        
        ninja = new Ninja();
        //addObject(ninja, 400,100);
            
        blockA = new MovingBlock();
        addObject(blockA, 0,472);
        
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);

    }
    
    public void act()
    {
        
    }
    
}