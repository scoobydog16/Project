import mayflower.*;

public class Potion extends Yarn
{

    /**
     * Constructor for objects of class Potion
     */
    // allows the potion to not appear to large
    public Potion()
    {
        MayflowerImage image = new MayflowerImage("img/potion.png");
        image.scale(70,70);
        setImage(image);
    }
}
