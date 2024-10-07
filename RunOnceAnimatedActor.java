import mayflower.*;
/**
 * Write a description of class RunOnceAnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RunOnceAnimatedActor extends AnimatedActor
{
    // this controls if the  normal animator runs or not, represents if it is on the last frame of the animation
    boolean finishedAnim; 
    public RunOnceAnimatedActor()
    {
        finishedAnim = true;
    }

    /*
     * only does the normal animation act method
     * if it is not on its last frame of animation
     * also checks if its on the last frame after the
     * animated actor's act method
     */
    public void act()
    {
        if(!finishedAnim)
        {
            super.act();
            if(animation.lastFrame())
                finishedAnim = true;
        }
    }
    
    /*
     * preforms animated actor's set animation and
     * additionally sets the boolean to false
     */
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
        finishedAnim = false;
    }
}
