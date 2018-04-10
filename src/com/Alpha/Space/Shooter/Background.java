package com.Alpha.Space.Shooter;

//This is just the basic idea we discussed. we could also add a canvas for particle effects.
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;

public class Background
{
    ImageView background;
    Canvas moveableBackground = new Canvas();
    String filePath = "sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg";

    public Background()
    {
        background = SpriteTool.getImage(filePath, 0, 0);
    }
    public Background(String filePath)
    {
        background = SpriteTool.getImage(filePath, 0, 0);

    }

    public Canvas getBackground()
    {
        return moveableBackground;
    }
    public void setZoom()
    {

    }
//    this is where we would call the animation, like timeline which calls move forward
    public void setInMotion()
    {

    }
    public void moveForward()
    {
    }

}
