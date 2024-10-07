import mayflower.*;
public class Yarn extends Actor
{
    //used to check what it needs to touch to increase its score
    Class type;

    public Yarn()
    {
        setImage("img/yarn.png");
        type = Cat.class;
    }
    
    /*
     * allows the yarn to be scaleds once created, to a ceratin size
     */
    public Yarn(float scaleFactor)
    {
       MayflowerImage image = new MayflowerImage("img/yarn.png");
       int w = (int)(image.getWidth() * scaleFactor);// > 40 ? (int)(image.getWidth() * scaleFactor) : 40;
       int h = (int)(image.getHeight()* scaleFactor);// > 40 ? (int)(image.getHeight() * scaleFactor) : 40;
       image.scale(w,h);
       setImage(image);
       type = Cat.class;
    }    
    
    /*
     * checks that it is touching the correct type (dog/cat)
     * if so it increases the touched cat/dog's score by 1 and removes
     * itself from the world
     */
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
