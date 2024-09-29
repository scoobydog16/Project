import mayflower.*;

public class Cat extends MovableAnimatedActor
{

    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation climbRight;
    private Animation climbLeft;

    
    public Cat(float jumpHeight, float gravity) 
    {
        super(jumpHeight, gravity);
        isCat = true;
        String frames[] = new String[10];
        String frames8[] = new String[8];
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/cat/Walk (" + (i + 1) + ").png";
        }
        walkRight = new Animation(1000000, frames);
        walkRight.scale(100,87);
        walkRight.setBounds(18,6,54,80);
        
        walkLeft = new Animation(1000000, frames);
        walkLeft.scale(100,87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28,5,54,80);
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/cat/Idle (" + (i + 1) + ").png";
        }
        idleRight = new Animation(1000000, frames);
        idleRight.scale(100,87);
        idleRight.setBounds(18,5,54,79);
        
        idleLeft = new Animation(1000000, frames);
        idleLeft.scale(100,87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28,5,54,80);
        
        for(int i = 0; i < 8; i++)
        {
            frames8[i] = "img/cat/Fall (" + (i + 1) + ").png";
        }
        fallRight = new Animation(50000000, frames8);
        fallRight.scale(100,87);
        fallRight.setBounds(18,5,54,80);
        
        fallLeft = new Animation(50000000, frames8);
        fallLeft.scale(100,87);
        fallLeft.mirrorHorizontally();
        fallLeft.setBounds(28,5,54,80);
        
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/NolanStuff/CatStuff/Climb (" + (i + 1) + ").png";
        }
        climbRight = new Animation(50000000, frames);
        climbRight.scale(100,87);
        climbRight.setBounds(18,5,54,80);
        
        climbLeft = new Animation(50000000, frames);
        climbLeft.scale(100,87);
        climbLeft.mirrorHorizontally();
        climbLeft.setBounds(28,5,54,80);
        
        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setFallRightAnimation(fallRight);
        setFallLeftAnimation(fallLeft);
        setClimbRightAnimation(climbRight);
        setClimbLeftAnimation(climbLeft);
    }
    public void act()
    {
        super.act();
        
        if(isTouching(Yarn.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            World w  = getWorld();
            //w.removeObject(this);
            
        }
    }
    
    
   
}
