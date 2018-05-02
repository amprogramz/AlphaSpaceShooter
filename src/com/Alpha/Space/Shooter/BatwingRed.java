package com.Alpha.Space.Shooter;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;



    public class BatwingRed extends Ship {


        private Rectangle hull = new Rectangle();
        private Rectangle wings = new Rectangle();
        private Ammo ammo1;
        private Ammo ammo2;
        private Ammo ammo3;
        private Ammo ammo4;

        private String imageFileName = "sprite/batWingShip/batwingRed.png";
        private String deathSoundFile = "Sounds/SoundEffects/Futuristic Explosion.wav";

        public BatwingRed(double windowWidth, double windowHeight, Ammo ammo1_2, Ammo ammo3_4) {


            hull.setX(58);
            hull.setY(0);
            hull.setWidth(30);
            hull.setHeight(100);
            hull.setFill(Color.TRANSPARENT);

            wings.setX(-1);
            wings.setY(hull.getY());
            wings.setWidth(150);
            wings.setHeight(20);
            wings.setFill(Color.TRANSPARENT);

            ImageView image = SpriteTool.getImage(imageFileName, wings.getX(),hull.getY(),150.0, 150.0, false);


            this.ammo1 = ammo1_2;
            this.ammo2 = ammo1_2;
            this.ammo3 = ammo3_4;
            this.ammo4 = ammo3_4;
//            ammo2.setRoundLocation(-200, -200);
//            ammo2.setRoundLocation(-200, -200);


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
            ammoList.add(ammo1.getRound());
            ammoList.add(ammo2.getRound());
            ammoList.add(ammo3.getRound());
            ammoList.add(ammo4.getRound());
            ammoList.add(ammo1.getHitExplosionSprite());
            ammoList.add(ammo2.getHitExplosionSprite());
            ammoList.add(ammo3.getHitExplosionSprite());
            ammoList.add(ammo4.getHitExplosionSprite());
            return ammoList;
        }
        @Override
        public void setShot(EnemyArray enemy, Score score)
        {
            ammo1.setRoundLocation(wings.getParent().getLayoutX() + 0, wings.getParent().getLayoutY());
            ammo1.invokeShipShot(enemy, score);
            ammo2.setRoundLocation(wings.getParent().getLayoutX() + 150, wings.getParent().getLayoutY());
            ammo2.invokeShipShot(enemy, score);
            ammo3.setRoundLocation(wings.getParent().getLayoutX() + 50, wings.getParent().getLayoutY());
            ammo3.invokeShipShot(enemy, score);
            ammo4.setRoundLocation(wings.getParent().getLayoutX() + 100, wings.getParent().getLayoutY());
            ammo4.invokeShipShot(enemy, score);
        }




    }


