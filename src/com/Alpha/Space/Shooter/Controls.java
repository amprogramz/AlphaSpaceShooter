package com.Alpha.Space.Shooter;
/**
 * Author Alec McDaugale & David McEwen
 * This is a class to define the controls in the game
 */

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Controls {
    private static boolean keyboard = true;
    EventHandler<KeyEvent> keyboardControls;
    EventHandler<MouseEvent> mouseMoved;
    EventHandler<MouseEvent> mousePressed;
    EventHandler<MouseEvent> mouseDragged;
    EventHandler<MouseEvent> mouseReleased;
    boolean upPress, downPress, rightPress, leftPress, spacePress, vPress, qPress, mousePress;
    int charge;

    /**
     * This is where the controls are defined.
     *
     * @param scene  The scene to add the controls to.
     * @param ship   The ship object is necessary to use its methods to move it.
     * @param enemy  Passing the enemy objects allows us to to detect collisions when we invoke shoot.
     */
    public Controls(Scene scene, UserShip ship, EnemyArray enemy, Score score) {
//        going to the keyboard controls by default.
    	//Checks inputs 50 times a second
    	//charge is to limit how fast you can shoot
    	//also implements auto-shooting by holding the button down
    	Timeline timeline = new Timeline(new KeyFrame(
    			Duration.millis(20),
    			ae -> {
    				if(rightPress){ship.moveRight();}
    				if(leftPress){ship.moveLeft();}
    				if(upPress){ship.moveUp();}
    				if(downPress){ship.moveDown();}
    				if(spacePress & charge >= 20){ship.setShot(enemy, score); charge = 0;}
    				if(mousePress & charge >= 20){ship.setShot(enemy, score); charge = 0;}
    				if(vPress){enemy.startShooting(ship, score);}
    				//if(qPress){checkControlMode(scene, ship, enemy, score, width, height);}
    				charge++;
    			}
    	));
    	timeline.setCycleCount(Animation.INDEFINITE);
    	timeline.play();
        keyboardControls(scene, ship, enemy, score);
    }
    public void checkControlMode(Scene scene, UserShip ship, EnemyArray enemy, Score score)
    {
        keyboard = !keyboard;
        //selects mode
        if (keyboard)
        {
        	scene.removeEventHandler(MouseEvent.MOUSE_MOVED, mouseMoved);
            scene.removeEventHandler(MouseEvent.MOUSE_DRAGGED, mouseDragged);
            scene.removeEventHandler(MouseEvent.MOUSE_PRESSED, mousePressed);
            scene.removeEventHandler(MouseEvent.MOUSE_RELEASED, mouseReleased);
            //scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyboardControls);
            scene.setCursor(Cursor.DEFAULT);
            keyboardControls(scene, ship, enemy, score);

        }else
        {
        	//scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyboardControls);
            mouseControls(scene, ship, enemy, score);
        }
    }
    public void keyboardControls(Scene scene, UserShip ship, EnemyArray enemy, Score score)
    {
    	scene.setOnKeyPressed(key -> {
    		if(key.getCode() == KeyCode.UP){
    			upPress = true;
    		}
    		if(key.getCode() == KeyCode.DOWN){
    			downPress = true;
    		}
    		if(key.getCode() == KeyCode.RIGHT){
    			rightPress = true;
    		}
    		if(key.getCode() == KeyCode.LEFT){
    			leftPress = true;
    		}
    		if(key.getCode() == KeyCode.SPACE){
    			spacePress = true;
    		}
    		if(key.getCode() == KeyCode.V){
    			vPress = true;
    		}
    		/*if(key.getCode() == KeyCode.Q){
    			qPress = true;
    		}*/
    	});
    	
    	scene.setOnKeyReleased(key ->{
    		if(key.getCode() == KeyCode.UP){
    			upPress = false;
    		}
    		if(key.getCode() == KeyCode.DOWN){
    			downPress = false;
    		}
    		if(key.getCode() == KeyCode.RIGHT){
    			rightPress = false;
    		}
    		if(key.getCode() == KeyCode.LEFT){
    			leftPress = false;
    		}
    		if(key.getCode() == KeyCode.SPACE){
    			spacePress = false;
    		}
    		if(key.getCode() == KeyCode.V){
    			vPress = false;
    		}
    		if(key.getCode() == KeyCode.Q){
    			checkControlMode(scene, ship, enemy, score);
    			qPress = true;
    		}
    	});

    }

    public void mouseControls(Scene scene, UserShip ship, EnemyArray enemy, Score score)
    {
        mouseMoved = new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent){
                ship.moveShip(mouseEvent.getSceneX() - 50, mouseEvent.getSceneY() - 100);
            }
        };

        mouseDragged = new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent){
                ship.moveShip(mouseEvent.getSceneX() - 50, mouseEvent.getSceneY() - 100);
            }
        };

        mousePressed = new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent){
            	mousePress = true;
                //ship.setShot(enemy, score);
            }
        };
        
        mouseReleased = new EventHandler<MouseEvent>(){
        	
        	@Override
        	public void handle(MouseEvent mouseEvent){
        		mousePress = false;
        	}
        };
        /*
        keyboardControls = new EventHandler<KeyEvent>(){
        	
        	public void handle(KeyEvent key){
        		if(key.getCode() == KeyCode.Q){
        			checkControlMode(scene, ship, enemy, score, width, height);
        		}
        	}
        };
		*/
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, mouseMoved);
        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseDragged);
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, mousePressed);
        scene.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseReleased);
        //scene.addEventHandler(KeyEvent.KEY_PRESSED, keyboardControls);
        }
	//sets keyboard to true or false in settings menu
    public static EventHandler<ActionEvent> setKeyBoard(boolean b) 
	{
		keyboard = b;
		return null;
	};
        
    }
