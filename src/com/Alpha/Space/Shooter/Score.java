package com.Alpha.Space.Shooter;

import javafx.scene.paint.Color;
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
        scoreOut.setY(15);
        scoreOut.setFill(Color.RED);

        livesOut.setText("Lives: " + lives);
        livesOut.setX(150);
        livesOut.setY(15);
        livesOut.setFill(Color.RED);

    }

    public void setScore(int score)
    {
        this.score = + score;
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

    public Text getScoreOut()
    {
        return scoreOut;
    }
    public Text getLivesOut()
    {
        return livesOut;
    }
    public ArrayList<Text> getScoreLivesOut()
    {
        ArrayList<Text> UIOut = new ArrayList<>();
        UIOut.add(scoreOut);
        UIOut.add(livesOut);
        return UIOut;
    }


}
