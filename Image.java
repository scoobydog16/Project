import mayflower.*;
/**
 * Write a description of class Image here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Image extends Actor
{

    public Image(String picture, int w, int h)
    {
        MayflowerImage image = new MayflowerImage(picture);
        image.scale(w,h);
        setImage(image);
    }

    public void act()
    {}
}
