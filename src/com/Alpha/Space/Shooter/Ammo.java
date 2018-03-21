package com.Alpha.Space.Shooter;


import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ammo
{
    private Rectangle ammo = new Rectangle();
    private double movement;



    public Rectangle getRound()
    {
        return ammo;
    }
    public void setAmmo(Rectangle ammo)
    {
        this.ammo = ammo;
    }
    public void setMovement(double movement)
    {
        this.movement = movement;
    }
    public void setAmmo(double x, double y)
    {
        ammo.setX(x);
        ammo.setY(y);
    }
    public void shoot(EnemyArray enemy)
    {
        ammo.setY(ammo.getY() - movement);
        enemy.checkForDestruction(ammo);
    }
}
