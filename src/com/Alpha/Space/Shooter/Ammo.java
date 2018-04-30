package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * This is a parent class to create various munitions for the ship.
 */


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public abstract class Ammo
{
    private Group round = new Group();
    private double movement;
    private int damage;
    private AudioClip shotSound;

    /**
     * Method to set the ammo elements.
     * @param ammo This is abstract, so can contain a Shape, Image, ect..
     */
    public void setRound(Node ammo)
    {
        round.getChildren().add(ammo);
    }

    public void setRound(Ammo ammo){round.getChildren().add(ammo.getRound());}

    /**
     * Method to set the location of the round.
     * @param x Value of x.
     * @param y Value of Y.
     */
    public void setRoundLocation(double x, double y)
    {
        round.setLayoutX(x);
        round.setLayoutY(y);
    }

    /**
     * Method to return the round of Ammo.
     * @return Returns a group node.
     */
    public Group getRound()
    {
        return round;
    }

    /**
     * Method to set the movement value. Added or subtracted from X or Y value.
     * @param movement Value of movement.
     */
    public void setMovement(double movement)
    {
        this.movement = movement;
    }

    /**
     * Return the movement value.
     * @return Value of movement.
     */
    public double getMovement()
    {
        return this.movement;
    }

    /**
     * Sets the ammount of damage the round deals. This can be added or subtracted from a health.
     * @param damage Value of damage.
     */
    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    /**
     * Setts the value of shotSound
     * @param shotSound An AudioClip for the shot sound;
     */
    public void setShotSound(AudioClip shotSound)
    {
        this.shotSound = shotSound;
    }

    /**
     * Checks for collision and moves the ammo off the screen if a collision happens.
     * @param enemy The enemy array to test the collisions against.
     */
    public void enemyColishionCheck(EnemyArray enemy, Score score)
    {
        boolean hit = enemy.checkForDestruction(round, damage, score);
        if (hit)
        {
            setRoundLocation(-200, 0);
        }
    }
    public void shipColishionCheck(Ship ship, Score score)
    {
        boolean hit = ship.checkForShipDestruction(round, damage, score);
        if (hit)
        {
            setRoundLocation(-200, 0);
        }
    }

    /**
     * Abstact method to define the way the ammo moves when fired. This is the place to get creative.
     * @param enemy The enemy array to test the collisions against.
     */
    public abstract void shipShoot(EnemyArray enemy, Score score);
    public abstract void enemyShoot(Ship ship, Score score);

    /**
     * Invokes a timeline which calls the shoot method.
     * @param enemy The enemy array to test the collisions against.
     */
    public void invokeShipShot(EnemyArray enemy, Score score)
    {

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10),
                ae ->  shipShoot(enemy, score) ));


        timeline.setCycleCount(50);
        timeline.play();

        shotSound.play();

    }
    public void invokeEnemyShot(Ship ship, Score score)
    {

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10),
                ae ->  enemyShoot(ship, score) ));


        timeline.setCycleCount(50);
        //timeline.delayProperty().setValue(Duration.seconds(2));
        timeline.play();

        shotSound.play();

    }
}
