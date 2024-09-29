import mayflower.*;

public class Bone extends Yarn
{
    // instance variables - replace the example below with your own
    public Bone(float scaleFactor)
    {
       MayflowerImage image = new MayflowerImage("img/NolanStuff/Bone.png");
       int w = (int)(image.getWidth() * scaleFactor);// > 40 ? (int)(image.getWidth() * scaleFactor) : 40;
       int h = (int)(image.getHeight()* scaleFactor);// > 40 ? (int)(image.getHeight() * scaleFactor) : 40;
       image.scale(w,h);
       setImage(image);
       type = Dog.class;
    } 

}
