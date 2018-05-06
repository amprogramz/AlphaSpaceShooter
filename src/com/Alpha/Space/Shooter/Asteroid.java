package com.Alpha.Space.Shooter;

import javafx.scene.shape.Circle;

public class Asteroid extends SpaceObject implements Moveable
{
    Circle circle;
    int index;

    public Asteroid(double x, double y, int index)
    {
        super.setHitPoints((int)(Math.random() * 600));
        circle = new Circle();
        circle.setCenterX(0);
        circle.setCenterY(0);
        circle.setRadius(75);

        super.addParts(circle);

        super.setDefaultObjectLocation(x, y);
    }

    @Override
    public void Destruct(int damage, Score score)
    {
        if (circle.getRadius() > 0)
        {
            circle.setRadius(circle.getRadius() - damage);
        }else
        {
            //circle.getParent().setLayoutX();
            circle.getParent().setLayoutY(-2000);
        }
    }



    @Override
    public void move(double screenWidth, double screenHeight, Ship ship, Score score)
    {
        moveDown(screenHeight);
    }

}
