package com.Alpha.Space.Shooter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class ShotGun extends Ammo
{
    private String shotSoundFile = "Sounds/SoundEffects/Futuristic Shotgun Single Shot.wav";
    private Ammo ammo = new Pelet(0.0);
    private Ammo ammo2 = new Pelet(-10.0);
    private Ammo ammo3 = new Pelet(10.0);

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

    @Override
    public void setRoundLocation(double x, double y)
    {
        ammo.setRoundLocation(x,y);
        ammo2.setRoundLocation(x,y);
        ammo3.setRoundLocation(x,y);

    }
    public void enemyShoot(Ship ship, Score score)
    {
        getRound().setLayoutY(getRound().getLayoutY() + getMovement());
        shipColishionCheck(ship, score);
    }

    @Override
    public Group getHitExplosionSprite()
    {
        Group explosion = new Group();
        explosion.getChildren().addAll(ammo.getHitExplosionSprite());
        explosion.getChildren().addAll(ammo2.getHitExplosionSprite());
        explosion.getChildren().addAll(ammo3.getHitExplosionSprite());

        return explosion;
    }

}
