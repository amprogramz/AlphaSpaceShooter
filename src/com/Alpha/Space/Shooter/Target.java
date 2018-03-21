package com.Alpha.Space.Shooter;

import javafx.scene.shape.Rectangle;

public class Target extends Enemy
{


    public Target(double x, double y, int index)
    {
        Rectangle target = new Rectangle();
        target.setX(x);
        target.setY(y);
        target.setWidth(100);
        target.setHeight(30);
        super.setEnemy(target);
        super.setTargetIndex(index);
        super.setHitPoints(30);
    }



}
