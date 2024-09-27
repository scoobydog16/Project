import mayflower.*;


public class Bomb extends Actor

{
    private int lives;
    private MayflowerImage frames[];
    private int currentFrame;
    private Timer animationTimer;

    
    public Bomb()
    {
        /**
        for(int i = 0; i < 10; i++)
        {
            frames[i] = MayflowerImage("img/flyingbomb" + i + ".png");
        }
        walk = new Animation(50, frames);
        setAnimation(walk);
        walk.scale(100, 87);
        **/
        
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
