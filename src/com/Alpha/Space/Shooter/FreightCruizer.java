package com.Alpha.Space.Shooter;

import javafx.collections.ObservableList;
import javafx.scene.Group;
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
        private Ammo ammo2 = new FiftyCaliber();

        //Group group

        private String imageFileName = "sprite/Spaceship_tut/Spaceship_tut.png";

        public FreightCruizer(double windowWidth, double windowHeight)
        {

            hull.setX(windowWidth/2);
            hull.setY(windowHeight/4 * 3);
            hull.setWidth(50);
            hull.setHeight(150);
            hull.setArcWidth(50);
            hull.setArcHeight(100);
            //hull.setFill(Color.TRANSPARENT);
            super.addShipParts(hull);




            wings.setX((hull.getX() + (hull.getWidth()/2) - 50));
            wings.setY((hull.getY() + hull.getHeight()) - 60);
            wings.setWidth(100);
            wings.setHeight(30);
            super.addShipParts(wings);
            //wings.setFill(Color.TRANSPARENT);

            ImageView image = SpriteTool.getImage(imageFileName, getX(),getY(),getWidth(), getHeight(), false);
            super.addShipParts(image);

            super.addShipParts(ammo.getRound());
            super.addShipParts(ammo2.getRound());

            super.setMovement(15);
            super.setHitPoints(100);

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
        public void setShot(EnemyArray enemy)
        {
            ammo.setAmmo(/*wings.getX() +5*/ wings.getParent().getLayoutX() +450 , wings.getY());
            ammo2.setAmmo(/*wings.getX() +95*/ wings.getWidth() + wings.getParent().getLayoutX() +450, wings.getY());
            ammo.invokeShot(enemy);
            ammo2.invokeShot(enemy);
            ammo.setAmmo(wings.getX() +5, wings.getY());
            ammo2.setAmmo(wings.getX() +95, wings.getY());
            ammo.invokeShot(enemy);
            ammo2.invokeShot(enemy);
        }


}
