package com.Alpha.Space.Shooter;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Colideable
{
    public static boolean collishion(Rectangle amo, Rectangle ship)
    {
        if(amo.intersects(ship.getLayoutBounds()))
        {
            return true;
        }
        return false;
    }

    public static boolean collishion(Rectangle amo, ArrayList<Rectangle> ships)
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
