package com.Alpha.Space.Shooter;

//This is just the basic idea we discussed. we could also add a canvas for particle effects.
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Background
{
    Image background;
    Canvas moveableBackground = new Canvas();
    GraphicsContext moveableBackgroundGC = moveableBackground.getGraphicsContext2D();
    double BGwidth;
    double BGheight=400;

    public Background(String filePath, double width, double height)
    {
        background = SpriteTool.setImage(filePath);
        moveableBackground.setHeight(height);
        moveableBackground.setWidth(width);

        moveableBackgroundGC.setFill(Color.BLACK);
        moveableBackgroundGC.fillRect(0,0,width, height);
        moveableBackgroundGC.drawImage(background, BGwidth, BGheight-2000, 3000, 2400);
    }

    public Canvas getBackground()
    {
        return moveableBackground;
    }

    public void moveForward()
    {
    	//repaint frame 50 times a second
    	Timeline timeline = new Timeline(new KeyFrame(
    	        Duration.millis(15),
    	        ae -> move()));
    	timeline.setCycleCount(Animation.INDEFINITE);
    	timeline.play();
    }
    public void move(){
    	//Start from bottom left of image
    	if(BGheight <= 2200){
    		moveableBackgroundGC.drawImage(background, BGwidth, BGheight-2000, 3000, 2400);}

    	//move 1 pixel each time
    	BGheight += 1;
    	
    	//when it reaches top, reset
    	if (BGheight >= 2400){
    		BGheight = -400;
    		BGwidth -=1000;
    	}
    	//when it reaches right edge, reset
    	if (BGwidth <= -3000){
    		BGwidth = 0;
    	}
    }
    

}
