import mayflower.*;

public class Animation
{
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
    
    public void scale(int w, int h) {
       for(int i = 0; i < frames.length; i++)
            frames[i].scale(w,h); 
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
    
    public void mirrorHorizontally() 
    {
        for(int i = 0; i < frames.length; i++)
            frames[i].mirrorHorizontally(); 
    }
}
