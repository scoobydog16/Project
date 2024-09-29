import mayflower.*;


public class Trigger extends RunOnceAnimatedActor
{
    public static enum TriggerType
    {
         holdActivate, holdDeactivate, pressActivate, pressDeactivate
    }
    
    Actor affectedObject;
    int[] spawnPos;
    TriggerType trigger;
    boolean entered;
    MayflowerImage image;
    Animation pressed;
    Animation unpressed;
    
    public Trigger(Actor obj, TriggerType type, int[] pos, float scale)
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
        affectedObject = obj;
        entered = false;
        spawnPos = pos;
    }

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
    
    public void playerEnter()
    {
        World w = getWorld();
        setAnimation(pressed);
        unpressed.reset();
        if(trigger == TriggerType.holdActivate)
        {
            w.addObject(affectedObject, spawnPos[0], spawnPos[1]);
        }
        else if(trigger == TriggerType.holdDeactivate)
        {
            w.removeObject(affectedObject);
        }
        else if(trigger == TriggerType.pressActivate)
        {
            w.addObject(affectedObject, spawnPos[0], spawnPos[1]);
        }
        else if(trigger == TriggerType.pressDeactivate)
        {
            w.removeObject(affectedObject);
        }
    }
    
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
