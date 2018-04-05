package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * This is a parent class to create various munitions for the ship.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Ammo
{
    private Rectangle ammo = new Rectangle();
    private double movement;
    private int damage;



    public Group getRound()
    {
        Group round = new Group();
        round.getChildren().add(ammo);
        return round;
    }
    public void setAmmo(Rectangle ammo)
    {
        this.ammo = ammo;
    }
    public void setMovement(double movement)
    {
        this.movement = movement;
    }
    public void setRound(double x, double y)
    {
        ammo.setLayoutX(x);
        ammo.setLayoutY(y);
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    public void shoot(EnemyArray enemy)
    {
        ammo.setLayoutY(ammo.getLayoutY() - movement);
        enemy.checkForDestruction(ammo, damage);
    }
    public void invokeShot(EnemyArray enemy)
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10),
                ae ->  shoot(enemy) ));


        timeline.setCycleCount(50);
        //timeline.setAutoReverse(true);
        timeline.play();
    }
}
