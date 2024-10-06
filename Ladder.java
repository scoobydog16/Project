import mayflower.*;
/**
 * When the player comes in contact with this object they can ignore normal gravity and climb vertically
 * (without gravity affecting their speed)
 *
 * 
 * Allows Cat to climb upwards without jumping
 * 
 */
public class Ladder extends Actor
{
    // sets the image to display the (custom) ladder image
    public Ladder()
    {
       MayflowerImage thisImage = new MayflowerImage("img/Ladder.png");
       setImage(thisImage);
    }
    // in addition to setting the image to a ladder, it first scales image's height and width by some factor
    // then if it is smaller than the traditional scale of the world (40x40, or each block/tile on the grid
    // is 40 pixels wide and 40 pixels tall) if it smaller it sets it to 40
    // this allows one to adjust how tall and wide the ladder is
    public Ladder(float scaleFactor)
    {
       MayflowerImage image = new MayflowerImage("img/Ladder.png");
       int w = image.getWidth()* scaleFactor > 40 ? (int)(image.getWidth() * scaleFactor) : 40;
       int h = image.getHeight()* scaleFactor > 40 ? (int)(image.getHeight() * scaleFactor) : 40;
       image.scale(w,h);
       setImage(image);
    }
    
    public void act()
    {
        
    }
    
}
