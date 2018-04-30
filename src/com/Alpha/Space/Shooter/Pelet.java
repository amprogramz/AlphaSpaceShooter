package com.Alpha.Space.Shooter;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pelet extends Ammo
{
    private String shotSoundFile = "Sounds/SoundEffects/Futuristic Shotgun Single Shot.wav";
    private Rectangle ammo = new Rectangle();
    int xMovement;


    public Pelet(int xMovement)
    {

        ammo.setWidth(5);
        ammo.setHeight(10);
        ammo.setFill(Color.BLUE);
        super.setRound(ammo);

        this.xMovement = xMovement;



        super.setMovement(15);
        super.setDamage(10);
        super.setShotSound(SoundTool.getAudioClip(shotSoundFile));
    }

    //this is where we can get creative with our movements for the ammo
    public void shipShoot(EnemyArray enemy, Score score)
    {

        ammo.getParent().setLayoutY(ammo.getParent().getLayoutY() - getMovement());
        ammo.getParent().setLayoutX(ammo.getParent().getLayoutX() + xMovement);

        enemyColishionCheck(enemy, score);
    }
    public void enemyShoot(Ship ship, Score score)
    {
        getRound().setLayoutY(getRound().getLayoutY() + getMovement());
        shipColishionCheck(ship, score);
    }

}
