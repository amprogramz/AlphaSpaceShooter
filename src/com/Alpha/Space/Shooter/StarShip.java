package com.Alpha.Space.Shooter;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class StarShip extends UserShip
{
	private Rectangle hull = new Rectangle();
    private Rectangle wings = new Rectangle();
    private Ammo ammo;
    private Ammo ammo2;

    private String movingSoundFile = "Sounds/SoundEffects/shipEngine4.wav";
    private String imageFileName = "Sprite/cartoonshipPurple.png";
    private String deathSoundFile = "Sounds/SoundEffects/Futuristic Explosion.wav";
	public StarShip(double windowWidth, double windowHeight, Ammo ammo1, Ammo ammo2)
	{
		hull.setX(37.5);
        hull.setY(0);
        hull.setWidth(25);
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

        super.addParts(hull);
        super.addParts(wings);
        super.addParts(image);

        super.setMovement(30);
        super.setHitPoints(50);
        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
        super.setMovingSound(SoundTool.getAudioClip(movingSoundFile));

        super.setScreenWidth(windowWidth);
        super.setScreenHeight(windowHeight);

        super.setDefault();
	}
    
    @Override
	public void setShot(EnemyArray enemy, Score score)
    {
    	 ammo.setRoundLocation(wings.getParent().getLayoutX() + 21, wings.getParent().getLayoutY());
         ammo.invokeShot(enemy, score);
         ammo2.setRoundLocation(wings.getParent().getLayoutX() + 78, wings.getParent().getLayoutY());
         ammo2.invokeShot(enemy, score);
		
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

}
