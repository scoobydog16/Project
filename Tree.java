import mayflower.*;
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree extends Actor
{

    public Tree()
    {
       MayflowerImage thisImage = new MayflowerImage("img/NolanStuff/Tree.png"); 
       setImage(thisImage);
    }
    
    public Tree(float scaleFactor)
    {
       MayflowerImage image = new MayflowerImage("img/NolanStuff/Tree.png");
       int h = image.getHeight()* scaleFactor > 40 ? (int)(image.getHeight() * scaleFactor) : 40;
       h -= (h%40);
       image.scale(40,h);
       setImage(image);
    }

    public void act()
    {
        
    }
}
