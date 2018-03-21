package com.Alpha.Space.Shooter;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Controls {
    public Controls (Scene scene, Ship ship, int width, int height)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {

            switch (key.getCode()) {
                case UP:
                    if (ship.getY() > 0)
                    {
                        ship.moveShipUp();
                    }
                    break;
                case DOWN:
                    if (ship.getY() < height - ship.getHeight())
                    {
                        ship.moveShipDown();
                    }
                    break;
                case RIGHT:
                    if (ship.getX() < (width - ship.getWidth()))
                    {
                        ship.moveShipRight();
                    }
                    break;
                case LEFT:
                    if (ship.getX() > 0)
                    {
                        ship.moveShipLeft();
                    }
                    break;
                case SPACE:
                    ship.shoot();
                    break;
            }
        });
    }
}
