package com.Alpha.Space.Shooter;


import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ammo
{
    private Rectangle ammo = new Rectangle();
    private final double MOVMENT = 30;


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

    public void shoot(EnemyArray enemy)
    {
        ammo.setY(ammo.getY() - MOVMENT);
        enemy.checkForDestruction(ammo);
    }
}
