import mayflower.*;



public class MyWorld extends World 
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
    
    
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        bomb = new Bomb();
        
        addObject(bomb, 399, 300);
        
        yarn = new Yarn();
        addObject(yarn, 200, 399);
        
        cat = new Cat(12f, 0.6f, 1f);
        addObject(cat, 400, 0);
        
        //addObject(dog, 200, 100);
        
        jack = new Jack();
        //addObject(jack, 300, 100);
        
        ninja = new Ninja();
        //addObject(ninja, 400,100);
        
        //blockA = new MovingBlock();
        //addObject(blockA, 400,500);
        blockB = new Block();
        addObject(blockB, 528,372);
        
        Mayflower.showBounds(true);
        
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);
        cat.setTextPosition(10, 30);
    }
    
    public void act()
    {
        
    }
    
    
    
}