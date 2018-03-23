package com.Alpha.Space.Shooter;

/**
 * Author Alec McDaugle
 * This is a class to create a scoring object to keep track of lives and points.
 */
public class Score
{
    private int score;
    private int lives;


    public Score(int lives)
    {
        score = 0;
        this.lives = lives;
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


}
