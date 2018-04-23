package com.Alpha.Space.Shooter;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;

/**
 * Author Alec McDaugel
 * This is a parent class to create enemy objects.
 */
public abstract class Enemy
{
    private Group enemyShip = new Group();
    private ObservableList enemyShipParts = enemyShip.getChildren();
    private int enemyIndex;
    private int hitPoints;
<<<<<<< HEAD
    private double movement;
    Ammo ammo = new FiftyCaliber();
=======
    private AudioClip movingSound;
    private AudioClip deathSound = SoundTool.getAudioClip("Sounds/Sound Effects/Small Futuristic Explosion.mp3");
    Ammo ammo = new Phaser();
>>>>>>> cb8ec7ef98d2804ef75cd0967bc105c7496b9b11

    public Group getEnemy()
    {
        return enemyShip;
    }
    public void setEnemy(Rectangle enemy)
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
        if(this.hitPoints > damage)
        {
            hitPoints = hitPoints - damage;
            //add sound here
        }else
        {
            score.setScore(score.getScore() + 10);
            for (int index = 0; index < enemyShip.getChildren().size(); index++)
            {
                enemyShip.getChildren().get(index).setLayoutX(-2000);
                deathSound.play();
            }
            //add sound explode
        }
    }

    public abstract void setShot(Ship ship, Score score);


    public abstract ArrayList<Group> getAmmo();

}