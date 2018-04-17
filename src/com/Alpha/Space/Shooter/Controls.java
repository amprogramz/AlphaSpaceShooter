package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale
 * This is a class to define the controles in the game
 */

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.awt.MouseInfo;
import java.security.Key;

public class Controls {
    boolean keyboard = true;
    EventHandler<KeyEvent> keyboardControls;
    EventHandler<MouseEvent> mouseMoved;
    EventHandler<MouseEvent> mousePressed;
    EventHandler<MouseEvent> mouseDragged;

    /**
     * This is where the controls are defined.
     *
     * @param scene  The scene to add the controls to.
     * @param ship   The ship object is necessary to use its methods to move it.
     * @param enemy  Passing the enemy objects allows us to to detect collisions when we invoke shoot.
     * @param width  This is the screen width of the game.
     * @param height This is the screen height of the game.
     */
    public Controls(Scene scene, Ship ship, EnemyArray enemy, Score score, double width, double height) {
//        going to the keyboard controls by default.
        keyboardControls(scene, ship, enemy, score, width, height);
    }
    public void checkControlMode(Scene scene, Ship ship, EnemyArray enemy, Score score, double width, double height)
    {
        keyboard = !keyboard;
        //selects mode
        if (keyboard)
        {
        	scene.removeEventHandler(MouseEvent.MOUSE_MOVED, mouseMoved);
            scene.removeEventHandler(MouseEvent.MOUSE_DRAGGED, mouseDragged);
            scene.removeEventHandler(MouseEvent.MOUSE_PRESSED, mousePressed);
            scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyboardControls);
            //scene.removeEventHandler(mouseControls(scene, ship, enemy, width, height));
            scene.setCursor(Cursor.DEFAULT);
            keyboardControls(scene, ship, enemy, score, width, height);

        }else
        {
        	scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyboardControls);
            mouseControls(scene, ship, enemy, score, width, height);
        }
    }
    public void keyboardControls(Scene scene, Ship ship, EnemyArray enemy, Score score, double width, double height)
    {
        //scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        keyboardControls = new EventHandler<KeyEvent>() 
        {
        	@Override
        	public void handle(KeyEvent key){
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
                    ship.setShot(enemy, score);
                    break;
                case V:
                    //for(int index = 0; index < enemy.getEnemies().size(); index++)
                    enemy.startShooting(ship, score);

                    break;
                case Q:
                    checkControlMode(scene, ship, enemy, score, width, height);

                    break;
            }}
        };
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyboardControls);
        //checkControlMode(scene, ship, enemy, width, height);
    }

    public void mouseControls(Scene scene, Ship ship, EnemyArray enemy, Score score, double width, double height)
    {
        mouseMoved = new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent){
            	//scene.setCursor(Cursor.NONE);
                //ship.move(MouseInfo.getPointerInfo().getLocation().x - 510, MouseInfo.getPointerInfo().getLocation().y - 200 );
                ship.move(mouseEvent.getSceneX() - 50, mouseEvent.getSceneY() - 100);
            }
        };

        mouseDragged = new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent){
            	//scene.setCursor(Cursor.NONE);
                //ship.move(MouseInfo.getPointerInfo().getLocation().x - 510, MouseInfo.getPointerInfo().getLocation().y - 200 );
                ship.move(mouseEvent.getSceneX() - 50, mouseEvent.getSceneY() - 100);
            }
        };

        mousePressed = new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent){
                ship.setShot(enemy, score);
            }
        };
        
        keyboardControls = new EventHandler<KeyEvent>(){
        	
        	public void handle(KeyEvent key){
        		if(key.getCode() == key.getCode().Q){
        			checkControlMode(scene, ship, enemy, score, width, height);
        		}
        	}
        };
		
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, mouseMoved);
        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseDragged);
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, mousePressed);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyboardControls);
        };
    }
