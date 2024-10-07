import mayflower.*;

public class Bone extends Yarn // by extending yarn it can be picked up, increase score, and delete itself
{
    // instead of being a yarn image, it will be a bone image, with a scalable height and width
    public Bone(float scaleFactor)
    {
       MayflowerImage image = new MayflowerImage("img/NolanStuff/Bone.png"); 
       int w = (int)(image.getWidth() * scaleFactor);
       int h = (int)(image.getHeight()* scaleFactor);
       image.scale(w,h);
       setImage(image);
       type = Dog.class; // by setting the type to dog, it can be a dog pickup item, instead of a cat's
    } 
}
