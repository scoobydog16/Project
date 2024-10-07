import mayflower.*;

public class Dog extends MovableAnimatedActor
{

    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation swimRight;
    private Animation swimLeft;
    private Animation climbRight;
    private Animation climbLeft;
    
    /*
     * sets the animation frames
     */
    public Dog(float jumpHeight, float gravity, float scale) 
    {
        // will instead of being controled by arrow keys like cat, it is controlled by WASD
        super(jumpHeight, gravity, 2f, Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
        isCat = false;
        String frames[] = new String[10];
        String frames8[] = new String[8];
        String frames6[] = new String[6];
        for(int i = 0; i < 10; i++)
        {
            frames[i] = "img/dog/Walk (" + (i + 1) + ").png";
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
            frames[i] = "img/dog/Idle (" + (i + 1) + ").png";
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
            frames8[i] = "img/dog/Fall (" + (i + 1) + ").png";
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
            frames[i] = "img/NolanStuff/DogStuff/Climb (" + (i + 1) + ").png";
        }
        climbRight = new Animation(50000000, frames);
        climbRight.scale(100,87);
        climbRight.setBounds(18,5,54,80);
        
        climbLeft = new Animation(50000000, frames);
        climbLeft.scale(100,87);
        climbLeft.mirrorHorizontally();
        climbLeft.setBounds(28,5,54,80);
        
        for(int i = 0; i < 6; i++)
        {
            frames6[i] = "img/NolanStuff/DogStuff/Swim (" + (i + 1) + ").png";
        }
        swimRight = new Animation(50000000, frames6);
        swimRight.scale(100,87);
        swimRight.setBounds(18,5,54,80);
        
        swimLeft = new Animation(50000000, frames6);
        swimLeft.scale(100,87);
        swimLeft.mirrorHorizontally();
        swimLeft.setBounds(28,5,54,80);

        setWalkRightAnimation(walkRight);
        setWalkLeftAnimation(walkLeft);
        setIdleRightAnimation(idleRight);
        setIdleLeftAnimation(idleLeft);
        setFallRightAnimation(fallRight);
        setFallLeftAnimation(fallLeft);
        setSwimRightAnimation(swimRight);
        setSwimLeftAnimation(swimLeft);
        setClimbRightAnimation(climbRight);
        setClimbLeftAnimation(climbLeft);
        
        setScales(scale);
    }
    public void act()
    {
        super.act();
    }
    
    
}
