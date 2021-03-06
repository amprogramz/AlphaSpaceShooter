package com.Alpha.Space.Shooter;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


import java.util.ArrayList;

/**
 * Author Alec McDaugle
 * This is a class to create a scoring object to keep track of lives and points.
 */
public class Score
{
    private int score;
    private int lives;
    private double hitPoints;

    private Text scoreOut = new Text();
    private Text livesOut = new Text();
    private Text hitPointOut = new Text();
    private ProgressBar hitPointBar = new ProgressBar();

    private Text youDied;
    private Text gameOver;

    //private Button keepPlaying = StylingTool.buttonCreator("Continue");


    public Score(int lives, double hitPoints, double screenHeight, double screenWidth)
    {

        score = 0;
        this.lives = lives;
        this.hitPoints = hitPoints;

        scoreOut = StylingTool.inGameTextCreator();
        updateScoreOut();
        scoreOut.setX(5);
        scoreOut.setY(25);

        livesOut = StylingTool.inGameTextCreator();
        updateLivesOut();
        livesOut.setX(150);
        livesOut.setY(25);


        setHitPointBar();
        hitPointBar.setMaxWidth(500);
        hitPointBar.setLayoutX(650);
        hitPointBar.setLayoutY(10);

        hitPointOut = StylingTool.inGameTextCreator();
        setHitPointOut();
        hitPointOut.setX(500);
        hitPointOut.setY(25);


        gameOver = StylingTool.inGameTextCreator();
        gameOver.setText("GAME OVER");
        gameOver.setX(screenWidth / 2);
        gameOver.setY(screenHeight / 2);
        gameOver.setVisible(false);

        youDied = StylingTool.inGameTextCreator();
        youDied.setText("YOU DIED");
        youDied.setX(screenWidth / 2);
        youDied.setY(screenHeight / 2);
        youDied.setVisible(false);



    }

    public void setScore(int score)
    {
        this.score = + score;
        updateScoreOut();
    }
    public int getScore()
    {
        return score;
    }
    public void updateScoreOut()
    {
        scoreOut.setText("Score: " + this.score);
    }
    public void setLives(int lives)
    {
        this.lives = lives;
    }
    public void decrementLives()
    {
        lives--;
        updateLivesOut();
    }
    public int getLives()
    {
        return lives;
    }
    public void updateLivesOut()
    {
        livesOut.setText("Lives: " + this.lives);
    }
    public ArrayList<Node> getScoreLivesOut()
    {
        ArrayList<Node> UIOut = new ArrayList<>();
        UIOut.add(scoreOut);
        UIOut.add(livesOut);
        UIOut.add(hitPointOut);
        UIOut.add(hitPointBar);
        UIOut.add(gameOver);
        UIOut.add(youDied);
        //UIOut.add(keepPlaying);
        return UIOut;
    }
    public void setHitPoints(double hitPoints)
    {
        this.hitPoints = hitPoints;
        setHitPointOut();
        setHitPointBar();
    }
    public double getHitPoints()
    {
        return hitPoints;
    }
    public void reduceHitPoints(int damage)
    {
        hitPoints = hitPoints - damage;
        setHitPointOut();
        setHitPointBar();
    }
    public void setHitPointOut()
    {
        hitPointOut.setText("HP: " + hitPoints);
    }
    public void setHitPointBar()
    {
        hitPointBar.setProgress(hitPoints/100);
    }

    public void setYouDiedVisible(boolean visible)
    {
        youDied.setVisible(visible);

//        keepPlaying.setLayoutX(300);
//        keepPlaying.setLayoutY(300);

    }

    public void setGameOverVisible(boolean visible)
    {
        gameOver.setVisible(visible);
    }


}
