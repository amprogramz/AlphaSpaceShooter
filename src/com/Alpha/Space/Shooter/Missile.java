package com.Alpha.Space.Shooter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Missile extends Ammo
{
    private String shotSoundFile = "Sounds/SoundEffects/Futuristic Shotgun Single Shot.wav";
    private Rectangle ammo = new Rectangle();

    public Missile()
    {

        ammo.setWidth(10);
        ammo.setHeight(22);
        ammo.setFill(Color.RED);
        super.setRound(ammo);

        super.setMovement(15);
        super.setDamage(50);
        super.setShotSound(SoundTool.getAudioClip(shotSoundFile));
    }

    private int index = 0;

    public void shipShoot(EnemyArray enemy, Score score)
    {

        if(index < 15)
        {
            ammo.getParent().setLayoutX(ammo.getParent().getLayoutX() + 2);
            index++;
        }
        else
        {
            ammo.getParent().setLayoutY(ammo.getParent().getLayoutY() - getMovement());
        }
        enemyColishionCheck(enemy, score);
    }
    @Override
    public void invokeShipShot(EnemyArray enemy, Score score)
    {
        index = 0;

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10),
                ae ->  shipShoot(enemy, score) ));


        timeline.setCycleCount(70);
        timeline.play();

        super.getShotSound().play();

    }
    public void enemyShoot(Ship ship, Score score)
    {
        getRound().setLayoutY(getRound().getLayoutY() + getMovement());
        shipColishionCheck(ship, score);
    }

}
