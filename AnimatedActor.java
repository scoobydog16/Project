import mayflower.*;
public class AnimatedActor extends GravityActor
{
    // creates Animation and Timer objects
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor()
    {
        // instatiates animationTimer with a time of 1000
        animationTimer = new Timer(1000);

    }
    
    // allows Actors with Animations to use AnimatedActor methods
    public void setAnimation(Animation a) 
    {
        animation = a;
        // sets Animation's frame rate to the Timer object's timer
        animationTimer.set(animation.getFrameRate());
    }
    
    public void act()
    {
        // checks if Actor has an Animation object
        if(animation != null)
        {
            // checks if Actor's frame rate/timer is done
            if(animationTimer.isDone())
            {
                // resets the timer, and plays the next frame; repeats after all frames are played
                animationTimer.reset();
                MayflowerImage nextFrame = animation.getNextFrame();
                setImage(nextFrame);
            }
        }
        // does actions from GravityActor class
        super.act();
    }
}
