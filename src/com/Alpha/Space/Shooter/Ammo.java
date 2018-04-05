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
    Group round = new Group();

    private double movement;
    private int damage;



    public Group getRound()
    {


        return round;
    }
    public void setAmmo(Rectangle ammo)
    {
        this.ammo = ammo;
        round.getChildren().add(ammo);
    }
    public void setMovement(double movement)
    {
        this.movement = movement;
    }
    public void setRound(double x, double y)
    {
        round.setLayoutX(x);
        round.setLayoutY(y);
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    public void shoot(EnemyArray enemy)
    {
        round.setLayoutY(round.getLayoutY() - movement);
        enemy.checkForDestruction(round, damage);
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
