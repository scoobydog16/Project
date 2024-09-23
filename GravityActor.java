import mayflower.*;

public class GravityActor extends Actor
{
    
    public boolean gravOn;
    public float vertVelocity;
    public boolean isJumping;
    public boolean onBlock;
    
    public GravityActor()
    {
        vertVelocity = 0f;
        gravOn = true;
        isJumping = false;
        onBlock = false;
    }
     
    public void act() 
    {
        if(gravOn)
        {
            if(!isBlocked())
            {
                vertVelocity -= -0.09f;
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
