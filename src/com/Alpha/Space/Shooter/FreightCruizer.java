package com.Alpha.Space.Shooter;


import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class FreightCruizer extends Ship
{



        public FreightCruizer(double windowWidth, double windowHeight)
        {
            Rectangle hull = new Rectangle();
            hull.setX(windowWidth/2);
            hull.setY(windowHeight/4);
            hull.setWidth(50);
            hull.setHeight(150);
            super.setHull(hull);

            Rectangle wings = new Rectangle();
            wings.setX((hull.getX() + (hull.getWidth()/2) - 50));
            wings.setY((hull.getY() + hull.getHeight()) - 50);
            wings.setWidth(100);
            wings.setHeight(50);
            super.setWings(wings);
            super.setMovement(15);

        }
        @Override
        public ArrayList<Rectangle> getShip()
        {
            ArrayList<Rectangle> ship = new ArrayList<>();
            ship.add(super.getHull());
            ship.add(super.getWings());
            ship.add(super.getAmmo());
            return ship;
        }


}
