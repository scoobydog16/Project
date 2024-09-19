import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    
    public Cat() 
    {
        String frames[] = new String[10];
        String frames8[] = new String[8];
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        walkRight = new Animation(5000000, frames);
        walkRight.scale(100,87);
        walkRight.setTransparency(50);
        walkRight.setBounds(18,6,54,80);
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        idleRight = new Animation(5000000, frames);
        idleRight.scale(100,87);
        idleRight.setTransparency(50);
        idleRight.setBounds(18,5,54,80);
        
        for(int i = 0; i < 8; i++)
        {
            frames8[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        fallRight = new Animation(500000000, frames8);
        fallRight.scale(100,87);
        fallRight.setTransparency(50);
        fallRight.setBounds(18,5,54,80);
        
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
        
        
        
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setFallAnimation(fallRight);
        setFallLeftAnimation(fallLeft);
    }
    public void act()
    {
        super.act();
    }
}
