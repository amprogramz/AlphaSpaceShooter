package com.Alpha.Space.Shooter;
/**
 * Author: Alec McDaugale
 * This is a class to define a flying saucer which extends Enemy.
 */

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import java.util.ArrayList;

public class Saucer extends Enemy
{
    Ammo ammo = new FiftyCaliber();
    Circle saucer = new Circle();

    String deathSoundFile = "Sounds/SoundEffects/Small Futuristic Explosion.mp3";
    public Saucer(double x, double y, int index)
    {

        saucer.setLayoutX(0);
        saucer.setLayoutY(0);
        saucer.setRadius(20);

        saucer.setFill(Color.GRAY);
        super.setEnemy(saucer);

        saucer.getParent().setLayoutX(x);
        saucer.getParent().setLayoutY(y);

        super.setTargetIndex(index);
        super.setHitPoints(40);

        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
    }

    @Override
    public void setShot(Ship ship, Score score)
    {
        ammo.setRoundLocation(saucer.getParent().getLayoutX(), saucer.getParent().getLayoutY());
        ammo.invokeEnemyShot(ship, score);
    }

    @Override
    public ArrayList<Group> getAmmo()
    {
        ArrayList<Group> ammoList = new ArrayList<>();
        ammoList.add(ammo.getRound());

        return ammoList;
    }

    boolean isDirectionX = true;
    boolean isDirectionY = true;
    boolean completeCircle = true;
    double radius;
    double initialX;
    double initialY;
    double radiusX;
    double radiusY;
    int dex;
    boolean temp = true;
    @Override
    public void move(double screenWidth, double screenHeight, Ship ship, Score score)
    {
        if (temp)
        {
            moveDown(200);
            moveRight(300);
            temp = false;
        }
        if (completeCircle)
        {

            radius = 50;//Math.random()* 50;
            initialX = saucer.getParent().getLayoutX();
            initialY = saucer.getParent().getLayoutY();
            radiusX = initialX + radius;
            radiusY = initialY;
            completeCircle = false;
        }else

        if (!completeCircle)
        {
//            dex++;
//            saucer.getParent().setLayoutX(radiusX + (Math.cos(initialX) * radius));
//            saucer.getParent().setLayoutY(radiusY + (Math.sin(initialY) * radius));
//            System.out.println((dex));
//            initialX++;
//            initialY++;

//            1st quad
            if (isDirectionX == true
                    && isDirectionY == true)
            {
                moveRight(1);
                moveDown(1);

                if (saucer.getParent().getLayoutX() == initialX + radius
                        && saucer.getParent().getLayoutY() == initialY + radius)
                {
                    isDirectionX = false;
                    isDirectionY = true;
                }
            }else
//            2nd quad
            if (isDirectionX == false
                    && isDirectionY == true)
            {
                moveLeft(1);
                moveDown(1);

                if (saucer.getParent().getLayoutX() == initialX
                        && saucer.getParent().getLayoutY() == initialY + (radius * 2))
                {
                    isDirectionX = false;
                    isDirectionY = false;
                }
            }else
//            3rd quad
            if (isDirectionX == false
                && isDirectionY == false)
            {
                moveLeft(1);
                moveUp(1);

                if (saucer.getParent().getLayoutX() == initialX -radius
                        && saucer.getParent().getLayoutY() == initialY + radius)
                {
                    isDirectionX = true;
                    isDirectionY = false;
                }
            }else
//            4th quad
            if (isDirectionX == true
                    && isDirectionY == false)
            {
                moveRight(1);
                moveUp(1);

                if (saucer.getParent().getLayoutX() == initialX
                        && saucer.getParent().getLayoutY() == initialY)
                {
                    isDirectionX = true;
                    isDirectionY = true;
                }
                //completeCircle = true;

            }

        }

//        if (saucer.getParent().getLayoutX() < screenWidth
//                && isDirectionX == true
//                && isDirectionY == true
//                && !Colideable.collision(ship.getShipObj(), getEnemy()))
//        {
//
//            moveRight(.1);
//            moveDown((radiusY + Math.sqrt(radius - Math.pow((.1-radiusX), 2))) - saucer.getParent().getLayoutX());
//            if (saucer.getParent().getLayoutX() == initialX + radius)
//            {
//                isDirectionX = false;
//            }
//        }
//        else if (saucer.getParent().getLayoutX() >= screenWidth
//                || Colideable.collision(ship.getShipObj(), getEnemy())
//                && saucer.getParent().getLayoutX() <= ship.getX())
//        {
//            isDirectionX = false;
//            moveLeft(1);
//            moveDown(1);
//        }
//        else if (saucer.getParent().getLayoutX() > 0
//                && isDirectionX == false
//                && !Colideable.collision(ship.getShipObj(), getEnemy()))
//        {
//
//            moveLeft(.1);
//            moveDown(radiusY - Math.sqrt(radius - Math.pow((.1-radiusX), 2)));
//        }else if (saucer.getParent().getLayoutX() <= 0
//                || Colideable.collision(ship.getShipObj(), getEnemy())
//                && saucer.getParent().getLayoutX() >= ship.getX())
//        {
//            isDirectionX = true;
//            moveRight(1);
//           // moveUp((radiusY + Math.sqrt(radius - Math.pow((.1-radiusX), 2)))- saucer.getParent().getLayoutY() );
//        }


        if (saucer.getParent().getLayoutY() == screenHeight)
        {
            moveUp(screenHeight + 100);
        }

        if (saucer.getParent().getLayoutX() > 0 && saucer.getParent().getLayoutX() < screenWidth && saucer.getParent().getLayoutY() > 0) {
            int shootRandom = (int) (Math.random() * 100);


            if (shootRandom == 3) {
                setShot(ship, score);
            }
        }

        System.out.println("x " + saucer.getParent().getLayoutX() + " Y " +saucer.getParent().getLayoutY());

    }
}
