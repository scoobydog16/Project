import mayflower.*;

public class Potion extends Yarn
{

    /**
     * Constructor for objects of class Potion
     */
    // dimensions: 117 * 129 
    public Potion()
    {
        MayflowerImage image = new MayflowerImage("img/potion.png");
        image.scale(70,70);
        setImage(image);
        System.out.print(getWidth());
    }
}
