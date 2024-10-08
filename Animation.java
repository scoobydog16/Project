import mayflower.*;

public class Animation
{
    //array of animation frames for objects
    private MayflowerImage frames[];
    private int frameRate;
    private int currentFrame;
    
    public Animation(int frameRate, String[] frames)
    {
        this.frames = new MayflowerImage[frames.length];
        for(int i = 0; i < frames.length; i++)
        {
            this.frames[i] = new MayflowerImage(frames[i]);
            //this.frames[i].scale(100,87);
            
        }
        this.frameRate = frameRate;
        currentFrame = 0;
    }
    
    public MayflowerImage getNextFrame()
    {
        MayflowerImage frame =  frames[currentFrame];
        currentFrame++;
        currentFrame %= frames.length;
        return frame;
    }
    
    /*
     * will return if the animation is currently on its final frame, used in runonce animated actor
     * in order to know when to stop animation
     */
    public boolean lastFrame()
    {
        return currentFrame + 1 == frames.length;
    }
    
    public int animSize()
    {
        return frames.length;
    }
    
    public void scale(int w, int h) {
       for(int i = 0; i < frames.length; i++)
            frames[i].scale(w,h); 
    }
    
    /*
     * can scale a single index in the frames list to a certain scale
     */
    public void scale(float scaleFactor, int index) 
    {
        int w = (int)(frames[index].getWidth() * scaleFactor);
        int h = (int)(frames[index].getHeight() * scaleFactor);
        frames[index].scale(w,h); 
    }
    
    public void setTransparency(int percent) {
       for(int i = 0; i < frames.length; i++)
            frames[i].setTransparency(percent); 
    }
    
    public void setBounds(int x, int y, int w, int h) {
        for(int i = 0; i < frames.length; i++)
            frames[i].crop(x,y,w,h);
    }
    
    public int getFrameRate() 
    {
        //System.out.println(frameRate);
        return frameRate;
    }
    
    // used if you want to restart an animation, instead of picking  it up where it was left 
    // (if you changed mid animation)
    public void reset()
    {
        currentFrame = 0;
    }
    
    public void mirrorHorizontally() 
    {
        for(int i = 0; i < frames.length; i++)
            frames[i].mirrorHorizontally(); 
    }
}
