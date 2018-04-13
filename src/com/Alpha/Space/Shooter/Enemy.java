package com.Alpha.Space.Shooter;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

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
    Ammo ammo = new FiftyCaliber();

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


    public void destruct(int damage, Score score)
    {
        if(this.hitPoints > damage)
        {
            hitPoints = hitPoints - damage;
        }else
        {
            score.setScore(score.getScore() + 10);
            for (int index = 0; index < enemyShip.getChildren().size(); index++)
            {
                enemyShip.getChildren().get(index).setLayoutX(-2000);
            }

        }
    }

    public abstract void setShot(Ship ship, Score score);


    public abstract ArrayList<Group> getAmmo();

}
