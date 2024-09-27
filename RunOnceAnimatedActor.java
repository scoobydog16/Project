import mayflower.*;
/**
 * Write a description of class RunOnceAnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RunOnceAnimatedActor extends AnimatedActor
{
    boolean finishedAnim;
    public RunOnceAnimatedActor()
    {
        finishedAnim = true;
    }

    public void act()
    {
        if(!finishedAnim)
        {
            super.act();
            if(animation.lastFrame())
                finishedAnim = true;
        }
    }
    
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
        finishedAnim = false;
    }
}
