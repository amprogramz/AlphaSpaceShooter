package com.Alpha.Space.Shooter;

/**
 * Author Alec McDaugale
 * This is the JavaFX Aplication area where we define the windows for the game.
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SpaceShooter extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    //  let me know if this does not fit on your screen for whatever reason.
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private String filePath = "sprite/Space-Background-1.jpg";

    private Ship ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT);
    private EnemyArray enemies = new EnemyArray(8);
    private Score score = new Score(5);

    @Override
    public void start(Stage primaryStage)
    {
        //groups can contain groups
        Group gameGroup = new Group();
        ObservableList gameList = gameGroup.getChildren();
        gameList.add(SpriteTool.getImage(filePath, WINDOW_WIDTH, WINDOW_HEIGHT));
        gameList.addAll(ship.getShip(WINDOW_WIDTH, WINDOW_HEIGHT));
        gameList.add(ship.getAmmo());
        gameList.addAll(enemies.getEnemies());
        gameList.addAll(score.getScoreLivesOut());


        Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
        Controls controls = new Controls(scene, ship, enemies, WINDOW_WIDTH, WINDOW_HEIGHT);


        primaryStage.setTitle("Space Shooter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
