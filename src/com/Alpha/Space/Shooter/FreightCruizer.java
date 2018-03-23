package com.Alpha.Space.Shooter;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.ArrayList;

/**
 * Author Alec McDaugale
 * This is a ship i have defined, inherits the abstract class ship.
 */

public class FreightCruizer extends Ship
{

        private Rectangle hull = new Rectangle();
        private Rectangle wings = new Rectangle();
        private Ammo ammo = new FiftyCaliber();

        private String imageFileName = "sprite/Spaceship_tut/Spaceship_tut.png";

        public FreightCruizer(double windowWidth, double windowHeight)
        {

            hull.setX(windowWidth/2);
            hull.setY(windowHeight/4);
            hull.setWidth(50);
            hull.setHeight(150);
            hull.setArcWidth(50);
            hull.setArcHeight(100);
            hull.setFill(Color.TRANSPARENT);




            wings.setX((hull.getX() + (hull.getWidth()/2) - 50));
            wings.setY((hull.getY() + hull.getHeight()) - 60);
            wings.setWidth(100);
            wings.setHeight(30);
            hull.setFill(Color.TRANSPARENT);

            ImageView image = new ImageView();
            image = SpriteTool.getImage(imageFileName, getX(),getY(),getWidth(), getHeight(), false);
            super.setImage(image);

            super.setMovement(15);
            super.setHitPoints(100);

        }
        @Override
        public ArrayList<Object> getShip()
        {
            ArrayList<Object> ship = new ArrayList<>();
            ship.add(getHull());
            ship.add(getWings());
            ship.add(getAmmo());
            ship.add(getImage());
            return ship;
        }

        public Shape getHull()
    {
        return hull;
    }
        public Shape getWings()
    {
        return wings;
    }

        public Shape getAmmo()
        {
            return ammo.getRound();
        }
        public double getX()
        {
            return wings.getX();
        }
        public double getY()
        {
            return hull.getY();
        }
        public double getWidth()
        {
            return wings.getWidth();
        }
        public double getHeight()
        {
            return hull.getHeight();
        }
        @Override
        public void moveShipRight()
        {
            hull.setX(hull.getX() + super.getMovement());
            wings.setX(wings.getX() + super.getMovement());

            ImageView imageView = super.getImage();
            imageView.setX(imageView.getX() + super.getMovement());
            setImage(imageView);
        }
        @Override
        public void moveShipLeft()
        {
            hull.setX(hull.getX() - super.getMovement());
            wings.setX(wings.getX() - super.getMovement());

            ImageView imageView = super.getImage();
            imageView.setX(imageView.getX() - super.getMovement());
            setImage(imageView);
        }
        @Override
        public void moveShipUp()
        {
            hull.setY(hull.getY() - super.getMovement());
            wings.setY(wings.getY() - super.getMovement());

            ImageView imageView = super.getImage();
            imageView.setY(imageView.getY() - super.getMovement());
            setImage(imageView);
        }
        @Override
        public void moveShipDown()
        {
            hull.setY(hull.getY() + super.getMovement());
            wings.setY(wings.getY() + super.getMovement());

            ImageView imageView = super.getImage();
            imageView.setY(imageView.getY() + super.getMovement());
            setImage(imageView);
        }
        public void setShot(EnemyArray enemy)
        {
            ammo.setAmmo(wings.getX()+ 21, wings.getY());
            ammo.invokeShot(enemy);
        }


}
