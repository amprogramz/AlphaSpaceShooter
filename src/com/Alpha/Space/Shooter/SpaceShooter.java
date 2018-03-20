package com.Alpha.Space.Shooter;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SpaceShooter extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    //  let me know if this does not fit on your screen for whatever reason.
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    private Ship ship = new Ship(WINDOW_WIDTH, WINDOW_HEIGHT);

    @Override
    public void start(Stage primaryStage)
    {
        Group gameGroup = new Group();
        ObservableList gameList = gameGroup.getChildren();
        gameList.addAll(ship.getShip());

        Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
        controls(scene, ship, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setTitle("Space Shooter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public int getWINDOW_WIDTH()
    {
        return WINDOW_WIDTH;
    }
    public int getWINDOW_HEIGHT()
    {
        return WINDOW_HEIGHT;
    }

    public void controls (Scene scene, Ship ship, int width, int height)
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
                   git  break;
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
