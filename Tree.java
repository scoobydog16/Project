import mayflower.*;
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree extends Actor
{
    // sets the image to display the (custom) tree image
    public Tree()
    {
       MayflowerImage thisImage = new MayflowerImage("img/NolanStuff/Tree.png"); 
       setImage(thisImage);
    }
    // in addition to setting the image to a tree, it first scales image's height by some factor
    // then if it is smaller than the traditional scale of the world (40x40, or each block/tile on the grid
    // is 40 pixels wide and 40 pixels tall) if it smaller it sets it to 40
    // this allows one to adjust how tall the tree is
    public Tree(float scaleFactor)
    {
       MayflowerImage image = new MayflowerImage("img/NolanStuff/Tree.png");
       int h = (image.getHeight() * scaleFactor > 40) ? ((int)(image.getHeight() * scaleFactor)) : 40;
       h -= (h%40);
       image.scale(40,h);
       setImage(image);
    }

    public void act()
    {
        
    }
}
