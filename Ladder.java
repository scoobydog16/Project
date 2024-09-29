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
    public Ladder()
    {
       MayflowerImage thisImage = new MayflowerImage("img/Ladder.png");
       //thisImage.crop(0,0,40,100); 
       setImage(thisImage);
    }
    
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
