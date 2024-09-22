import mayflower.*;

public class GravityActor extends Actor
{
    
    public boolean gravOn;
    public float vertVelocity;
    public boolean isJumping;
    
    public GravityActor()
    {
        vertVelocity = 0f;
        gravOn = true;
        isJumping = false;
    }
     
    public void act() 
    {
        if(gravOn)
        {
            if(!isBlocked())
            {
                vertVelocity -= -0.07f;
            } 
        }
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
            isJumping = false;
            setLocation(x, a.getY() - getHeight());
            vertVelocity = 0f;
        }
        return ret;
    }
    
    public boolean aboveBlock()
    {
        if(isBlocked() && isTouching(Block.class))
        {
           return getOneIntersectingObject(Block.class).getY() >= this.getY() + getHeight();
        }
        return false;
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
