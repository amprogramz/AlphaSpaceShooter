package com.Alpha.Space.Shooter;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameObject
{
//    Stage menu;
//
//    final int WINDOW_WIDTH = 1000;
//    final int WINDOW_HEIGHT = 800;
//
//    UserShip ship;
//   // Background background;
//    SpaceObject obj = new Asteroid(300, 25, 1);
//    EnemyArray enemies;
//    Score score;
//    public GameObject(int difficulty, UserShip ship, )
//    {
//        this.ship = ship;
//       // this.background =
//        enemies = new EnemyArray(WINDOW_WIDTH, WINDOW_HEIGHT, difficulty * 2);
//        score = new Score(5, ship.getHitPoints(), WINDOW_WIDTH, WINDOW_HEIGHT);
//    }
//    /**
//     * Scene for the game user will play
//     * @return created scene
//     */
//    public Scene spaceShooter()
//    {
//
//        MediaPlayer soundTrack = SoundTool.getMediaPlayer("Sounds/Songs/Tentacle Wedding.mp3");
//
//        Group gameGroup = new Group();
//        ObservableList gameList = gameGroup.getChildren();
//        gameList.add(background.getBackground());
//        gameList.addAll(ship.getObj());
//        gameList.addAll(ship.getAmmo());
//        gameList.addAll(enemies.getEnemies());
//        gameList.addAll(enemies.getAllAmmo());
//        gameList.addAll(score.getScoreLivesOut());
//        //gameList.addAll((ship.getKeepPlaying(score )));
//        gameList.add(obj.getObj());
//
//        Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
//        Controls controls = new Controls(scene, ship, enemies, score);
//
//        soundTrack.play();
//        enemies.animateMovement(WINDOW_WIDTH, WINDOW_HEIGHT, ship, score);
//
//        background.moveForward();
//
//        return scene;
//    }
}
