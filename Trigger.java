import mayflower.*;

//because it extends run once animated actor, it will play its animations once, not looping them
public class Trigger extends RunOnceAnimatedActor
{
    // gives a set list of ways the trigger can be used:
    // hold activate: the player has to remain on it to spawn an object
    // hold decativate: the player has to remain on it to despawn an object
    // hold activate: the player has to press it once (and can walk away) on it to spawn an object
    // hold decativate: the player has to press it once (and can walk away) on it to despawn an object
    public static enum TriggerType
    {
         holdActivate, holdDeactivate, pressActivate, pressDeactivate
    }
    
    // what is spawned/despawns
    Actor affectedObject;
    //where to spawn/despawn object
    int[] spawnPos;
    //what its trigger type is (hold/press spawn/despawn)
    TriggerType trigger;
    //is it pressed
    boolean entered;
    // the animation of being pressed
    Animation pressed;
    //the animation of being unpressed
    Animation unpressed;
    // if it is a ledge or object being affected (it needs special conditions)
    boolean ledge;
    // if it is a ledge, how large
    int width;
    
    //initialises the variables
    public Trigger(Actor obj, TriggerType type, int[] pos, float scale)
    {
        String[] frames = new String[8];
        //makes pressed animation
        for(int i = 1; i < 9; i++)
            frames[i-1] = "img/NolanStuff/Button (" + i + ").png";
        pressed = new Animation(10000000, frames);
        // makes unpressed animation
        for(int i = 1; i < 9; i++)
            frames[8-i] = "img/NolanStuff/Button (" + i + ").png";
        unpressed = new Animation(10000000, frames);
        // sets their scales
        for(int i = 0; i < 8; i++)
        {
            pressed.scale(scale, i);
            unpressed.scale(scale, i);
        }
        MayflowerImage img = new MayflowerImage("img/NolanStuff/Button (1).png");
        img.scale((int)(img.getWidth() * scale), (int)(img.getHeight() * scale));
        setImage(img);
        trigger = type;
        ledge = false;
        width = 0;
        affectedObject = obj;
        entered = false;
        spawnPos = pos;
    }
    
    // does the same as the other, but for ledge objects where it has the width
    public Trigger(int width, TriggerType type, int[] pos, float scale)
    {
        String[] frames = new String[8];

        for(int i = 1; i < 9; i++)
            frames[i-1] = "img/NolanStuff/Button (" + i + ").png";
        pressed = new Animation(10000000, frames);
        for(int i = 1; i < 9; i++)
            frames[8-i] = "img/NolanStuff/Button (" + i + ").png";
        unpressed = new Animation(10000000, frames);
        for(int i = 0; i < 8; i++)
        {
            pressed.scale(scale, i);
            unpressed.scale(scale, i);
        }
        MayflowerImage img = new MayflowerImage("img/NolanStuff/Button (1).png");
        img.scale((int)(img.getWidth() * scale), (int)(img.getHeight() * scale));
        setImage(img);
        trigger = type;
        ledge = true;
        this.width = width;
        entered = false;
        spawnPos = pos;
    }
    
    //checks if player has entered or exited, and plays the functions accordingly
    public void act()
    {
        if(!entered && isTouching(MovableAnimatedActor.class))
        {
            entered = true;
            playerEnter();    
        }
        else if(entered && !isTouching(MovableAnimatedActor.class))
        {
            entered = false;
            playerExit();
        }
        super.act();
    }
    
    // depending on the triggertype, it will spawn or despawn and object, or do nothing,
    // also plays pressed animation
    public void playerEnter()
    {
        World w = getWorld();
        setAnimation(pressed);
        unpressed.reset();
        if(trigger == TriggerType.holdActivate)
        {
            if(ledge)
                w.addObject(new Ledge(width),spawnPos[0], spawnPos[1]);
            else
                w.addObject(affectedObject, spawnPos[0], spawnPos[1]);
        }
        else if(trigger == TriggerType.holdDeactivate)
        {
            w.removeObject(affectedObject);
        }
        else if(trigger == TriggerType.pressActivate)
        {
            if(ledge)
                w.addObject(new Ledge(width),spawnPos[0], spawnPos[1]);
            else
                w.addObject(affectedObject, spawnPos[0], spawnPos[1]);
        }
        else if(trigger == TriggerType.pressDeactivate)
        {
            w.removeObject(affectedObject);
        }
    }
    
    // depending on the triggertype, it will spawn or despawn and object, or do nothing,
    // also plays unpressed animation
    public void playerExit()
    {
        World w = getWorld();
        if(trigger == TriggerType.holdActivate)
        {
            w.removeObject(affectedObject);
            setAnimation(unpressed);
            pressed.reset();
        }
        else if(trigger == TriggerType.holdDeactivate)
        {
            w.addObject(affectedObject, spawnPos[0], spawnPos[1]);
            setAnimation(unpressed);
            pressed.reset();
        }
    }
}
