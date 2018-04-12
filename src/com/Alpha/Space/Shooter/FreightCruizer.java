package com.Alpha.Space.Shooter;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

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

            ammo2.setRoundLocation(-200, -200);
            ammo2.setRoundLocation(-200, -200);


            super.addShipParts(hull);
            super.addShipParts(wings);
            super.addShipParts(image);

            super.setMovement(15);
            super.setHitPoints(100);

        }


        public ArrayList<Group> getAmmo()
        {
            ArrayList<Group> ammoList = new ArrayList();
            ammoList.add(ammo.getRound());
            ammoList.add(ammo2.getRound());
            return ammoList;
        }
        public void setShot(EnemyArray enemy, Score score)
        {
            ammo.setRoundLocation(wings.getParent().getLayoutX() + 21, wings.getParent().getLayoutY());
            ammo.invokeShot(enemy, score);
            ammo2.setRoundLocation(wings.getParent().getLayoutX() + 78, wings.getParent().getLayoutY());
            ammo2.invokeShot(enemy, score);
        }





}
