import mayflower.*;

public class MovableAnimatedActor extends Actor
{
    // instance variables - replace the example below with your own
    
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private Animation fall;
    private Animation fallLeft;
    private String currentAction;
    private String direction;
    private float jumpForce;
    boolean isJumping;

    public MovableAnimatedActor()
    {
       direction = "right";
       jumpForce = 13f;
       isJumping = false;
    }
    
    public void act()
    {
         super.act();
         String newAction = null;
        if(currentAction == null)
        {
            setAnimation(idle);
            currentAction = "idle";
        }
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();

        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) // Moving Right
        {
            if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && aboveBlock() && !isJumping)
            {
                setLocation(x + 1, y - 3);
                vertVelocity = jumpForce;
                isJumping = true;
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y + h < 600)
                setLocation(x + 1, y + 1);
            else
                setLocation(x + 1, y);
            newAction = "walkRight";
            direction = "right";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0)
        {
            if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && aboveBlock() && !isJumping)
            {
                setLocation(x - 1, y - 3);
                vertVelocity = jumpForce;
                isJumping = true;
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y + h < 600)
                setLocation(x - 1, y + 1);
            else
                setLocation(x - 1, y);
            setLocation(x - 1, y + 1);
            newAction = "walkLeft";
            direction = "left";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y + h < 600) 
        {
            setLocation(x,y + 1);
            newAction = "walkRight";
        }
        if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && aboveBlock() && !isJumping)
            {
                setLocation(x, y - 3);
                vertVelocity = jumpForce;
                isJumping = true;
            }
        else
        {
           newAction = "idle";
           if(direction != null && direction.equals("left"))
                newAction = "idleLeft";
        }
        
        if(isFalling())
        {
           newAction = "fall";
           if(direction != null && direction.equals("left"))
                newAction = "fallLeft";
        }
        
        if(isTouching(Ladder.class))
            newAction = "climbing";
        
        if(super.isBlocked())
        {
            setLocation(x, y);
            newAction = "idle";
        }
        
        if(newAction != null && !currentAction.equals(newAction))
        {
            if(newAction.equals("idle"))
                setAnimation(idle);
            
            if(newAction.equals("idleLeft"))
                setAnimation(idleLeft);
            
            if(newAction.equals("fall"))
                setAnimation(fall);
            
            if(newAction.equals("fallLeft"))
                setAnimation(fallLeft);
                
            if(newAction.equals("walkRight"))
                setAnimation(walkRight);
                
            if(newAction.equals("walkLeft"))
                setAnimation(walkLeft);
            
            if(newAction.equals("climbing"))
                System.out.print("climbing");
            currentAction = newAction;
        }
    }
    
    public void setAnimation(Animation a)
    { super.setAnimation(a); }
    
    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft = ani;
    }
    
    public void setIdleAnimation(Animation ani)
    {
        idle = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
    }
    
    public void setFallAnimation(Animation ani)
    {
        fall = ani;
    }
    
    public void setFallLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }
}
