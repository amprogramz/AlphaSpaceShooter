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
//        private Ammo ammo = new FiftyCaliber();
        private Ammo ammo2 = new FiftyCaliber();

        private String imageFileName = "sprite/Spaceship_tut/Spaceship_tut.png";

        public FreightCruizer(double windowWidth, double windowHeight)
        {

            hull.setX(25);
            hull.setY(0);
            hull.setWidth(50);
            hull.setHeight(150);
            hull.setArcWidth(50);
            hull.setArcHeight(100);
            //hull.setFill(Color.TRANSPARENT);

            wings.setX((0));
            wings.setY((hull.getY() + hull.getHeight()) - 60);
            wings.setWidth(100);
            wings.setHeight(30);
            //wings.setFill(Color.TRANSPARENT);

            ImageView image = SpriteTool.getImage(imageFileName, wings.getX(),hull.getY(),wings.getWidth(), hull.getHeight(), false);

            //ammo.setRound( wings.getX() + 20, wings.getY());
            ammo2.setRound(wings.getX() + wings.getWidth() - 21, wings.getY());


            super.addShipParts(hull);
            super.addShipParts(wings);
            super.addShipParts(image);

           // super.addShipParts(ammo.getRound());
            super.addShipParts(ammo2.getRound());

            super.setMovement(15);
            super.setHitPoints(100);

        }

        public void setShot(EnemyArray enemy)
        {
            //Ammo ammo = new FiftyCaliber();
            //ammo.setRound( wings.getX() + 21, wings.getY());
            //super.addShipParts(ammo);
            ammo2.setRound (wings.getParent().getLayoutX()+ 50 , wings.getY());
            //ammo.invokeShot(enemy);
            ammo2.invokeShot(enemy);
        }


}
