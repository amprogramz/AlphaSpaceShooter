package com.Alpha.Space.Shooter;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.media.AudioClip;

public abstract class SpaceObject
{
    private double movement;

    double screenWidth;
    double screenHeight;

    private double hitPoints;
    int index;
    public int getIndex()
    {
        return index;
    }
    public void setIndex(int index)
    {
        this.index = index;
    }

    private AudioClip movingSound;
    private AudioClip hitSound;
    private AudioClip deathSound;
    private Group spaceObject = new Group();
    private ObservableList<Node> parts = spaceObject.getChildren();

    public Group getObj()
    {
        return spaceObject;
    }
    public void addParts(Node shipPart)
    {
        parts.add(shipPart);
    }
    public void addParts(ObservableList<Node> shipParts)
    {
        this.parts.addAll(shipParts);
    }
    public void removeParts(Node Part)
    {
        parts.remove(Part);
    }

    public void setDefaultObjectLocation(double x, double y)
    {
        spaceObject.setLayoutX(x);
        spaceObject.setLayoutY(y);
    }
    public void setDeathSound(AudioClip deathSound) {
        this.deathSound = deathSound;
    }
    public AudioClip getDeathSound(){return deathSound;}

    public void setMovingSound(AudioClip shipMovingSound)
    {
        this.movingSound = shipMovingSound;
    }
    public void setHitSound(AudioClip shipHitSound)
    {
        this.hitSound = shipHitSound;
    }
    public void setMovement(int movement)
    {
        this.movement = movement;
    }
    public double getMovement()
    {
        return movement;
    }
    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }
    public double getHitPoints()
    {
        return hitPoints;
    }
    public double getX()
    {
        return spaceObject.getLayoutX();
    }
    public double getY()
    {
        return spaceObject.getLayoutY();
    }
    public double getWidth()
    {
        return spaceObject.getLayoutBounds().getWidth();
    }
    public double getHeight()
    {
        return spaceObject.getLayoutBounds().getHeight();
    }

   public void setScreenWidth(double screenWidth)
   {
       this.screenWidth = screenWidth;
   }
   public void setScreenHeight(double screenHeight)
   {
       this.screenHeight = screenHeight;
   }

    public double getScreenWidth()
    {
        return screenWidth;
    }
    public double getScreenHeight()
    {
        return screenHeight;
    }

    /**
     * A way to move the ship to a precise location.
     * @param x Value of X to move to.
     * @param y Value of Y to move to.
     */
    public void move(double x,double y){
        spaceObject.setAutoSizeChildren(true);
        spaceObject.setLayoutX(x);
        spaceObject.setLayoutY(y);

    }

    /**
     * Moves group right.
     */
    public void moveRight()
    {
        if(spaceObject.getLayoutX() < screenWidth - this.getWidth())
        {
            spaceObject.setLayoutX(spaceObject.getLayoutX() + movement);
           // movingSound.play();
        }
    }
    public void moveRight(double movement)
    {

            spaceObject.setLayoutX(spaceObject.getLayoutX() + movement);
            // movingSound.play();

    }

    /**
     * Moves group left.
     */
    public void moveLeft()
    {
        if (spaceObject.getLayoutX() > 0)
        {
            spaceObject.setLayoutX(spaceObject.getLayoutX() - movement);
            //movingSound.play();
        }
    }
    public void moveLeft(double movement)
    {

            spaceObject.setLayoutX(spaceObject.getLayoutX() - movement);
            //movingSound.play();

    }

    /**
     * Moves group up.
     */
    public void moveUp()
    {
        if(spaceObject.getLayoutY() > 0)
        {
            spaceObject.setLayoutY(spaceObject.getLayoutY() - movement);
            //movingSound.play();
        }
    }
    public void moveUp(double movement)
    {

            spaceObject.setLayoutY(spaceObject.getLayoutY() - movement);
            //movingSound.play();
    }

    /**
     * Moves group down.
     */
    public void moveDown()
    {
        if (spaceObject.getLayoutY() < screenHeight - this.getHeight())
        {
            spaceObject.setLayoutY(spaceObject.getLayoutY() + movement);
           // movingSound.play();
        }
    }
    public void moveDown(double movement)
    {
            spaceObject.setLayoutY(spaceObject.getLayoutY() + movement);
            // movingSound.play();
    }

    public boolean checkForDestruction(Group ammo, int damage, Score score)
    {

        if(Colideable.collision(ammo, spaceObject))
        {
            System.out.println("hit.");
            Destruct(damage, score);
            return true;
        }

        return false;

    }

    public abstract void Destruct(int damage, Score score);


}
