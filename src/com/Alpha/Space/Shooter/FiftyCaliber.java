package com.Alpha.Space.Shooter;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Author Alec McDaugale
 * This is a class which is derived from ammo.
 */
public class FiftyCaliber extends Ammo
{

    private String shotSoundFile = "Sounds/Sound Effects/Futuristic Shotgun Single Shot.wav";

    public FiftyCaliber()
    {
        Rectangle ammo = new Rectangle();
        ammo.setWidth(2);
        ammo.setHeight(10);
        ammo.setFill(Color.RED);
        super.setRound(ammo);
        super.setMovement(15);
        super.setDamage(10);
        super.setShotSound(SoundTool.getAudioClip(shotSoundFile));
    }

    //this is where we can get creative with our movements for the ammo
    public void shipShoot(EnemyArray enemy, Score score)
    {
    //    getRound().setLayoutX(getRound().getLayoutX() + getMovement());
        getRound().setLayoutY(getRound().getLayoutY() - getMovement());
        enemyColishionCheck(enemy, score);
    }
    public void enemyShoot(Ship ship, Score score)
    {
        getRound().setLayoutY(getRound().getLayoutY() + getMovement());
        shipColishionCheck(ship, score);
    }


}
