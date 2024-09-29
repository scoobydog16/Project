import mayflower.*;

public class Block extends Actor
{

    public Block()
    {
        setImage("img/Tiles/2.png");
    }
    
    public Block(int width, int height)
    {
        MayflowerImage image= new MayflowerImage("img/Tiles/2.png");
        image.scale(width,height);
        setImage(image);
    }
    
    public void act() {}

}
