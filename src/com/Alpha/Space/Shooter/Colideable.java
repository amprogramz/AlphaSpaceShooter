package com.Alpha.Space.Shooter;


import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * Author Alec McDaugale
 * This is a class which contains static methods which detect collisions between two objects, and return true if a
 * collision has been detected.
 */
public class Colideable
{
    /**
     * A static method which accepts two shapes and checks them for a collision.
     * @param amo Accepts shape 1.
     * @param ship Accepts shape 2.
     * @return True if Shapes collide.
     */
    public static boolean collision(Shape amo, Shape ship)
    {
        if(amo.intersects(ship.getLayoutBounds()))
        {
            return true;
        }
        return false;
    }
    /**
     * A static method which checks for collisions between a shape and an array of shapes, and returns true if a
     * collision occurs.
     * @param amo Accepts shape 1.
     * @param ship Accepts an ArrayList of shapes.
     * @return True if Shapes collide.
     */
    public static boolean collision(Shape amo, ArrayList<Shape> ships)
    {

        for(int index = 0; index < ships.size(); index++)
        {
            if (amo.intersects(ships.get(index).getLayoutBounds()))
            {
                return true;
            }
        }

        return false;
    }
}
