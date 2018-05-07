package com.Alpha.Space.Shooter;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import java.lang.Math;
import java.util.ArrayList;

/**
 * Author: Alec McDaugle
 * Sprites: quinn
 * This is a child class of Enemy. It is now a borg cube like ship.
 */
public class Target extends Enemy
{

    Ammo ammo = new FiftyCaliber();
    Rectangle target = new Rectangle();

    private String imageFileName = "Sprite/SpaceShooter1/PNG/SpritesX2/Ships/spaceShips_006.png";
    String deathSoundFile = "Sounds/SoundEffects/Small Futuristic Explosion.mp3";
    public Target(double screenWidth, double screenHeight, double x, double y, int index)
    {

        target.setLayoutX(0);
        target.setLayoutY(0);
        target.setWidth(45);
        target.setHeight(45);
        target.setFill(Color.GRAY);
        super.addParts(target);

        target.getParent().setLayoutX(x);
        target.getParent().setLayoutY(y);
        
        Image image = SpriteTool.getImage(imageFileName, target.getX(), target.getY(), target.getWidth(), target.getHeight(), false).getImage();
        target.setFill(new ImagePattern(image));
        
        super.setIndex(index);
        super.setHitPoints(30);
        
        super.setDeathSound(SoundTool.getAudioClip(deathSoundFile));
        super.setScreenWidth(screenWidth);
        super.setScreenHeight(screenHeight);
    }

    @Override
    public void setShot(SpaceObject ship, Score score)
    {
        ammo.setRoundLocation(target.getParent().getLayoutX() + 18, target.getParent().getLayoutY());
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

    private boolean directionX = true;

    @Override
    public void move(double screenWidth, double screenHeight, UserShip ship, Score score)
    {
        //boolean directionX;
        if (target.getParent().getLayoutX() < screenWidth
                && directionX == true
                && !Colideable.collision(ship.getObj(), super.getObj()) )
        {
            moveRight(Math.random()*6);
            moveDown(Math.random()*2);
        }
        else if (target.getParent().getLayoutX() >= screenWidth
                || Colideable.collision(ship.getObj(), super.getObj())
                && target.getParent().getLayoutX() <= ship.getX())
        {
            directionX = false;
            moveLeft(Math.random()*6);
            moveDown(Math.random()*2);
        }
        else if (target.getParent().getLayoutX() > 0
                && directionX == false
                && !Colideable.collision(ship.getObj(), super.getObj()))
        {

            moveLeft(5);
            moveDown(1);
        }else if (target.getParent().getLayoutX() <= 0
                || Colideable.collision(ship.getObj(), super.getObj())
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
            int shootRandom = (int) (Math.random() * 100);

//        System.out.println(shootRandom); //test random
            if (shootRandom == 3) {
                setShot(ship, score);
            }
        }

    }
}
