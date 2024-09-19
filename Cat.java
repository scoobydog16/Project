import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Animation walk;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private Animation fall;
    private Animation fallLeft;
    
    public Cat() 
    {
        String frames[] = new String[10];
        String frames8[] = new String[8];
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        walk = new Animation(5000000, frames);
        walk.scale(100,87);
        walk.setTransparency(50);
        walk.setBounds(18,6,54,80);
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        idle = new Animation(5000000, frames);
        idle.scale(100,87);
        idle.setTransparency(50);
        idle.setBounds(18,5,54,80);
        
        for(int i = 0; i < 8; i++)
        {
            frames8[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        fall = new Animation(500000000, frames8);
        fall.scale(100,87);
        fall.setTransparency(50);
        fall.setBounds(18,5,54,80);
        
        for(int i = 0; i < 8; i++)
        {
            frames8[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        fallLeft = new Animation(500000000, frames8);
        fallLeft.scale(100,87);
        fallLeft.setTransparency(50);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(28,5,54,80);
        
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        walkLeft = new Animation(5000000, frames);
        walkLeft.scale(100,87);
        walkLeft.setTransparency(50);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28,5,54,80);
        
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        idleLeft = new Animation(5000000, frames);
        idleLeft.scale(100,87);
        idleLeft.setTransparency(50);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28,5,54,80);
        
        
        
        setWalkRightAnimation(walk);
        setWalkLeftAnimation(walkLeft);
        setIdleAnimation(idle);
        setIdleLeftAnimation(idleLeft);
        setFallAnimation(fall);
        setFallLeftAnimation(fallLeft);
    }
    public void act()
    {
        super.act();
    }
    
    
}
