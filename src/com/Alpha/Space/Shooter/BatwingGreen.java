package com.Alpha.Space.Shooter;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BatwingGreen extends Ship
{
	private Rectangle hull = new Rectangle();
    private Rectangle wings = new Rectangle();
    private Ammo ammo1;
    private Ammo ammo2;
    private Ammo ammo3;
    private Ammo ammo4;
   
  
    private String movingSoundFile = "Sounds/SoundEffects/shipEngine2.wav";
    private String imageFileName = "Sprite/batWingShip/batwingGreen.png";
    private String deathSoundFile = "Sounds/SoundEffects/Futuristic Explosion.wav";
    
    public BatwingGreen(double windowWidth, double windowHeight, Ammo ammo1, Ammo ammo2, Ammo ammo3, Ammo ammo4)
    {
    	   
    	
    	   hull.setX(58);
           hull.setY(0);
           hull.setWidth(30);
           hull.setHeight(100);
           hull.setFill(Color.TRANSPARENT);

           wings.setX(0);
           wings.setY(hull.getY());
           wings.setWidth(150);
           wings.setHeight(20);
           wings.setFill(Color.TRANSPARENT);
       
        ImageView image = SpriteTool.getImage(imageFileName, wings.getX(),hull.getY(),wings.getWidth(), hull.getHeight(), false);

        this.ammo1 = ammo1;
        this.ammo2 = ammo2;

        this.ammo3 = ammo3;
        this.ammo4 = ammo4;

        super.addShipParts(hull);
        super.addShipParts(wings);
        super.addShipParts(image);

        super.setMovement(30);
        super.setHitPoints(100);
        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
        super.setShipMovingSound(SoundTool.getAudioClip(movingSoundFile));
    }
	@Override
	public void setShot(EnemyArray enemy, Score score) 
	{
        ammo1.setRoundLocation(wings.getParent().getLayoutX() + 3, wings.getParent().getLayoutY());
        ammo1.invokeShipShot(enemy, score);
        ammo2.setRoundLocation(wings.getParent().getLayoutX() + 147, wings.getParent().getLayoutY());
        ammo2.invokeShipShot(enemy, score);
        ammo3.setRoundLocation(wings.getParent().getLayoutX() + 50, wings.getParent().getLayoutY());
        ammo3.invokeShipShot(enemy, score);
        ammo4.setRoundLocation(wings.getParent().getLayoutX() + 100, wings.getParent().getLayoutY());
        ammo4.invokeShipShot(enemy, score);
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

}

