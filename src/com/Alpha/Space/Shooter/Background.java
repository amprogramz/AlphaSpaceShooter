package com.Alpha.Space.Shooter;

//This is just the basic idea we discussed. we could also add a canvas for particle effects.
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Background
{
    Image background;
    Canvas moveableBackground = new Canvas();
    GraphicsContext moveableBackgroundGC = moveableBackground.getGraphicsContext2D();




    public Background(String filePath, double width, double height)
    {
        background = SpriteTool.setImage(filePath);
        moveableBackground.setHeight(height);
        moveableBackground.setWidth(width);
        //moveableBackground.setVisible(true);


        moveableBackgroundGC.setFill(Color.BLACK);
        moveableBackgroundGC.fillRect(0,0,width, height);
        moveableBackgroundGC.drawImage(background,0,0,width,height);

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
