import mayflower.*;

public class MovableAnimatedActor extends GravityActor
{
    // instance variables - replace the example below with your own
    
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation swimRight;
    private Animation swimLeft;
    private Animation climbRight;
    private Animation climbLeft;
    private Animation[] animations;
    private String currentAction;
    private String direction;
    private float jumpForce;
    private float runSpeed;
    public boolean isCat;
    private int upKey;
    private int downKey;
    private int leftKey;
    private int rightKey;
    private int score = 0;
    private int lives = 3;
    private int textX;
    private int textY;
   

    public MovableAnimatedActor(float jumpForce, float gravity)
    {
       super(gravity); 
        
       direction = "right";
       this.jumpForce = -jumpForce;
       runSpeed = 4;
       upKey = Keyboard.KEY_UP;
       downKey = Keyboard.KEY_DOWN;
       leftKey = Keyboard.KEY_LEFT;
       rightKey = Keyboard.KEY_RIGHT;
       animations = new Animation[] {walkRight, walkLeft, idleRight, idleLeft, 
           fallRight, fallLeft, swimRight, swimLeft, climbRight, climbLeft};
    }
    
    public MovableAnimatedActor(float jumpForce, float gravity, float runSpeed, int up, int down, int left, int right)
    {
       super(gravity); 
       
       direction = "right";
       this.jumpForce = -jumpForce;
       this.runSpeed = runSpeed;
       upKey = up;
       downKey = down;
       leftKey = left;
       rightKey = right;
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

        if(Mayflower.isKeyDown(rightKey) && x + w < 800) // Moving Right
        {
            if(Mayflower.isKeyDown(upKey) && y > 0 && onBlock && !isJumping)
            {
                horzChange += runSpeed;
                vertChange -= 3;
                if(!isTouching(Ladder.class) || !isTouching(Water.class) || (isCat && !isTouching(Tree.class)))
                {
                    vertVelocity = jumpForce;
                    isJumping = true;
                    onBlock = false;
                }
                
                newAction = "fall";
            }
            else
            {
                horzChange += runSpeed;
                newAction = "walk";
            }   
            newDir = "right";
        }
        else if(Mayflower.isKeyDown(leftKey) && x > 0)
        {
            if(Mayflower.isKeyDown(upKey) && y > 0 && onBlock && !isJumping)
            {
                horzChange -= runSpeed;
                vertChange -= 3;
                if(!isTouching(Ladder.class) || !isTouching(Water.class) || (isCat && !isTouching(Tree.class)))
                {
                    vertVelocity = jumpForce;
                    isJumping = true;
                    onBlock = false;
                }
                
                newAction = "fall";
            }
            else
            {
                horzChange -= runSpeed;
                newAction = "walk";
            }  
            newDir = "left";
        }
        else if(Mayflower.isKeyDown(downKey) && y + h < 600) 
        {
            vertChange += 1;
            newAction = "fall";
        }
        else if(Mayflower.isKeyDown(upKey) && y > 0 && onBlock && !isJumping)
        {
            vertChange -= 3;
            if(!isTouching(Ladder.class) || !isTouching(Water.class) || (isCat && !isTouching(Tree.class)))
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
        
        if(isTouching(Ladder.class) || isTouching(Water.class) || (isCat && isTouching(Tree.class)))
        {
            if(gravOn)
                gravOn = false;
            if(Mayflower.isKeyDown(upKey))
            {
                vertChange -= 3;
                setLocation(x, y + 1);
                Actor touch;
                if(isTouching(Ladder.class))
                    touch = getOneIntersectingObject(Ladder.class);
                else if (isTouching(Tree.class))
                    touch = getOneIntersectingObject(Tree.class);
                else
                    touch = getOneIntersectingObject(Water.class);
                if(touch != null &&touch.getY() >= y + h - 5 )
                {
                    vertVelocity = jumpForce;
                    isJumping = true;
                    onBlock = false;
                    gravOn = true;
                }
                setLocation(x,y);
            }
            if(Mayflower.isKeyDown(downKey))
                vertChange += 2;
                
            
        }
        else if(!gravOn && (!isTouching(Ladder.class) || !isTouching(Water.class) ||
            (isCat && !isTouching(Tree.class))))
            gravOn = true;
            
        
        if (isTouching(Ladder.class) || (isCat && isTouching(Tree.class)))
            newAction = "climbing";
        else if (isTouching(Water.class) && !isCat)
            newAction = "swimming";
        else if(isJumping)
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
                    setAnimation(climbLeft);
                else if(newAction.equals("swimming") && !isCat)
                    setAnimation(swimLeft);
            }
            else if(newDir.equals("right"))
            {
                if(newAction.equals("idle"))
                    setAnimation(idleRight);
                else if(newAction.equals("fall"))
                    setAnimation(fallRight);
                else if(newAction.equals("walk"))
                    setAnimation(walkRight);
                else if(newAction.equals("climbing"))
                    setAnimation(climbRight);
                else if(newAction.equals("swimming") && !isCat)
                    setAnimation(swimRight);
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
    
    public void setIdleRightAnimation(Animation ani)
    {
        idleRight = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
    }
    
    public void setFallRightAnimation(Animation ani)
    {
        fallRight = ani;
    }
    
    public void setFallLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }
    
    public void setSwimRightAnimation(Animation ani)
    {
        swimRight = ani;
    }
    
    public void setSwimLeftAnimation(Animation ani)
    {
        swimLeft = ani;
    }
    
    public void setClimbRightAnimation(Animation ani)
    {
        climbRight = ani;
    }
    
    public void setClimbLeftAnimation(Animation ani)
    {
        climbLeft = ani;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public void decreaseLives(int amount)
    {
        lives -= amount;
        gameOver();
        updateText();
        
    }
    
    public void increaseScore(int score)
    {
        score++;
    }
    
    public void gameOver()
    {
           if(lives < 0)
           {
               Mayflower.setWorld(new GameOverWorld());
           }
    }
    
    public void setTextPosition(int x, int y)
    {
        textX = x;
        textY =y;
    }
    
    public void updateText()
    {
        World w = getWorld();
        w.removeText(textX, textY);
        w.showText("Lives: " + lives, textX, textY, Color.BLACK);
    }
    
    public void setScales(float scaleFactor)
    {
        System.out.println("hi");
        for(int i = 0; i < animations.length; i++)
        {

            if(animations[i] != null)
            {
                System.out.println("hello");
                for(int index = 0; index < animations[i].animSize(); index++) 
                {
                    animations[i].scale(scaleFactor, index);
                }
            }
        }
    }
}
