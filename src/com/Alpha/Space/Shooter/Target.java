package com.Alpha.Space.Shooter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.lang.Math;
import java.util.ArrayList;

/**
 * Author Alec McDaugle
 * This is a child class of Enemy. It is now a borg cube like ship.
 */
public class Target extends Enemy
{

    Ammo ammo = new FiftyCaliber();
    Rectangle target = new Rectangle();

    String deathSoundFile = "Sounds/SoundEffects/Small Futuristic Explosion.mp3";
    public Target(double x, double y, int index)
    {

        target.setLayoutX(0);
        target.setLayoutY(0);
        target.setWidth(45);
        target.setHeight(45);
        target.setFill(Color.GRAY);
        super.setEnemy(target);

        target.getParent().setLayoutX(x);
        target.getParent().setLayoutY(y);

        super.setTargetIndex(index);
        super.setHitPoints(30);

        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
    }

    @Override
    public void setShot(Ship ship, Score score)
    {
        ammo.setRoundLocation(target.getParent().getLayoutX() + 18, target.getParent().getLayoutY());
        ammo.invokeEnemyShot(ship, score);
    }

    @Override
    public ArrayList<Group> getAmmo()
    {
        ArrayList<Group> ammoList = new ArrayList<>();
        ammoList.add(ammo.getRound());

        return ammoList;
    }

    boolean directionX = true;
    @Override
    public void move(double screenWidth, double screenHeight, Ship ship, Score score)
    {
        //boolean directionX;
        if (target.getParent().getLayoutX() < screenWidth
                && directionX == true
                && !Colideable.collision(ship.getShipObj(), getEnemy()))
        {
            moveRight(Math.random()*6);
            moveDown(Math.random()*2);
        }
        else if (target.getParent().getLayoutX() >= screenWidth
                || Colideable.collision(ship.getShipObj(), getEnemy())
                && target.getParent().getLayoutX() <= ship.getX())
        {
            directionX = false;
            moveLeft(Math.random()*6);
            moveDown(Math.random()*2);
        }
        else if (target.getParent().getLayoutX() > 0
                && directionX == false
                && !Colideable.collision(ship.getShipObj(), getEnemy()))
        {

            moveLeft(5);
            moveDown(1);
        }else if (target.getParent().getLayoutX() <= 0
                || Colideable.collision(ship.getShipObj(), getEnemy())
                && target.getParent().getLayoutX() >= ship.getX())
        {
            directionX = true;
            moveRight(5);
            moveDown(1);
        }

        if (target.getParent().getLayoutY() >= screenHeight)
        {
            moveUp(screenHeight + Math.random()*200);
        }

        if (target.getParent().getLayoutX() > 0 && target.getParent().getLayoutX() < screenWidth && target.getParent().getLayoutY() > 0) {
            int shootRandom = (int) (Math.random() * 50);

//        System.out.println(shootRandom); //test random
            if (shootRandom == 3) {
                setShot(ship, score);
            }
        }

    }
}
