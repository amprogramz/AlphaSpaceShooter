package com.Alpha.Space.Shooter;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Phaser extends Ammo{
	
	private String shotSound = "Sounds/SoundEffects/Laser Shot.wav";
	
	public Phaser() {
		Rectangle ammo = new Rectangle();
		ammo.setWidth(5);
		ammo.setHeight(40);
		ammo.setFill(Color.CORNFLOWERBLUE);
		super.setRound(ammo);
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
