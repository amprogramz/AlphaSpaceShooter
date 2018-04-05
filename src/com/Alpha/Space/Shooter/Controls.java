package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * This is a class to define the controles in the game
 */

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.awt.MouseInfo;

public class Controls {
    boolean keyboard = true;


    /**
     * This is where the controls are defined.
     *
     * @param scene  The scene to add the controls to.
     * @param ship   The ship object is necessary to use its methods to move it.
     * @param enemy  Passing the enemy objects allows us to to detect collisions when we invoke shoot.
     * @param width  This is the screen width of the game.
     * @param height This is the screen height of the game.
     */
    public Controls(Scene scene, Ship ship, EnemyArray enemy, double width, double height) {
//        going to the keyboard controls by default.
        keyboardControls(scene, ship, enemy, width, height);
    }
    public void checkControlMode(Scene scene, Ship ship, EnemyArray enemy, double width, double height)
    {
        keyboard = !keyboard;
        //selects mode
        if (keyboard)
        {
            keyboardControls(scene, ship, enemy, width, height);

        }else
        {
            mouseControls(scene, ship, enemy, width, height);
        }
    }
    public void keyboardControls(Scene scene, Ship ship, EnemyArray enemy, double width, double height)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {

            switch (key.getCode()) {
                case UP:
                    if (ship.getY() > 0) {
                        ship.moveShipUp();

                    }
                    break;
                case DOWN:
                    if (ship.getY() < height - ship.getHeight()) {
                        ship.moveShipDown();
                    }
                    break;
                case RIGHT:
                    if (ship.getX() < (width - ship.getWidth())) {
                        ship.moveShipRight();
                    }
                    break;
                case LEFT:
                    if (ship.getX() > 0) {
                        ship.moveShipLeft();

                    }
                    break;
                case SPACE:
                    ship.setShot(enemy);

                    break;
                case Q:
                    checkControlMode(scene, ship, enemy, width, height);
                    break;

            }
        });
        //checkControlMode(scene, ship, enemy, width, height);
    }

    public void mouseControls(Scene scene, Ship ship, EnemyArray enemy, double width, double height)
    {
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>(){

            //@Override
            public void handle(MouseEvent mouseEvent){
                ship.move(MouseInfo.getPointerInfo().getLocation().x - 984, MouseInfo.getPointerInfo().getLocation().y - 800 );
            }
        });

        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){

            //@Override
            public void handle(MouseEvent mouseEvent){
                ship.move(MouseInfo.getPointerInfo().getLocation().x - 984, MouseInfo.getPointerInfo().getLocation().y - 800 );
            }
        });

        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){

            //@Override
            public void handle(MouseEvent mouseEvent){
                ship.setShot(enemy);
            }
        });

    }


   /* public void caseUp(Scene scene, Ship ship) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {

            switch (key.getCode()) {
                case UP:
                    if (ship.getY() > 0) {
                        ship.moveShipUp();

                    }
                    break;


            }
        });


    }

    public void caseleft(Scene scene, Ship ship) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {

            switch (key.getCode()) {
                case LEFT:
                    if (ship.getY() > 0) {
                        ship.moveShipLeft();

                    }
                    break;


            }
        });


    }
*/
}
