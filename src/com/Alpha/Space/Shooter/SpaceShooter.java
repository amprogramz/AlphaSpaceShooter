package com.Alpha.Space.Shooter;

import javax.swing.Timer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

/**
 * Author Alec McDaugale
 * This is the JavaFX Aplication area where we define the windows for the game.
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.MediaPlayer;


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

    private Background background = new Background(background2, 3000, 2400);
    private UserShip ship = new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, new Missile(), new Missile(), new Missile(), new Missile());
    private EnemyArray enemies = new EnemyArray(WINDOW_WIDTH, WINDOW_HEIGHT, 4 );


    private Score score = new Score(5, ship.getHitPoints(), WINDOW_WIDTH, WINDOW_HEIGHT);



    //private Score score = new Score(5);
    private MediaPlayer soundTrack = SoundTool.getMediaPlayer("Sounds/Songs/Tentacle Wedding.mp3");

    @Override
    public void start(Stage primaryStage)
    {
        //groups can contain groups
        Group gameGroup = new Group();
        ObservableList gameList = gameGroup.getChildren();
        gameList.add(background.getBackground());
        gameList.addAll(ship.getObj());
        gameList.addAll(ship.getAmmo());
        gameList.addAll(enemies.getEnemies());
        gameList.addAll(enemies.getAllAmmo());

        //gameList.addAll((ship.getKeepPlaying(score)));
       // gameList.addAll();


        gameList.addAll(score.getScoreLivesOut());




        Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
        Controls controls = new Controls(scene, ship, enemies, score);



        primaryStage.setTitle("Space Shooter");
        primaryStage.setScene(scene);
        primaryStage.show();
        soundTrack.play();


        enemies.animateMovement(WINDOW_WIDTH, WINDOW_HEIGHT, ship, score);

        background.moveForward();

    }


}