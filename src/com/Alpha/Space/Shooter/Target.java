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

    Rectangle target = new Rectangle();
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
    }
    public void setShot(Ship ship, Score score)
    {
        ammo.setRoundLocation(target.getX(), target.getY());
        ammo.invokeEnemyShot(ship, score);
    }

    public ArrayList<Group> getAmmo()
    {
        ArrayList<Group> ammoList = new ArrayList<>();
        ammoList.add(ammo.getRound());

        return ammoList;
    }



}
