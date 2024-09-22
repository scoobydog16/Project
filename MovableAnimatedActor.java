import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor
{
    // instance variables - replace the example below with your own
    
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private String currentAction;
    private String direction;
    private float jumpForce;

    public MovableAnimatedActor()
    {
       direction = "right";
       jumpForce = -4f;
    }
    
    public void act()
    {
         super.act();
         String newAction = null;
        if(currentAction == null)
        {
            setAnimation(idleRight);
            currentAction = "idle";
        }
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        float horzChange = 0;
        float vertChange = 0;

        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) // Moving Right
        {
            if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && onBlock && !isJumping)
            {
                horzChange += 1;
                vertChange -= 3;
                vertVelocity = jumpForce;
                isJumping = true;
                onBlock = false;
                newAction = "fall";
            }
            else
            {
                horzChange += 1;
                newAction = "walk";
            }   
            direction = "right";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0)
        {
            if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && onBlock && !isJumping)
            {
                horzChange -= 1;
                vertChange -= 3;
                vertVelocity = jumpForce;
                isJumping = true;
                onBlock = false;
                newAction = "fall";
            }
            else
            {
                horzChange -= 1;
                newAction = "walk";
            }  
            direction = "left";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y + h < 600) 
        {
            vertChange += 1;
            newAction = "fall";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && onBlock && !isJumping)
        {
            vertChange -= 3;
            vertVelocity = jumpForce;
            isJumping = true;
            onBlock = false;
            newAction = "fall";
        }
        else if (isBlocked())
        {
           newAction = "idle";
        }
        
        if(isTouching(Ladder.class))
            newAction = "climbing";
            
        if(isJumping)
            newAction = "fall";
        
        if(newAction != null && !currentAction.equals(newAction))
        {
            if(direction.equals("left"))
            {
                if(newAction.equals("idle"))
                    setAnimation(idleLeft);
                else if(newAction.equals("fall"))
                    setAnimation(fallLeft);
                else if(newAction.equals("walk"))
                    setAnimation(walkLeft);
                else if(newAction.equals("climbing"))
                    System.out.print("climbing");
            }
            else if(direction.equals("right"))
            {
                if(newAction.equals("idle"))
                    setAnimation(idleRight);
                if(newAction.equals("fall"))
                    setAnimation(fallRight);
                if(newAction.equals("walk"))
                    setAnimation(walkRight);
                if(newAction.equals("climbing"))
                    System.out.print("climbing");
            }
            currentAction = newAction;
        }
        
        setLocation(x + horzChange, y);
        if(isTouching(Block.class))
            horzChange = 0;
        setLocation(x,y);
        
        System.out.println(currentAction);
        setLocation(x + horzChange, y + vertChange + vertVelocity);
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
        idleRight = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
    }
    
    public void setFallAnimation(Animation ani)
    {
        fallRight = ani;
    }
    
    public void setFallLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }
    
    
}
