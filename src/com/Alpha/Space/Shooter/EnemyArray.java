package com.Alpha.Space.Shooter;


import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * Author Alec McDaugale
 * This is an array to store Enemy objects for later use.
 */
public class EnemyArray
{
    private ArrayList<Enemy> enemyArray = new ArrayList<>();

    public EnemyArray(int numberOfTargets)
    {
        for(int index = 0; index < numberOfTargets; index++)
        {
            double temp = (25 + ((25 * index) + (100 * index)));
            enemyArray.add(new Target(temp, 20, index));
        }
    }

    public ArrayList<Group> getEnemies()
    {
        ArrayList<Group> blocksToReturn = new ArrayList<>();
        for (int index = 0; index < enemyArray.size(); index++ )
        {
            blocksToReturn.add(enemyArray.get(index).getEnemy());
        }
        return blocksToReturn;
    }
    public EnemyArray getBlockGrid()
    {
        return this;
    }

    public boolean checkForDestruction(Group ammo, int damage, Score score)
    {
        for(Enemy block : enemyArray)
        {
            if(Colideable.collision(ammo, enemyArray.get(block.getIndex()).getEnemy()))
            {
                System.out.println("Block Hit " + block.getIndex());
                enemyArray.get(block.getIndex()).destruct(damage, score);
                return true;
            }
        }
        return false;

    }

    private void removeFromArray(int index)
    {
        enemyArray.remove(index);
    }

    public void startShooting(Ship ship, Score score)
    {
        for (int index = 0; index < enemyArray.size(); index++ )
        {
            enemyArray.get(index).setShot(ship, score);
            //enemyArray.get(index).shoot();
        }
    }

    public ArrayList<ArrayList<Group>> getAllAmmo()
    {
        ArrayList<ArrayList<Group>> enemyAmmo = new ArrayList<>();
        for (int index = 0; index < enemyArray.size(); index++ )
        {
            enemyAmmo.add(enemyArray.get(index).getAmmo());
        }
        return enemyAmmo;
    }

}
