import mayflower.*;

public class Dog extends AnimatedActor
{
    
    private Animation dead;
    
    public Dog()
    {
        String frames[] = new String[10];
        for(int i = 0; i < 10; i++)
            frames[i] = "img/dog/Dead (" + (i + 1) + ").png";
        dead = new Animation(5000000, frames);
        setAnimation(dead);
        dead.scale(200,100);
        dead.setTransparency(70);
    }
    
    public void act()
    {
        super.act();
    }
}
