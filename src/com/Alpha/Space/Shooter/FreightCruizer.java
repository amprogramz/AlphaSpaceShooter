package com.Alpha.Space.Shooter;

import javafx.scene.Group;
import javafx.scene.Node;
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
        private Ammo ammo = new Phaser();
        private Ammo ammo2 = new Missile();

        private String imageFileName = "sprite/Spaceship_tut/Spaceship_tut.png";
        private String deathSoundFile = "Sounds/SoundnEffects/Futuristic Explosion.wav";

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

            ammo.setRoundLocation(-200, -200);
            ammo2.setRoundLocation(-200, -200);


            super.addShipParts(hull);
            super.addShipParts(wings);
            super.addShipParts(image);

            super.setMovement(15);
            super.setHitPoints(100);
            super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));

        }

        @Override
        public ArrayList<Node> getAmmo()
        {
            ArrayList<Node> ammoList = new ArrayList<>();
            ammoList.add(ammo.getRound());
            ammoList.add(ammo2.getRound());
            ammoList.add(ammo.getHitExplosionSprite());
            ammoList.add(ammo2.getHitExplosionSprite());
            return ammoList;
        }
        @Override
        public void setShot(EnemyArray enemy, Score score)
        {
            ammo.setRoundLocation(wings.getParent().getLayoutX() + 21, wings.getParent().getLayoutY());
            ammo.invokeShipShot(enemy, score);
            ammo2.setRoundLocation(wings.getParent().getLayoutX() + 78, wings.getParent().getLayoutY());
            ammo2.invokeShipShot(enemy, score);
        }





}
