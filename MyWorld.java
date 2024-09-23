import mayflower.*;

public class MyWorld extends World 
{

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
    	addObject(ladder, 528,272);
    	
    	blockA = new Block();
    	addObject(blockA, 400,500);
    	blockB = new Block();
    	addObject(blockB, 528,372);
    	
    	Mayflower.showBounds(true);
    	
    	showText("Lives: " + cat.getLives(), 10, 30, Color.BLACK);
    }
    
    public void act()
    {
    }
    
}