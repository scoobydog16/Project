import mayflower.*;

public class GravityActor extends AnimatedActor
{
    // a boolean to toggle gravity, used for water and ladder/tree
    public boolean gravOn;
    // the current velocity, doesn't reset after every frame, so it can be small or large
    public float vertVelocity;
    public boolean isJumping;
    public boolean onBlock;
    // how much the velocity changes by per second (if in the air)
    public float gravity;
    
    public GravityActor(float gravity)
    {
        vertVelocity = 0f;
        gravOn = true;
        isJumping = false;
        onBlock = false;
        this.gravity = gravity;
    }
    
    public GravityActor()
    {
        vertVelocity = 0f;
        gravOn = true;
        isJumping = false;
        onBlock = false;
        this.gravity = -0.09f;
    }
    
    /*
     * every frame it will either decrease the gravity if it is not on a block or set the vert velocity to 0, 
     */
    public void act() 
    {
        super.act();
        if(gravOn)
        {
            if(!isBlocked())
            {
                vertVelocity -= -gravity;
            } 
        }
        else
            vertVelocity = 0;
    }
    
    public boolean isBlocked() 
    {
        int x = getX();
        int y = getY();
        setLocation(x, y + 1);
        boolean ret = isTouching(Block.class);
        if(ret)
        {
            Block a = getOneIntersectingObject(Block.class);
            if(a.getY() > y && a.getX() <= x + getWidth() && a.getX() + a.getWidth() >= x)
            {
                isJumping = false;
                onBlock = true;
                setLocation(x, a.getY() - getHeight());
                vertVelocity = 0f;
            }
        }
        else
            isJumping = true;
        return ret;
    }
    
    public boolean isFalling() 
    {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        
        return !ret;
    }

}
