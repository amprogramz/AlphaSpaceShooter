package com.Alpha.Space.Shooter;

import javafx.scene.shape.Rectangle;

/**
 * Author Alec McDaugel
 * This is a parent class to create enemy objects.
 */
public class Enemy
{
    private Rectangle enemy = new Rectangle();
    private int targetIndex;
    private int hitPoints;

    public Rectangle getEnemy()
    {
        return enemy;
    }
    public void setEnemy(Rectangle enemy)
    {
        this.enemy = enemy;
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
            enemy.setX(-200);
        }
    }
}
