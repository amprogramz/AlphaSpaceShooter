package com.Alpha.Space.Shooter;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Author Alec McDaugle
 * This is a child class of Enemy. It is a basic target for testing.
 */
public class Target extends Enemy
{


    public Target(double x, double y, int index)
    {
        Rectangle target = new Rectangle();
        target.setX(x);
        target.setY(y);
        target.setWidth(100);
        target.setHeight(30);
        target.setFill(Color.GRAY);
        super.setEnemy(target);
        super.setTargetIndex(index);
        super.setHitPoints(30);
    }



}
