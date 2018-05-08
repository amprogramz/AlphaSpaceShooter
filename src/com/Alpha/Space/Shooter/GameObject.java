package com.Alpha.Space.Shooter;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class GameObject
{
    final int WINDOW_WIDTH = 1000;
    final int WINDOW_HEIGHT = 800;

    UserShip ship;
    String shipFilepathArray[] = {
            "Sprite/Spaceship_tut/Spaceship_tut.png",
            "Sprite/batWingShip/batwingGreen.png",
            "Sprite/Titan.png",
            "Sprite/cartoonshipPurple.png"
    };
    Background background;
    String backgroundFileArray[] = {
            "Sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg",
            "Sprite/Space-Background-2.jpg",
            "Sprite/Space-Background-3.jpg",
            "Sprite/Space-Background-4.jpg"
    };

    EnemyArray enemies;
    Score score;

    public GameObject(int dificulty,
                      int backgroundSelection,
                      int shipSelection,
                      int ammoSelection1,
                      int ammoSelection2 )
    {
        this.ship = setShipAndAmmo(shipSelection, ammoSelection1, ammoSelection2);
        this.background = new Background(backgroundFileArray[backgroundSelection], 3000, 2400);
        enemies = new EnemyArray(WINDOW_WIDTH, WINDOW_HEIGHT, dificulty * 2);
        score = new Score(5, ship.getHitPoints(), WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    /**
     * Method that sets player ship and ammo types before game
     * @param shipSelection index for ship selection
     * @param ammoSelection1 index for ammo 1 selection
     * @param ammoSelection2 index for ammo 2 selection
     */

    public UserShip setShipAndAmmo(int shipSelection, int ammoSelection1, int ammoSelection2)
    {
        UserShip userShip[] = {
                new FreightCruizer(WINDOW_WIDTH, WINDOW_HEIGHT, ammo(ammoSelection1), ammo(ammoSelection2)),
                new BatwingGreen(WINDOW_WIDTH, WINDOW_HEIGHT, ammo(ammoSelection1), ammo(ammoSelection1), ammo(ammoSelection2), ammo(ammoSelection2)),
                new Dreadnought(WINDOW_WIDTH, WINDOW_HEIGHT, ammo(ammoSelection1), ammo(ammoSelection2)),
                new StarShip(WINDOW_WIDTH, WINDOW_HEIGHT, ammo(ammoSelection1), ammo(ammoSelection2))
        };

        return userShip[shipSelection];

    }

    private Ammo ammo(int selection)
    {
        Ammo ammo[] = {
                new FiftyCaliber(),
                new Phaser(),
                new Missile(),
                new ShotGun()};

        return ammo[selection];
    }



    public Scene spaceShooter(Button keepPlaying, Button returnToMain)
    {
        Group gameGroup = new Group();
        ObservableList gameList = gameGroup.getChildren();
        gameList.add(background.getBackground());
        gameList.addAll(ship.getObj());
        gameList.addAll(ship.getAmmo());
        gameList.addAll(enemies.getEnemies());
        gameList.addAll(enemies.getAllAmmo());
        gameList.addAll(score.getScoreLivesOut());
        gameList.addAll(keepPlaying, returnToMain);

        Scene scene = new Scene(gameGroup, WINDOW_WIDTH, WINDOW_HEIGHT);
        Controls controls = new Controls(scene, ship, enemies, score);

        enemies.animateMovement(WINDOW_WIDTH, WINDOW_HEIGHT, ship, score);
        background.moveForward();

        return scene;
    }

    public Score getScore()
    {
        return score;
    }
    public UserShip getShip()
    {
        return ship;
    }
}
