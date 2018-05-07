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
public abstract class Enemy extends Ship implements Moveable
{
   private int enemyIndex;
    private double currentHitPoints;

    /**
     * Method to calculate destruction of the enemy object.
     * @param damage Amount of damage to deal.
     * @param score The score object to add points when destroyed.
     */
    @Override
	public void Destruct(int damage, Score score)
    {
        if(this.currentHitPoints > damage)
        {
            currentHitPoints = currentHitPoints - damage;
            //add sound here
        }else
        {
            score.setScore(score.getScore() + 10);
            for (int index = 0; index < super.getObj().getChildren().size(); index++)
            {
                super.moveShip((int)(Math.random() * 1000), -1500);
                System.out.println("Enemy location:" + super.getObj().getParent().getLayoutX());
                currentHitPoints = super.getHitPoints();
                super.getDeathSound().play();
            }
        }
    }
    public abstract void setShot(SpaceObject enemy, Score score);

}