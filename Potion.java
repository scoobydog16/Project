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
        setImage(image);
    }

    public void act()
    {
        super.act();
    }
}
