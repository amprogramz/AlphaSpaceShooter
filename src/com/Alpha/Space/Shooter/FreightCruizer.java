package com.Alpha.Space.Shooter;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Author Alec McDaugale
 * This is a ship i have defined, inherits the abstract class ship.
 */

public class FreightCruizer extends Ship
{

        private Rectangle hull = new Rectangle();
        private Rectangle wings = new Rectangle();
        private Ammo ammo;
        private Ammo ammo2;

        private String movingSoundFile = "Sounds/SoundEffects/shipEngine1.wav";
        private String imageFileName = "Sprite/Spaceship_tut/Spaceship_tut.png";
        private String deathSoundFile = "Sounds/SoundEffects/Futuristic Explosion.wav";

        public FreightCruizer(double windowWidth, double windowHeight, Ammo ammo1, Ammo ammo2)
        {

            hull.setX(25);
            hull.setY(0);
            hull.setWidth(50);
            hull.setHeight(150);
            hull.setArcWidth(50);
            hull.setArcHeight(100);
            hull.setFill(Color.TRANSPARENT);

            wings.setX((0));
            wings.setY((hull.getY() + hull.getHeight()) - 60);
            wings.setWidth(100);
            wings.setHeight(30);
            wings.setFill(Color.TRANSPARENT);

            ImageView image = SpriteTool.getImage(imageFileName, wings.getX(),hull.getY(),wings.getWidth(), hull.getHeight(), false);

            this.ammo = ammo1;
            this.ammo2 = ammo2;

            this.ammo.setRoundLocation(-200, -200);
            this.ammo2.setRoundLocation(-200, -200);




            super.addShipParts(hull);
            super.addShipParts(wings);
            super.addShipParts(image);

            super.setMovement(10);
            super.setHitPoints(100);
            super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
            super.setShipMovingSound(SoundTool.getAudioClip(movingSoundFile));
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
