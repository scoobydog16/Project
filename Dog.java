import mayflower.*;

public class Dog extends MovableAnimatedActor
{
    private int lives = 3;
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    
    public Dog(float jumpHeight, float gravity) 
    {
        super(jumpHeight, gravity, 2f, Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
        String frames[] = new String[10];
        String frames8[] = new String[8];
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/dog/Walk (" + (i + 1) + ").png";
        }
        walkRight = new Animation(1000000, frames);
        walkRight.scale(100,87);
        walkRight.setBounds(18,6,54,80);
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/dog/Idle (" + (i + 1) + ").png";
        }
        idleRight = new Animation(1000000, frames);
        idleRight.scale(100,87);
        idleRight.setBounds(18,5,54,79);
        
        for(int i = 0; i < 8; i++)
        {
            frames8[i] = "img/dog/Fall (" + (i + 1) + ").png";
        }
        fallRight = new Animation(50000000, frames8);
        fallRight.scale(100,87);
        fallRight.setBounds(18,5,54,80);
        
        for(int i = 0; i < 8; i++)
        {
            frames8[i] = "img/dog/Fall (" + (i + 1) + ").png";
        }
        fallLeft = new Animation(50000000, frames8);
        fallLeft.scale(100,87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(28,5,54,80);
        
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/dog/Walk (" + (i + 1) + ").png";
        }
        walkLeft = new Animation(1000000, frames);
        walkLeft.scale(100,87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28,5,54,80);
        
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/dog/Idle (" + (i + 1) + ").png";
        }
        idleLeft = new Animation(1000000, frames);
        idleLeft.scale(100,87);
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
    
    public int getLives()
    {
        return lives;
    }
    
    public void decreaseLives(int amount)
    {
        lives -= amount;
    }
}
