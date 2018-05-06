package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * The Ship class is an abstract parent class to create a ship. I made it abstract, but im trying to make this work for
 * a variety of shapes.
 */

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.media.AudioClip;




import java.util.ArrayList;


public abstract class Ship extends SpaceObject
{



    /**
     * Abstract method to reurnthe ammo.
     * @return A Group containing the ammo.
     */
    public abstract ArrayList<Node> getAmmo();




}
