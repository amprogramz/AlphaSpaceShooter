package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * The Ship class is an abstract parent class to create a ship. I made it abstract, but im trying to make this work for
 * a variety of shapes.
 */

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;


public abstract class Ship
{
    private double movement;
    private double hitPoints;

    private Group ship = new Group();
    private ObservableList shipParts = ship.getChildren();

    /**
     * This is a way to default the ship to the bottom center of the scene. This works regaurdless of where the ship was
     * designed.
     * @param width The screen width.
     * @param height The screen height.
     */
    private void defaultShip(double width, double height)
    {
        ship.setLayoutX(width / 2); //center x
        ship.setLayoutY((height / 4) * 3); //bottom quadrant y
    }

    /**
     * This returns the Group object that holds all of our ship parts together. You would return this to the scene group.
     * @param width The screen width.
     * @param height The screen height.
     * @return The ship node.
     */
    public Group getShip(double width, double height)
    {
        defaultShip(width, height);
        return ship;
    }

    /**
     * A way to add a node to the ship group.
     * @param shipPart The part to add.
     */
    public void addShipParts(Node shipPart)
    {
        shipParts.add(shipPart);
    }

    /**
     * A way to add an ObservableList of parts to the ship.
     * @param shipParts The list of parts to add.
     */
    public void addShipParts(ObservableList shipParts)
    {
        this.shipParts.addAll(shipParts);
    }

    /**
     * A way to remove a part from the ship. Maybe we will decide to destroy parts of the ship.
     * @param shipPart The part to remove.
     */
    public void removeShipParts(Node shipPart)
    {
        shipParts.remove(shipPart);
    }

    /**
     * A way to move the ship to a precise location.
     * @param x Value of X to move to.
     * @param y Value of Y to move to.
     */
    public void move(double x,double y){
    	ship.setAutoSizeChildren(true);
    	ship.setLayoutX(x);
    	ship.setLayoutY(y);
    }

    /**
     * Moves ship group right.
     */
    public void moveShipRight()
    {
        ship.setLayoutX(ship.getLayoutX() + movement);
    }

    /**
     * Moves ship group left.
     */
    public  void moveShipLeft()
    {
        ship.setLayoutX(ship.getLayoutX() - movement);
    }

    /**
     * Moves ship group up.
     */
    public void moveShipUp()
    {
        ship.setLayoutY(ship.getLayoutY() - movement);
    }

    /**
     * Moves ship group down.
     */
    public void moveShipDown()
    {
        ship.setLayoutY(ship.getLayoutY() + movement);
    }


    /**
     * Sets the value of movement. This can be thought of as the speed.
     * @param movement A value to represent the movement.
     */
    public void setMovement(int movement)
    {
        this.movement = movement;
    }

    /**
     * Returns the movement.
     * @return Vlue of movement.
     */
    public double getMovement()
    {
        return movement;
    }

    /**
     * Sets the value for the health of the ship.
     * @param hitPoints How much health.
     */
    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }

    /**
     * Returns the hotpoint's left on the ship.
     * @return Health of ship.
     */
    public double getHitPoints()
    {
        return hitPoints;
    }

    /**
     * The top left corner x value.
     * @return
     */
    public double getX()
    {
        return ship.getLayoutX();
    }

    /**
     * The top left corner Y value.
     * @return Value of X.
     */
    public double getY()
    {
        return ship.getLayoutY();
    }

    /**
     * Returns the Y of the Group.
     * @return Value of Y.
     */
    public double getWidth()
    {
        return ship.getLayoutBounds().getWidth();
    }

    /**
     * Returns the width of the Group.
     * @return Value of width.
     */
    public double getHeight()
    {
        return ship.getLayoutBounds().getHeight();
    }

    /**
     * Abstract method to set the shot to an origin.
     * @param enemy Enemy 0bject to check for collisions.     */
    public abstract void setShot(EnemyArray enemy, Score score);

    /**
     * Abstract method to reurnthe ammo.
     * @return A Group containing the ammo.
     */
    public abstract ArrayList<Group> getAmmo();






}
