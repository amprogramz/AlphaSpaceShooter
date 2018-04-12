package com.Alpha.Space.Shooter;

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

    private Text scoreOut = new Text();
    private Text livesOut = new Text();

    public Score(int lives)
    {

        score = 0;
        this.lives = lives;

        scoreOut.setText("Score: " + score);
        scoreOut.setX(5);
        scoreOut.setY(25);
        scoreOut.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, FontPosture.REGULAR, 25));
        scoreOut.setStrokeWidth(1);
        scoreOut.setStroke(Color.BLACK);
        scoreOut.setFill(Color.RED);

        livesOut.setText("Lives: " + lives);
        livesOut.setX(150);
        livesOut.setY(25);
        livesOut.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, FontPosture.REGULAR, 25));
        livesOut.setStrokeWidth(1);
        livesOut.setStroke(Color.BLACK);
        livesOut.setFill(Color.RED);

    }

    public void setScore(int score)
    {
        this.score = + score;
        scoreOut.setText("Score: " + this.score);
    }
    public int getScore()
    {
        return score;
    }
    public void rsetLives(int lives)
    {
        this.lives = lives;
    }
    public void decrementLives()
    {
        lives--;
    }
    public int getLives()
    {
        return lives;
    }

   /* public Text getScoreOut()
    {
        return scoreOut;
    }
    public Text getLivesOut()
    {
        return livesOut;
    }
    */
    public ArrayList<Text> getScoreLivesOut()
    {
        ArrayList<Text> UIOut = new ArrayList<>();
        UIOut.add(scoreOut);
        UIOut.add(livesOut);
        return UIOut;
    }


}
