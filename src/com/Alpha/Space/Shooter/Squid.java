package com.Alpha.Space.Shooter;
/**
 * Author: Alec McDaugale
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

    private String imageFileName = "Sprite/SpaceShooter1/PNG/SpritesX2/Ships/spaceShips_006.png";
    
    String deathSoundFile = "Sounds/SoundEffects/Small Futuristic Explosion.mp3";
    public Squid(double x, double y, int index)
    {

        saucer.setLayoutX(0);
        saucer.setLayoutY(0);
        saucer.setRadius(25);

        super.setEnemy(saucer);

        saucer.getParent().setLayoutX(x);
        saucer.getParent().setLayoutY(y);

        Image image = SpriteTool.getImage(imageFileName, saucer.getCenterX(), saucer.getCenterY(), 20, 20, false).getImage();
        saucer.setFill(new ImagePattern(image));
        
        super.setTargetIndex(index);
        super.setHitPoints(40);
        super.setMovement(1);

        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
    }

    @Override
    public void setShot(Ship ship, Score score)
    {
        ammo.setRoundLocation(saucer.getParent().getLayoutX(), saucer.getParent().getLayoutY());
        ammo.invokeEnemyShot(ship, score);
    }

    @Override
    public ArrayList<Node> getAmmo()
    {
        ArrayList<Node> ammoList = new ArrayList<>();
        ammoList.add(ammo.getRound());
        ammoList.add(ammo.getHitExplosionSprite());

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
    double currentX;
    double currentY;
    double lastX;
    double lastY;
    int index = 0;
    int randomMoves;
    boolean temp = true;
    @Override
    public void move(double screenWidth, double screenHeight, Ship ship, Score score)
    {

        if (completeCircle)
        {
            if (index < randomMoves)
            {
                if (isDirectionX == true
                        && saucer.getParent().getLayoutX() <= screenWidth
                        && !Colideable.collision(ship.getShipObj(), getEnemy()))
                {
                    moveDown(getMovement());
                    moveRight(getMovement());

                }else if (saucer.getParent().getLayoutX() >= screenWidth
                    || Colideable.collision(ship.getShipObj(), getEnemy())
                     && saucer.getParent().getLayoutX() <= ship.getX())
                {
                     isDirectionX = false;
                     moveLeft(getMovement());
                     moveDown(getMovement());
                }
                else if (saucer.getParent().getLayoutX() > 0
                    && isDirectionX == false
                    && !Colideable.collision(ship.getShipObj(), getEnemy()))
                {

                    moveLeft(getMovement());
                    moveDown(getMovement());
                }else if (saucer.getParent().getLayoutX() <= 0
                    || Colideable.collision(ship.getShipObj(), getEnemy())
                    && saucer.getParent().getLayoutX() >= ship.getX())
                {
                    isDirectionX = true;
                    moveRight(getMovement());
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
            moveUp(screenHeight + 100);
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
