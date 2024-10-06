import mayflower.*;

public class Water extends Danger // extends the danger to use some of its original methods
{
    // checks if player is currently within its bounds, mainly usef for 
    boolean playerEnter;
    MayflowerImage image;
    // these are the images that make up the body of water
    Image[] waterSprites;
    
    /*
     * sets the image to empty, this class acts as a hitbox to the given images
     */
    public Water(int width, int height, int x, int y, Image[] water)
    {
        super(width, height, x, y, "img/NolanStuff/Empty.png");
        waterSprites = water;
        playerEnter = false;
    }

    
    public void act()
    {
        super.act();
        if(playerEnter)
            if(!isTouching(Dog.class))
                playerExit();
    }
    
    /*
     * if the dog enters it sets all the water images to have a low transparency
     * if the cat enters it runs the normal player enter (which decreases a life + respawns)
     */
   
    public void playerEnter()
    {
        if(isTouching(Dog.class) && !playerEnter)
        {
            for(Image a : waterSprites)
                a.getImage().setTransparency(30);
            playerEnter = true;
        }
        
        if(isTouching(Cat.class))
        {
            super.playerEnter();
        }
    }
    
    /*
     * should only run if the dog is touching it
     * when it runs it sets the transparency back to normal (and sets boolean to false)
     */
    public void playerExit()
    {
        playerEnter = false;
        for(Image a : waterSprites)
            a.getImage().setTransparency(0);
    }
}
