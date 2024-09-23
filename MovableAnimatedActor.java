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
       jumpForce = -3f;
    }
    
    public void act()
    {
        super.act();
        String newAction = null;
        String newDir = direction;
        // ^^^ if player is doing same action, walking/jumping, but just changes direction the player wouldn't change
        // animation because if statement at the end only checks if action is different, so now it also can
        // check if direction changed
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
                if(!isTouching(Ladder.class))
                {
                    vertVelocity = jumpForce;
                    isJumping = true;
                    onBlock = false;
                }
                
                newAction = "fall";
            }
            else
            {
                horzChange += 1;
                newAction = "walk";
            }   
            newDir = "right";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0)
        {
            if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && onBlock && !isJumping)
            {
                horzChange -= 1;
                vertChange -= 3;
                if(!isTouching(Ladder.class))
                {
                    vertVelocity = jumpForce;
                    isJumping = true;
                    onBlock = false;
                }
                
                newAction = "fall";
            }
            else
            {
                horzChange -= 1;
                newAction = "walk";
            }  
            newDir = "left";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y + h < 600) 
        {
            vertChange += 1;
            newAction = "fall";
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && onBlock && !isJumping)
        {
            vertChange -= 3;
            if(!isTouching(Ladder.class))
            {
                vertVelocity = jumpForce;
                isJumping = true;
                onBlock = false;
            }
            newAction = "fall";
        }
        else if (isBlocked())
        {
           newAction = "idle";
        }
        
        if(isTouching(Ladder.class))
        {
            if(gravOn)
                gravOn = false;
            if(Mayflower.isKeyDown(Keyboard.KEY_UP))
            {
                vertChange -= 3;
                setLocation(x, y + 1);
                if(getOneIntersectingObject(Ladder.class).getY() >= y + h - 5)
                {
                    vertVelocity = jumpForce;
                    isJumping = true;
                    onBlock = false;
                    gravOn = true;
                }
                setLocation(x,y);
            }
            if(Mayflower.isKeyDown(Keyboard.KEY_DOWN))
                vertChange += 2;
                
            
        }
        else if(!gravOn && !isTouching(Ladder.class))
            gravOn = true;
            
        if(isJumping)
            newAction = "fall";
        
        if(newAction != null && !currentAction.equals(newAction) || !newDir.equals(direction))
        {   // divides the setting animation into the direction of left or right
            // each one should have the same checks of each animation, idle, fall, walk, ect...
            if(newDir.equals("left"))
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
            else if(newDir.equals("right"))
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
            direction = newDir;
        }
        

        setLocation(x + horzChange, y);
        if(isTouching(Block.class))
            horzChange = 0;
        setLocation(x,y);
        // ^^^ if moving left/right causes the player to run into a block
        // the player will no longer move left/right to avoid phasing through it
        
        setLocation(x, y + vertChange);
        if(isTouching(Block.class))
            vertChange = 0;
        setLocation(x,y);
        // ^^^ if moving up/down causes the player to run into a block
        // the player will no longer move up/down to avoid phasing through it
        
        // (current position + left/right movement, current position + up/down movement and changing velocity
        // up/down movement: instant changes so that way the player isn't touching something while jumping,
        // mostly to avoid errors
        // changing velocity is the simulation of gravity/the jump force
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
