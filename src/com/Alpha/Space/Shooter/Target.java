package com.Alpha.Space.Shooter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Author Alec McDaugle
 * This is a child class of Enemy. It is a basic target for testing.
 */
public class Target extends Enemy
{

    Ammo ammo = new FiftyCaliber();
    Rectangle target = new Rectangle();

    String deathSoundFile = "Sounds/SoundEffects/Small Futuristic Explosion.mp3";
    public Target(double x, double y, int index)
    {

        target.setLayoutX(x);
        target.setLayoutY(y);
        target.setWidth(100);
        target.setHeight(30);
        target.setFill(Color.GRAY);
        super.setEnemy(target);

        super.setTargetIndex(index);
        super.setHitPoints(30);

        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
    }

    @Override
    public void setShot(Ship ship, Score score)
    {
        ammo.setRoundLocation(target.getParent().getLayoutX(), target.getParent().getLayoutY());
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
    public void move(double screenWidth, double screenHeight)
    {
        //boolean directionX;
        if (target.getParent().getLayoutX() < screenWidth && directionX == true)
        {
            moveRight(5);
        }
        else if (target.getParent().getLayoutX() == screenWidth)
        {
            directionX = false;
            moveLeft(5);
        }
        else if (target.getParent().getLayoutX() > 0 && directionX == false)
        {

            moveLeft(5);
        }else
        {
            directionX = true;
            moveRight(5);
        }
    }
}
