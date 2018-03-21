package com.Alpha.Space.Shooter;

import javafx.scene.shape.Rectangle;

public class Target
{
    private Rectangle target = new Rectangle();
    private int targetIndex;

    public Target(double x, double y, int index)
    {
        target.setX(x);
        target.setY(y);
        target.setWidth(100);
        target.setHeight(30);
        targetIndex = index;
    }
    public Rectangle getBlock()
    {
        return target;
    }
    public int getIndex()
    {
        return targetIndex;
    }


    public void destruct()
    {
        target.setX(-200);
    }


}
