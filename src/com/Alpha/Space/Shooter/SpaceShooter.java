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
    private String background1 = "sprite/Space-Background-1.jpg";
    private String background2 = "sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg";

    private Background background = new Background(background2, WINDOW_WIDTH, WINDOW_HEIGHT);
    private Ship ship = new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT);
    private EnemyArray enemies = new EnemyArray(8);
    //Enemy enemy = new Target(500, 50, 1);
    private Score score = new Score(5);

    @Override
    public void start(Stage primaryStage)
    {
        //groups can contain groups
        Group gameGroup = new Group();
        ObservableList gameList = gameGroup.getChildren();
        gameList.add(background.getBackground());
        gameList.addAll(ship.getShip(WINDOW_WIDTH, WINDOW_HEIGHT));
        gameList.addAll(ship.getAmmo());
        gameList.addAll(enemies.getEnemies());
        gameList.addAll(enemies.getAllAmmo());

////        for(int index = 0; index < enemies.getAllAmmo().size(); index++)
//        {
//            gameList.addAll(enemies.getAllAmmo().get(index));
//        }
//        gameList.addAll(enemies.getAllAmmo());
        gameList.addAll(score.getScoreLivesOut());

        //enemies.startShooting(ship, score);


        Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
        Controls controls = new Controls(scene, ship, enemies, score, WINDOW_WIDTH, WINDOW_HEIGHT);
        //Controls controls = new Controls(scene, ship, enemy, score, WINDOW_WIDTH, WINDOW_HEIGHT);


        primaryStage.setTitle("Space Shooter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}