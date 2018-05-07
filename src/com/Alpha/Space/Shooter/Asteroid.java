package com.Alpha.Space.Shooter;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Asteroid extends SpaceObject implements Moveable
{
    private Circle circle;
    private int index;
    private String imageFileName = "Sprite/Moon.png";


    public Asteroid(double x, double y, int index)
    {
        super.setHitPoints((int)(Math.random() * 600));
        circle = new Circle();
        circle.setCenterX(0);
        circle.setCenterY(0);
        circle.setRadius(getHitPoints());

        Image image = SpriteTool.getImage(imageFileName, circle.getCenterX(), circle.getCenterY(), 20, 20, false).getImage();
        circle.setFill(new ImagePattern(image));

        super.addParts(circle);
        super.setMovement(0.25);

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
    public void move(double screenWidth, double screenHeight, UserShip ship, Score score)
    {
        moveDown(super.getMovement());
    }

}
