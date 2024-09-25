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
        
        bomb = new Bomb();
        addObject(bomb, 399, 300);
        
        yarn = new Yarn();
        addObject(yarn, 200, 399);
        
<<<<<<< HEAD
        cat = new Cat(7f);
=======
        cat = new Cat(20f, 0.1f);
>>>>>>> c8f5ff11abd8bd119364891d5773024d338ce390
        addObject(cat, 400, 0);
        
        dog = new Dog();
        //addObject(dog, 200, 100);
        
        jack = new Jack();
        //addObject(jack, 300, 100);
        
        ninja = new Ninja();
        //addObject(ninja, 400,100);
        
        blockA = new MovingBlock();
        addObject(blockA, 400,500);
        
        Mayflower.showBounds(true);
        
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);

    }
    
    public void act()
    {
    }
    
}