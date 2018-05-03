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
    private Ammo ammo;
   
  
  
    private String imageFileName = "sprite/batWingShip/batwingRed.png";
    private String deathSoundFile = "Sounds/SoundEffects/Futuristic Explosion.wav";
    
    public BatwingGreen(double windowWidth, double windowHeight, Ammo ammo1, Ammo ammo2)
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

        ammo = ammo1;
        
      

        ammo.setRoundLocation(-200, -200);
        
      
       

        super.addShipParts(hull);
        super.addShipParts(wings);
        super.addShipParts(image);

        super.setMovement(30);
        super.setHitPoints(100);
        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
    }
	@Override
	public void setShot(EnemyArray enemy, Score score) 
	{
		 ammo.setRoundLocation(wings.getParent().getLayoutX() + 75, wings.getParent().getLayoutY());
         ammo.invokeShipShot(enemy, score); 
	}

	@Override
	public ArrayList<Node> getAmmo() 
	{
		ArrayList<Node> ammoList = new ArrayList<>();
        ammoList.add(ammo.getRound());
        ammoList.add(ammo.getHitExplosionSprite());
        return ammoList;
	}

}
