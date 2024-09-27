import mayflower.*;


public class Trigger extends Actor
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

    public Trigger(Actor obj, TriggerType type, int[] pos)
    {
        image = new MayflowerImage("img/NolanStuff/Empty.png");
        image.crop(0,0,100,100);
        setImage(image);
        trigger = type;
        affectedObject = obj;
        entered = false;
        spawnPos = pos;
    }

    public void act()
    {
        if(!entered && isTouching(MovableAnimatedActor.class))
        {
            System.out.println("entered");
            entered = true;
            playerEnter();    
        }
        else if(entered && !isTouching(MovableAnimatedActor.class))
        {
            System.out.println("exited");
            entered = false;
            playerExit();
        }
    }
    
    public void playerEnter()
    {
        World w = getWorld();
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
        }
        else if(trigger == TriggerType.holdDeactivate)
        {
            w.addObject(affectedObject, spawnPos[0], spawnPos[1]);
        }
    }
}
