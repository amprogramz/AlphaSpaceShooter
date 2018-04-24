package com.Alpha.Space.Shooter;
/**
 * Author: Alec McDaugale
 * This is a class to define a flying saucer which extends Enemy.
 */

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import java.util.ArrayList;

public class Saucer extends Enemy
{
    Ammo ammo = new FiftyCaliber();
    Circle saucer = new Circle();

    String deathSoundFile = "Sounds/SoundEffects/Small Futuristic Explosion.mp3";
    public Saucer(double x, double y, int index)
    {

        saucer.setLayoutX(0);
        saucer.setLayoutY(0);
        saucer.setRadius(20);

        saucer.setFill(Color.GRAY);
        super.setEnemy(saucer);

        saucer.getParent().setLayoutX(x);
        saucer.getParent().setLayoutY(y);

        super.setTargetIndex(index);
        super.setHitPoints(40);

        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
    }

    @Override
    public void setShot(Ship ship, Score score)
    {
        ammo.setRoundLocation(saucer.getParent().getLayoutX(), saucer.getParent().getLayoutY());
        ammo.invokeEnemyShot(ship, score);
    }

    @Override
    public ArrayList<Group> getAmmo()
    {
        ArrayList<Group> ammoList = new ArrayList<>();
        ammoList.add(ammo.getRound());

        return ammoList;
    }

    boolean directionX = true;
    @Override
    public void move(double screenWidth, double screenHeight, Ship ship, Score score)
    {
        if (saucer.getParent().getLayoutX() < screenWidth
                && directionX == true
                && !Colideable.collision(ship.getShipObj(), getEnemy()))
        {
            moveRight(1);
            moveDown(1);
        }
        else if (saucer.getParent().getLayoutX() >= screenWidth
                || Colideable.collision(ship.getShipObj(), getEnemy())
                && saucer.getParent().getLayoutX() <= ship.getX())
        {
            directionX = false;
            moveLeft(1);
            moveDown(1);
        }
        else if (saucer.getParent().getLayoutX() > 0
                && directionX == false
                && !Colideable.collision(ship.getShipObj(), getEnemy()))
        {

            moveLeft(1);
            moveDown(1);
        }else if (saucer.getParent().getLayoutX() <= 0
                || Colideable.collision(ship.getShipObj(), getEnemy())
                && saucer.getParent().getLayoutX() >= ship.getX())
        {
            directionX = true;
            moveRight(1);
            moveDown(1);
        }

        if (saucer.getParent().getLayoutY() == screenHeight)
        {
            moveUp(screenHeight + 100);
        }

        if (saucer.getParent().getLayoutX() > 0 && saucer.getParent().getLayoutX() < screenWidth && saucer.getParent().getLayoutY() > 0) {
            int shootRandom = (int) (Math.random() * 100);


            if (shootRandom == 3) {
                setShot(ship, score);
            }
        }

    }
}
