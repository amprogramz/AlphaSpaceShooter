package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * The Ship class is an abstract parent class to create a ship. I made it abstract, but im trying to make this work for
 * a variety of shapes.
 */

import javafx.scene.image.ImageView;
import java.util.ArrayList;


public abstract class Ship
{
    private double movement;
    private double hitPoints;
    private ImageView image = new ImageView();


    public void setImage(ImageView image)
    {
        this.image = image;
    }
    public ImageView getImage()
    {
        return image;
    }
    public void setMovement(int movement)
    {
        this.movement = movement;
    }
    public double getMovement()
    {
        return movement;
    }
    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }
    public double getHitPoints()
    {
        return hitPoints;
    }

    public abstract ArrayList<Object> getShip();

    public abstract double getX();
    public abstract double getY();
    public abstract double getWidth();
    public abstract double getHeight();

    public abstract void moveShipRight();
    public abstract void moveShipLeft();
    public abstract void moveShipUp();
    public abstract void moveShipDown();




}
