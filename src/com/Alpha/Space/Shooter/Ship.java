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

    private void setShip(double width, double height)
    {
        ship.setLayoutX(width / 2); //center x
        ship.setLayoutY((height / 4) * 3); //bottom quadrant y
    }
    public Group getShip(double width, double height)
    {
        setShip(width, height);
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
    public void removeShipParts(Object shipPart)
    {
        shipParts.remove(shipPart);
    }


    public void move(int x,int y){
    	ship.setAutoSizeChildren(true);
    	ship.setLayoutX(x);
    	ship.setLayoutY(y);
    }

    public void moveShipRight()
    {
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
        return ship.getLayoutBounds().getWidth();
    }
    public double getHeight()
    {
        return ship.getLayoutBounds().getHeight();
    }

    public abstract void setShot(EnemyArray enemy);





}
