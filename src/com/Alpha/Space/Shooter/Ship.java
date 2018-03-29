package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * The Ship class is an abstract parent class to create a ship. I made it abstract, but im trying to make this work for
 * a variety of shapes.
 */

import javafx.collections.ObservableList;
import javafx.scene.Group;


public abstract class Ship
{
    private double movement;
    private double hitPoints;

    private Group ship = new Group();
    private ObservableList shipParts = ship.getChildren();

    public Group getShip()
    {
        return ship;
    }
    public void addShipParts(Object shipPart)
    {
        shipParts.add(shipPart);
    }
    public void addShipParts(ObservableList shipParts)
    {
        this.shipParts.addAll(shipParts);
    }


    public void moveShipRight()
    {
        ship.setAutoSizeChildren(true);
        ship.setLayoutX(ship.getLayoutX() + movement);
    }
    public  void moveShipLeft()
    {
        ship.setLayoutX(ship.getLayoutX() - movement);
    }
    public void moveShipUp()
    {
        ship.setLayoutY(ship.getLayoutY() - movement);
    }
    public void moveShipDown()
    {
        ship.setLayoutY(ship.getLayoutY() + movement);
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
        return ship.getLayoutX();
    }
    public double getY()
    {
        return ship.getLayoutY();
    }
    public double getWidth()
    {
        return 0;
    }
    public double getHeight()
    {
        return 0;
    }

    public abstract void setShot(EnemyArray enemy);





}
