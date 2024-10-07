import mayflower.*;
/**
 * Write a description of class Image here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImageBlock extends Block
{
    //basiclly block class but you can change the picture, allowing you to have the same
    //mechanics of a block, with different images
    public ImageBlock(String picture, int w, int h)
    {
        MayflowerImage image = new MayflowerImage(picture);
        image.scale(w,h);
        setImage(image);
    }

    public void act(){}
}
