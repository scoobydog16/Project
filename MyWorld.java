import mayflower.*;



public class MyWorld extends World 
{

<<<<<<< HEAD
    private Cat cat;
    private Dog dog;
    private Jack jack;
    private Ninja ninja;
    private Block blockA;
    private Block blockB;
    private Bomb bomb;
    
    
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        bomb = new Bomb();
        addObject(bomb, 399, 200);
        
        
        cat = new Cat();
        addObject(cat, 400, 0);
        
        dog = new Dog();
        //addObject(dog, 200, 100);
        
        jack = new Jack();
        //addObject(jack, 300, 100);
        
        ninja = new Ninja();
        //addObject(ninja, 400,100);
        
        blockA = new Block();
        addObject(blockA, 400,500);
        blockB = new Block();
        addObject(blockB, 528,372);
        
        Mayflower.showBounds(true);
        
        showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);
=======
	private Cat cat;
	private Dog dog;
	private Jack jack;
	private Ninja ninja;
	private Block blockA;
	private Block blockB;
	private Ladder ladder;
	
    public MyWorld() 
    {
    	setBackground("img/BG/BG.png");
    	
    	cat = new Cat();
    	addObject(cat, 400, 0);
    	
    	dog = new Dog();
    	//addObject(dog, 200, 100);
    	
    	jack = new Jack();
    	//addObject(jack, 300, 100);
    	
    	ninja = new Ninja();
    	//addObject(ninja, 400,100);
    	
    	ladder = new Ladder();
    	addObject(ladder, 458,372);
    	
    	blockA = new Block();
    	addObject(blockA, 400,500);
    	blockB = new Block();
    	addObject(blockB, 528,372);
    	
    	Mayflower.showBounds(true);
    	
    	showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);
>>>>>>> d23e7589d5f1e6ba9d6bc039a0a53feb0d737e7d
    }
    
    public void act()
    {
    }
    
}