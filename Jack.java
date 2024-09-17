import mayflower.*;

public class Jack extends AnimatedActor
{

    private Animation idle;
    
    public Jack()
    {
        String frames[] = new String[10];
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/jack/Idle (" + (i + 1) + ").png";
        }
        idle = new Animation(500000, frames);
        setAnimation(idle);
        idle.scale(300,50);
        idle.setTransparency(90);
    }
    
    public void act() {
        
        super.act();
    }

}
