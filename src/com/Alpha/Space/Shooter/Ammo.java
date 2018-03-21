package com.Alpha.Space.Shooter;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ammo
{
    private Rectangle ammo = new Rectangle();


    public Ammo()
    {

        ammo.setWidth(2);
        ammo.setHeight(10);
        ammo.setFill(Color.RED);
    }
    public Rectangle getRound()
    {
        return ammo;
    }
    public void setAmmo(double x, double y)
    {
        ammo.setX(x);
        ammo.setY(y);
    }

    public void shoot()
    {

    }
}
