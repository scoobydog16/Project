import mayflower.*;


public class Bomb extends AnimatedActor

{
    private int lives;
    private String frames[];
    private int currentFrame;
    private Timer animationTimer;
    private Animation bomb;

    
    public Bomb()
    {
        animationTimer = new Timer(1000000000);
        frames = new String[2];
        for(int i = 0; i < 2; i++)
        {
            frames[i] = ("img/flyingbomb" + (i + 1) + ".png");
        }
        bomb = new Animation(50, frames);
        setAnimation(bomb);
        bomb.scale(100, 87);
       
        
    }

    
    public void act()
    {
       if(isTouching(Cat.class))
        {
            //This block of code will only execute if this Yarn is touching a
            // Cat object
            MovableAnimatedActor a = getOneIntersectingObject(MovableAnimatedActor.class);
            // Now you can call Cat methods on the c variable
            Cat c = (Cat) a;
            World w = getWorld(); // get this Actor's World
            c.decreaseLives(1);
            w.removeObject(this); // remove this Actor from the World
            
            
            

        }
        if(animationTimer.isDone())
        {
            animationTimer.reset();
         
            currentFrame = (currentFrame + 1) % frames.length;
            setImage (frames[currentFrame]);
            
        }
    }
    
    
    
   
}
