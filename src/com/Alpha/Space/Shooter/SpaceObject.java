package com.Alpha.Space.Shooter;

/**
 * Alec McDaugale
 * This class is now the parent class of all of the space objects.
 */

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.media.AudioClip;

public abstract class SpaceObject
{

    private double screenWidth;
    private double screenHeight;
    private double movement;
    private double hitPoints;
    private double currentHitPoints;
    private int index;
    private AudioClip movingSound;
    private AudioClip hitSound;
    private AudioClip deathSound;
    private Group spaceObject = new Group();
    private ObservableList<Node> parts = spaceObject.getChildren();

    /**
     * Method to return the group object.
     * @return Group object.
     */
    public Group getObj()
    {
        return spaceObject;
    }

    /**
     * Add a part to the group object.
     * @param part A single Node to add to the group object.
     */
    public void addParts(Node part)
    {
        parts.add(part);
    }
    /**
     * Add parts to the group object.
     * @param parts An ObservableList of type Node to add to the group object.
     */
    public void addParts(ObservableList<Node> parts)
    {
        this.parts.addAll(parts);
    }

    /**
     * Remove a part from the group object.
     * @param part The part to remove.
     */
    public void removeParts(Node part)
    {
        parts.remove(part);
    }

    /**
     * Set the group object to a default location.
     * @param x The x coordinate to set the object to.
     * @param y The y coordinate to set the object to.
     */
    public void setDefaultObjectLocation(double x, double y)
    {
        spaceObject.setLayoutX(x);
        spaceObject.setLayoutY(y);
    }

    /**
     * Set the death sound.
     * @param deathSound The Audio clip to set as the death sound.
     */
    public void setDeathSound(AudioClip deathSound) {
        this.deathSound = deathSound;
    }

    /**
     * Get the death sound.
     * @return the AudioClip deathSound.
     */
    public AudioClip getDeathSound(){return deathSound;}

    /**
     * Set the moving sound.
     * @param shipMovingSound The Audio clip to set as the moving sound.
     */
    public void setMovingSound(AudioClip shipMovingSound)
    {
        this.movingSound = shipMovingSound;
    }

    /**
     * Get the ship hit sound.
     * @param shipHitSound The AudioClip ShipHitSound.
     */
    public void setHitSound(AudioClip shipHitSound)
    {
        this.hitSound = shipHitSound;
    }

    /**
     * Sets the value for movement. This value adjusts how fast the object moves.
     * @param movement Double value to set the movement to.
     */
    public void setMovement(double movement)
    {
        this.movement = movement;
    }

    /**
     * Get the movement to use elsewhere.
     * @return Get the double movement.
     */
    public double getMovement()
    {
        return movement;
    }

    /**
     * Set the value of hit points for the object. This can be used to calculate the life of an object against.
     * @param hitPoints int value to set to hit points.
     */
    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }

    /**
     * Get the hit points of the object.
     * @return the int value of hit points.
     */
    public double getHitPoints()
    {
        return hitPoints;
    }

    /**
     * reset the value of the current hit points to the value of hit points.
     */
    public void resetCurrentHitPoints()
    {
        currentHitPoints = hitPoints;
    }

    /**
     * Deduct defined amount from health.
     * @param damage double value to subtract from the current health.
     */
    public void deductCurrentHitPoints(double damage)
    {
        currentHitPoints = currentHitPoints - damage;
    }
    public double getCurrentHitPoints()
    {
        return getCurrentHitPoints();
    }

    /**
     *Get the x value of the object.
     * @return the double x value of the group object.
     */
    public double getX()
    {
        return spaceObject.getLayoutX();
    }

    /**
     * Get the y value of the object.
     * @return the double y value of the group object.
     */
    public double getY()
    {
        return spaceObject.getLayoutY();
    }

    /**
     * Get the width value of the object.
     * @return the double width value of the group object.
     */
    public double getWidth()
    {
        return spaceObject.getLayoutBounds().getWidth();
    }

    /**
     * Get the height value of the object.
     * @return the double height value of the group object.
     */
    public double getHeight()
    {
        return spaceObject.getLayoutBounds().getHeight();
    }

    /**
     * Get the index value of the object.
     * @return the int index value of the group object.
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * Set the index value of the group object.
     * @param index the int value to use for this objects index.
     */
    public void setIndex(int index)
    {
        this.index = index;
    }

    /**
     * Set the value for the width of the screen.
     * @param screenWidth double value of the screen width.
     */
    public void setScreenWidth(double screenWidth)
   {
       this.screenWidth = screenWidth;
   }

    /**
     * Set the value for the height of the screen.
     * @param screenHeight double value of the screen width.
     */
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
    public void moveShip(double x,double y){
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

    /**
     * Moves group right by custom value of movement.
     * @param movement double value to use as the movement value.
     */
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

    /**
     * Moves group left by custom value of movement.
     * @param movement double value to use as the movement value.
     */
    public void moveLeft(double movement)
    {

            spaceObject.setLayoutX(spaceObject.getLayoutX() - movement);
            //movingSound.play();

    }

    /**
     * Moves the group up.
     */
    public void moveUp()
    {
        if(spaceObject.getLayoutY() > 0)
        {
            spaceObject.setLayoutY(spaceObject.getLayoutY() - movement);
            //movingSound.play();
        }
    }

    /**
     * Moves group up by custom value of movement.
     * @param movement double value to use as the movement value.
     */
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

    /**
     * Moves group down by custom value of movement.
     * @param movement double value to use as the movement value.
     */
    public void moveDown(double movement)
    {
            spaceObject.setLayoutY(spaceObject.getLayoutY() + movement);
            // movingSound.play();
    }

    /**
     * method to check for destruction from the ammo.
     * @param ammo round to check for collision.
     * @param damage The amount of damage to be dealt by the given round.
     * @param score The score object to keep score.
     * @return Returns true when collision occurs.
     */
    public boolean checkForDestruction(Group ammo, int damage, Score score)
    {

        if(Colideable.collision(ammo, spaceObject))
        {
            System.out.println("hit.");
            destruct(damage, score);
            return true;
        }

        return false;

    }

    //Abstract method to destruct the object.
    public abstract void destruct(int damage, Score score);


}
