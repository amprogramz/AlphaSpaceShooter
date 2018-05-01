package com.Alpha.Space.Shooter;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BatwingRed extends Ship {
	
	
	private Rectangle hull = new Rectangle();
	private Rectangle wings = new Rectangle();
	private Ammo ammo1 = new FiftyCaliber();
	private Ammo ammo2 = new FiftyCaliber();
	private Ammo ammo3 = new Phaser();
	private Ammo ammo4 = new Phaser();
	
	private String imageFileName = "sprite/batWingShip/batwingRed.png";
	private String deathSoundFile = "Sounds/SoundEffects/Futuristic Explosion.wav";
	
	public BatwingRed(double windowWidth, double windowHeight) {
		 
		
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

         ammo2.setRoundLocation(-200, -200);
         ammo2.setRoundLocation(-200, -200);


         super.addShipParts(hull);
         super.addShipParts(wings);
         super.addShipParts(image);

         super.setMovement(15);
         super.setHitPoints(100);
         super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));

	}
	   @Override
       public ArrayList<Group> getAmmo()
       {
           ArrayList<Group> ammoList = new ArrayList<>();
           ammoList.add(ammo1.getRound());
           ammoList.add(ammo2.getRound());
           ammoList.add(ammo3.getRound());
           ammoList.add(ammo4.getRound());
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
