package com.Alpha.Space.Shooter;


import javafx.scene.paint.Paint;
import javafx.scene.image.ImageView;

public class Pelet extends Ammo
{
    private String shotSoundFile = "Sounds/SoundEffects/Futuristic Shotgun Single Shot.wav";
   
    private ImageView ammo = SpriteTool.getImage("Sprite/ballBlue.png");
    Double xMovement;


    public Pelet(Double xMovement)
    {

        
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
