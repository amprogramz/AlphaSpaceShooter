package com.Alpha.Space.Shooter;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Ship
{
    private Rectangle hull = new Rectangle();
    private Rectangle wings = new Rectangle();
    private Ammo ammo = new Ammo();
    private double movement = 15;

    public Ship(double windowWidth, double windowHeight)
    {
        hull.setX(windowWidth/2);
        hull.setY(windowHeight/4);
        hull.setWidth(50);
        hull.setHeight(150);

        wings.setX((hull.getX() + (hull.getWidth()/2) - 50));
        wings.setY((hull.getY() + hull.getHeight()) - 50);
        wings.setWidth(100);
        wings.setHeight(50);


    }

    public ArrayList<Rectangle> getShip()
    {
        ArrayList<Rectangle> ship = new ArrayList<>();
        ship.add(hull);
        ship.add(wings);
        ship.add(ammo.getRound());
        return ship;
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
