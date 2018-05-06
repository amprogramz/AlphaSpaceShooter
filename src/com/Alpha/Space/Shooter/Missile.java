package com.Alpha.Space.Shooter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Missile extends Ammo
{
    private String shotSoundFile = "Sounds/SoundEffects/Futuristic Shotgun Single Shot.wav";
    private ImageView ammo = SpriteTool.getImage("Sprite/spaceMissiles_005small.png");
    
    public Missile()
    {

       
        super.setRound(ammo);

        super.setMovement(15);
        super.setDamage(50);
        super.setShotSound(SoundTool.getAudioClip(shotSoundFile));
    }

    private int index = 0;

    public void shipShoot(SpaceObject spaceObject, Score score)
    {

        if(index < 15)
        {
            ammo.getParent().setLayoutX(ammo.getParent().getLayoutX() + 2);
            index++;
        }
        else
        {
            ammo.getParent().setLayoutY(ammo.getParent().getLayoutY() + getMovement());
        }
        ColishionCheck(spaceObject, score);
    }
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
        ColishionCheck(enemy, score);
    }
//    @Override
//    public void invokeShot(SpaceObject ship, Score score)
//    {
//        index = 0;
//
//        Timeline timeline = new Timeline(new KeyFrame(
//                Duration.millis(10),
//                ae ->  shipShoot(ship, score) ));
//
//
//        timeline.setCycleCount(70);
//        timeline.play();
//
//        super.getShotSound().play();
//
//    }
//    public void enemyShoot(Ship ship, Score score)
//    {
//        getRound().setLayoutY(getRound().getLayoutY() + getMovement());
//        shipColishionCheck(ship, score);
//    }

}
