package com.Alpha.Space.Shooter;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ShotGun extends Ammo
{
    private String shotSoundFile = "Sounds/SoundEffects/Futuristic Shotgun Single Shot.wav";
    private Ammo ammo = new Pelet(0);
    private Ammo ammo2 = new Pelet(-10);
    private Ammo ammo3 = new Pelet(10);

    public ShotGun()
    {


        super.setRound(ammo);
        super.setRound(ammo2);
        super.setRound(ammo3);

        super.setMovement(15);
        super.setDamage(10);
        super.setShotSound(SoundTool.getAudioClip(shotSoundFile));
    }

    //this is where we can get creative with our movements for the ammo
    public void shipShoot(EnemyArray enemy, Score score)
    {

        ammo.shipShoot(enemy, score);
        ammo2.shipShoot(enemy, score);
        ammo3.shipShoot(enemy, score);
    }
    public void enemyShoot(Ship ship, Score score)
    {
        getRound().setLayoutY(getRound().getLayoutY() + getMovement());
        shipColishionCheck(ship, score);
    }

}
