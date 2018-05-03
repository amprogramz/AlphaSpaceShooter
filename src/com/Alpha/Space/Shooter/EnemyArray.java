package com.Alpha.Space.Shooter;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.util.Duration;


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
            index++;
            enemyArray.add(new Squid(temp, 20, index));
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
    public ArrayList<Enemy> getBlockGrid()
    {
        return enemyArray;
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

        }
//        enemyArray.get(4).setShot(ship, score);
    }

    public ArrayList<Node> getAllAmmo()
    {
        ArrayList<Node> ammo = new ArrayList<>();
        for (int index = 0; index < enemyArray.size(); index++ )
        {
            for (int index2 = 0; index2 < enemyArray.get(index).getAmmo().size(); index2++ )
            {
                ammo.add(enemyArray.get(index).getAmmo().get(index2));
            }

        }
        return ammo;


    }
    public void enemiesMove(double screenWidth, double screenHeight, Ship ship, Score score)
    {
        for (int index = 0; index < enemyArray.size(); index ++)
        {
            enemyArray.get(index).move(screenWidth, screenHeight, ship, score);
        }
    }

    public void animateMovement(double screenWidth, double screenHeight, Ship ship, Score score)
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10),
                ae -> enemiesMove(screenWidth, screenHeight, ship, score)));


        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}