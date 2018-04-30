package com.Alpha.Space.Shooter;


import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.media.AudioClip;


import java.util.ArrayList;

/**
 * Author Alec McDaugale
 * This is a parent class to create enemy objects.
 */
public abstract class Enemy implements Moveable
{
    private Group enemyShip = new Group();
    private ObservableList enemyShipParts = enemyShip.getChildren();
    private int enemyIndex;
    private int hitPoints;
    private int currentHitPoints;

    private double movement;


    private AudioClip movingSound;
    private AudioClip deathSound;


    /**
     * A method to return the enemy ship.
     * @return Returns the ship group object.
     */
    public Group getEnemy()
    {
        return enemyShip;
    }

    /**
     * Sets the enemy group object.
     * @param enemy this is the node to add to the group.
     */
    public void setEnemy(Node enemy)
    {
        enemyShipParts.add(enemy);
    }

    /**
     * Returns the index of the enemy for destruction.
     * @return Index of enemy.
     */
    public int getIndex()
    {
        return enemyIndex;
    }

    /**
     * Set the enemy index when added to the array.
     * @param index Index of the enemy.
     */
    public void setTargetIndex(int index)
    {
        enemyIndex = index;
    }

    /**
     * Sets the hit points of the enemy object.
     * @param hitPoints desired amount of hit points to give to enemy.
     */
    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
        currentHitPoints = hitPoints;
    }
    public void setMovement(double movement)
    {
        this.movement = movement;
    }
    public double getMovement()
    {
        return movement;
    }

    /**
     * Sets the moving sound to parameter.
     * @param movingSound This is the file path of the moving sound.
     */
	public void setMovingSound(AudioClip movingSound) {
		this.movingSound = movingSound;
	}

    /**
     * Sets the death sound to the file path.
     * @param deathSound This is the file path of the death sound.
     */
	public void setDeathSound(AudioClip deathSound) {
		this.deathSound = deathSound;
	}

    /**
     * Method to calculate destruction of the enemy object.
     * @param damage Amount of damage to deal.
     * @param score The score object to add points when destroyed.
     */
	public void destruct(int damage, Score score)
    {
        if(this.currentHitPoints > damage)
        {
            currentHitPoints = currentHitPoints - damage;
            //add sound here
        }else
        {
            score.setScore(score.getScore() + 10);
            for (int index = 0; index < enemyShip.getChildren().size(); index++)
            {
                enemyShip.setLayoutX((int)(Math.random() * 1000));
                System.out.println("Enemy location:" + enemyShip  .getLayoutX());
                enemyShip.setLayoutY(-1500);
                currentHitPoints = hitPoints;
                deathSound.play();
            }
            //add sound explode
        }
    }

    /**
     * Method to move left by units in parameter.
     * @param movement How many units to move by.
     */
    public void moveLeft(double movement)
    {
        enemyShip.setLayoutX(enemyShip.getLayoutX() - movement);
    }

    /**
     *Method to move right by units in parameter.
     * @param movement How many units to move by.
     */
    public void moveRight(double movement)
    {
        enemyShip.setLayoutX(enemyShip.getLayoutX() + movement);
    }

    /**
     * Method to move up by units in parameter.
     * @param movement How many units to move by.
     */
    public void moveUp(double movement)
    {
        enemyShip.setLayoutY(enemyShip.getLayoutY() - movement);
    }

    /**
     * Method to move down by units in parameter.
     * @param movement How many units to move by.
     */
    public void moveDown(double movement)
    {
        enemyShip.setLayoutY(enemyShip.getLayoutY() + movement);
    }


    /**
     * Abstract method to define how the shot is set.
     * @param ship Ship object to test for collision.
     * @param score Score object to record hp and lives of ship.
     */
    public abstract void setShot(Ship ship, Score score);

    /**
     * Abstract method to return the ammo.
     * @return Returns an array list of the ammo for the ship.
     */
    public abstract ArrayList<Node> getAmmo();



}