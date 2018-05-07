package com.Alpha.Space.Shooter;
/**
 * Author: Alec McDaugale
 * Sprites: quinn
 * This is a class to define a flying saucer which extends Enemy.
 */

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.image.ImageView;


import java.util.ArrayList;

public class Squid extends Enemy
{
    Ammo ammo = new FiftyCaliber();
    Circle saucer = new Circle();

    private String imageFileName = "Sprite/Squid.png";
    
    String deathSoundFile = "Sounds/SoundEffects/Small Futuristic Explosion.mp3";
    public Squid(double screenWidth, double screenHeight, double x, double y, int index)
    {

        saucer.setLayoutX(0);
        saucer.setLayoutY(0);
        saucer.setRadius(25);

        super.addParts(saucer);

        saucer.getParent().setLayoutX(x);
        saucer.getParent().setLayoutY(y);

        Image image = SpriteTool.getImage(imageFileName, saucer.getCenterX(), saucer.getCenterY(), 20, 20, false).getImage();
        saucer.setFill(new ImagePattern(image));
        
        super.setIndex(index);
        super.setHitPoints(40);

        super.setMovement(1);

        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));

        super.setScreenWidth(screenWidth);
        super.setScreenHeight(screenHeight);
    }

    @Override
    public void setShot(SpaceObject ship, Score score)
    {
        ammo.setRoundLocation(saucer.getParent().getLayoutX(), saucer.getParent().getLayoutY());
        ammo.invokeShot(ship, score);
    }

    @Override
    public ArrayList<Node> getAmmo()
    {
        ArrayList<Node> ammoList = new ArrayList<>();
        ammoList.add(ammo.getRound());
        ammoList.add(ammo.getHitExplosionSprite());

        return ammoList;
    }

    private boolean isDirectionX = true;
    private boolean isDirectionY = true;
    private boolean completeCircle = true;
    private double radius;
    private double initialX;
    private double initialY;

    private int index = 0;
    private int randomMoves;


    @Override
    public void move(double screenWidth, double screenHeight, UserShip ship, Score score)
    {

        if (completeCircle)
        {
            if (index < randomMoves)
            {
                if (isDirectionX == true
                        && saucer.getParent().getLayoutX() <= screenWidth
                        && !Colideable.collision(ship.getObj(), getObj()))
                {
                    moveDown(1);
                    moveRight(1);

                }else if (saucer.getParent().getLayoutX() >= screenWidth
                    || Colideable.collision(ship.getObj(), getObj())
                     && saucer.getParent().getLayoutX() <= ship.getX())
                {
                     isDirectionX = false;
                     moveLeft(1);
                     moveDown(1);
                }
                else if (saucer.getParent().getLayoutX() > 0
                    && isDirectionX == false
                    && !Colideable.collision(ship.getObj(), getObj()))
                {

                    moveLeft(1);
                    moveDown(1);
                }else if (saucer.getParent().getLayoutX() <= 0
                    || Colideable.collision(ship.getObj(), getObj())
                    && saucer.getParent().getLayoutX() >= ship.getX())
                {
                    isDirectionX = true;
                    moveRight(1);
                }

                index++;

            } else if (randomMoves == 0)
            {
                randomMoves = (int)(Math.random() * 300);
            }else
            {
                completeCircle = false;
                radius = (int)(Math.random() * 200);
                System.out.println(radius);
                initialX = saucer.getParent().getLayoutX();
                initialY = saucer.getParent().getLayoutY();
                randomMoves = 0;
                index = 0;
            }
        }else if (!completeCircle)
        {
            if (saucer.getParent().getLayoutX() < 0
                    || saucer.getParent().getLayoutX() > screenWidth
                    || saucer.getParent().getLayoutY() < 0)
            {
                completeCircle = true;
            }
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
                    completeCircle = true;
                }


            }

        }


        if (saucer.getParent().getLayoutY() == screenHeight)
        {
            //super.setDefaultObjectLocation(0, super.getScreenHeight() + 100);
            super.moveUp(screenHeight + 100);
        }

        if (saucer.getParent().getLayoutX() > 0 && saucer.getParent().getLayoutX() < screenWidth && saucer.getParent().getLayoutY() > 0) {
            int shootRandom = (int) (Math.random() * 100);


            if (shootRandom == 3) {
                setShot(ship, score);
            }
        }

        //System.out.println("x " + saucer.getParent().getLayoutX() + " Y " +saucer.getParent().getLayoutY());

    }

}
