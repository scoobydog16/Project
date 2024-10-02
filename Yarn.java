import mayflower.*;
public class Yarn extends Actor
{
    
    Class type;

    /**
     * Constructor for objects of class Yarn
     */
    public Yarn()
    {
        setImage("img/yarn.png");
        type = Cat.class;
    }

    public Yarn(float scaleFactor)
    {
       MayflowerImage image = new MayflowerImage("img/yarn.png");
       int w = (int)(image.getWidth() * scaleFactor);// > 40 ? (int)(image.getWidth() * scaleFactor) : 40;
       int h = (int)(image.getHeight()* scaleFactor);// > 40 ? (int)(image.getHeight() * scaleFactor) : 40;
       image.scale(w,h);
       setImage(image);
       type = Cat.class;
    }    
    
    public void act()
    {
       
            if(isTouching(type))
        {
            //This block of code will only execute if this Yarn is touching a
            // Cat object
            MovableAnimatedActor c = getOneIntersectingObject(MovableAnimatedActor.class);
            // Now you can call Cat methods on the c variable
            if(c.getClass() == type)
            {
                World w = getWorld(); // get this Actor's World
                c.increaseScore(1);
                w.removeObject(this); // remove this Actor from the World
            }
        }
    }
}
