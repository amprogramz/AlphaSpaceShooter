package com.Alpha.Space.Shooter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SpaceShooter extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    //  let me know if this does not fit on your screen for whatever reason.
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    private Ship ship = new Ship(WINDOW_WIDTH, WINDOW_HEIGHT);
    private EnemyArray enemies = new EnemyArray(8);

    @Override
    public void start(Stage primaryStage)
    {
        Group gameGroup = new Group();
        ObservableList gameList = gameGroup.getChildren();
        gameList.addAll(ship.getShip());
        gameList.addAll(enemies.getEnemies());

        Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
        Controls controls = new Controls(scene, ship, enemies, WINDOW_WIDTH, WINDOW_HEIGHT);


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


}
