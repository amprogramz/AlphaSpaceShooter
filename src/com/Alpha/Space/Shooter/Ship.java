package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * The Ship class is an abstract parent class to create an enemyShip or a userShip. This decision was due to the fact
 * that all of the ships have ammo.
 */
import javafx.scene.Node;
import java.util.ArrayList;


public abstract class Ship extends SpaceObject
{
    /**
     * Abstract method to return the ammo.
     * @return A Group containing the ammo.
     */
    public abstract ArrayList<Node> getAmmo();
}
