package com.Alpha.Space.Shooter;

import javafx.scene.shape.Rectangle;

public class Target
{
    private Rectangle target = new Rectangle();
    private int targetIndex;
    private int hitPoints = 30;

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


    public void destruct(int damage)
    {
        if(this.hitPoints > damage)
        {
            hitPoints = hitPoints - damage;
        }else
        {
            target.setX(-200);
        }
    }


}
