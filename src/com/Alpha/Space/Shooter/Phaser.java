package com.Alpha.Space.Shooter;


import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Phaser extends Ammo{
	
	
	 private String shotSound = "Sounds/SoundEffects/Laser Shot.wav";
	 private ImageView image = SpriteTool.getImage("Sprite/bulbYellow.png");
	 
	
	public Phaser() {
		
		
		
		super.setRound(image);
		super.setMovement(17.8);
		super.setDamage(20);
		super.setShotSound(SoundTool.getAudioClip(shotSound));
	}

	@Override
	public void shipShoot(EnemyArray enemy, Score score) {
        getRound().setLayoutY(getRound().getLayoutY() - getMovement());
        ColishionCheck(enemy, score);
		
	}
	@Override
	public void shipShoot(SpaceObject enemy, Score score) {
		getRound().setLayoutY(getRound().getLayoutY() + getMovement());
		ColishionCheck(enemy, score);

	}
//	@Override
//	public void enemyShoot(Ship ship, Score score) {
//		getRound().setLayoutY(getRound().getLayoutY() + getMovement());
//        shipColishionCheck(ship, score);
//
//	}

}
