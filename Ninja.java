import mayflower.*;

public class Ninja extends AnimatedActor
{
    
    private Animation attack;
    
    public Ninja()
    {
       String frames[] = new String[10];
       for(int i = 0; i < 10; i++)
       {
           frames[i] = "img/ninjagirl/Attack__00" + (i) + ".png";
       }
       attack = new Animation(500000, frames);
       setAnimation(attack);
       attack.scale(300,100);
       attack.setTransparency(20);
    }
    
    
    public void act() {
        super.act();
    }
   
}
