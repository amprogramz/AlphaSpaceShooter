package com.Alpha.Space.Shooter;

import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

public class Phaser extends Ammo{
	
	private String imageFileName = "Sprite/straightYellow.png";
	private String shotSound = "Sounds/SoundEffects/Laser Shot.wav";
	private ImageView image = SpriteTool.getImage(imageFileName);
	
	
	public Phaser() {
		
		
		
		super.setRound(image);
		super.setMovement(18.8);
		super.setDamage(20);
		super.setShotSound(SoundTool.getAudioClip(shotSound));
	}

	@Override
	public void shipShoot(EnemyArray enemy, Score score) {
        getRound().setLayoutY(getRound().getLayoutY() - getMovement());
        enemyColishionCheck(enemy, score);
		
	}

	@Override
	public void enemyShoot(Ship ship, Score score) {
		getRound().setLayoutY(getRound().getLayoutY() + getMovement());
        shipColishionCheck(ship, score);
		
	}

}
