package com.Alpha.Space.Shooter;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class Ship
{
    private Rectangle hull = new Rectangle();
    private Rectangle wings = new Rectangle();
    private Ammo ammo = new FiftyCaliber();
    private double movement;




    public abstract ArrayList<Rectangle> getShip();

    public Rectangle getHull()
    {
        return hull;
    }

    public void setHull(Rectangle hull)
    {
        this.hull = hull;
    }

    public Rectangle getWings()
    {
        return wings;
    }

    public void setWings(Rectangle wings)
    {
        this.wings = wings;
    }
    public Rectangle getAmmo()
    {
        return ammo.getRound();
    }
    public void setMovement(int movement)
    {
        this.movement = movement;
    }

    public double getX()
    {
        return wings.getX();
    }
    public double getY()
    {
        return hull.getY();
    }
    public double getWidth()
    {
        return wings.getWidth();
    }
    public double getHeight()
    {
        return hull.getHeight();
    }

    public void moveShipRight()
    {
        hull.setX(hull.getX() + movement);
        wings.setX(wings.getX() + movement);
    }
    public void moveShipLeft()
    {
        hull.setX(hull.getX() - movement);
        wings.setX(wings.getX() - movement);
    }
    public void moveShipUp()
    {
        hull.setY(hull.getY() - movement);
        wings.setY(wings.getY() - movement);
    }
    public void moveShipDown()
    {
        hull.setY(hull.getY() + movement);
        wings.setY(wings.getY() + movement);
    }

    public void setShot()
    {
        ammo.setAmmo(wings.getX(), wings.getY());
    }

    public void invokeShot(EnemyArray enemy)
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10),
                ae ->  ammo.shoot(enemy) ));


        timeline.setCycleCount(50);
        timeline.play();
    }
}
