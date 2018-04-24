package com.Alpha.Space.Shooter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Author Alec McDaugel
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



    public Group getEnemy()
    {
        return enemyShip;
    }
    public void setEnemy(Shape enemy)
    {
        enemyShipParts.add(enemy);
    }
    public int getIndex()
    {
        return enemyIndex;
    }
    public void setTargetIndex(int index)
    {
        enemyIndex = index;
    }
    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
        currentHitPoints = hitPoints;
    }

    public AudioClip getMovingSound() {
		return movingSound;
	}
	public void setMovingSound(AudioClip movingSound) {
		this.movingSound = movingSound;
	}
	public AudioClip getDeathSound() {
		return deathSound;
	}
	public void setDeathSound(AudioClip deathSound) {
		this.deathSound = deathSound;
	}
	

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
                enemyShip.setLayoutX(-1000);
                enemyShip.setLayoutY(-1500);
                currentHitPoints = hitPoints;
                deathSound.play();
            }
            //add sound explode
        }
    }

    public void moveLeft(double movement)
    {
        enemyShip.setLayoutX(enemyShip.getLayoutX() - movement);
    }
    public void moveRight(double movement)
    {
        enemyShip.setLayoutX(enemyShip.getLayoutX() + movement);
    }
    public void moveUp(double movement)
    {
        enemyShip.setLayoutY(enemyShip.getLayoutY() - movement);
    }
    public void moveDown(double movement)
    {
        enemyShip.setLayoutY(enemyShip.getLayoutY() + movement);
    }



    public abstract void setShot(Ship ship, Score score);


    public abstract ArrayList<Group> getAmmo();



}