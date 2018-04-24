package com.Alpha.Space.Shooter;

import javafx.scene.Node;
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

    public Score(int lives, double hitPoints)
    {

        score = 0;
        this.lives = lives;
        this.hitPoints = hitPoints;

        updateScoreOut();
        scoreOut.setX(5);
        scoreOut.setY(25);
        scoreOut.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, FontPosture.REGULAR, 25));
        scoreOut.setStrokeWidth(1);
        scoreOut.setStroke(Color.BLACK);
        scoreOut.setFill(Color.RED);

        updateLivesOut();
        livesOut.setX(150);
        livesOut.setY(25);
        livesOut.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, FontPosture.REGULAR, 25));
        livesOut.setStrokeWidth(1);
        livesOut.setStroke(Color.BLACK);
        livesOut.setFill(Color.RED);

        setHitPointBar();
        hitPointBar.setMaxWidth(500);
        hitPointBar.setLayoutX(650);
        hitPointBar.setLayoutY(10);

        setHitPointOut();
        hitPointOut.setX(500);
        hitPointOut.setY(25);
        hitPointOut.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, FontPosture.REGULAR, 25));
        hitPointOut.setStrokeWidth(1);
        hitPointOut.setStroke(Color.BLACK);
        hitPointOut.setFill(Color.RED);


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
        return UIOut;
    }
    public void setHitPoints(int hitPoints)
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


}
