package com.Alpha.Space.Shooter;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

/**
 * Author Alec McDaugel
 * This is a parent class to create enemy objects.
 */
public class Enemy
{
    private Group enemyShip = new Group();
    private ObservableList enemyShipParts = enemyShip.getChildren();
    private int targetIndex;
    private int hitPoints;

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
        return targetIndex;
    }
    public void setTargetIndex(int index)
    {
        targetIndex = index;
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
           // for (enemyShip.getChildren().size())
            enemyShip.getChildren().get(0).setLayoutX(-2000);

        }
    }
}
