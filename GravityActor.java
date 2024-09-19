import mayflower.*;

public class GravityActor extends Actor
{
    
    public boolean gravOn;
    public float vertVelocity;
    
    public GravityActor()
    {
        vertVelocity = 0f;
    }
     
    public void act() 
    {
        int x = getX();
        int y = getY();
        setLocation(x, y + 1);
        if(isBlocked())
        {
            setLocation(x, y - 1);
            vertVelocity = 0f;
        }    
        else
            vertVelocity += 0.07f;
    }
    
    public boolean isBlocked() 
    {
        return isTouching(Block.class);
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
