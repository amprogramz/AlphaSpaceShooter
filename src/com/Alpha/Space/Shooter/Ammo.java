package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * This is a parent class to create various munitions for the ship.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Ammo
{
    private Rectangle ammo = new Rectangle();
    private double movement;
    private int damage;



    public Shape getRound()
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
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    public void shoot(EnemyArray enemy)
    {
        ammo.setY(ammo.getY() - movement);
        enemy.checkForDestruction(ammo, damage);
    }
    public void invokeShot(EnemyArray enemy)
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10),
                ae ->  shoot(enemy) ));


        timeline.setCycleCount(50);
        timeline.play();
    }
}
