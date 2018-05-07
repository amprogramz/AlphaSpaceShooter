package com.Alpha.Space.Shooter;
/**
 * Alec McDaugale
 * This is a base class to inherit user ships from.
 */
import javafx.scene.control.Button;


public abstract class UserShip extends Ship
{
    /**
     * This sets the ship by default to the center bottom 1/4 of the screen.
     */
    public void setDefault()
    {
        super.setDefaultObjectLocation(super.getScreenWidth() / 2 , (super.getScreenHeight() / 4) * 3 );
    }

    /**
     * Sets action for when the ship is hit
     * @param damage Damage inflicted on the ship.
     * @param score Score object.
     */
    @Override
    public void destruct(int damage, Score score)
    {
        if(score.getHitPoints() > 0)
        {
            score.reduceHitPoints(damage);
            System.out.println("Health: " + score.getHitPoints());
        }else if (score.getLives() > 1) {
            super.moveShip(super.getX() - 2000, super.getY());
            score.setYouDiedVisible(true);
            score.decrementLives();
            System.out.println("Dead.");
            super.getDeathSound().play();
            //buttonKeepPlaying();

        }else if(score.getLives() == 1)
        {
            super.getObj().setLayoutX(super.getObj().getLayoutX() -2000);
            score.decrementLives();
            score.setGameOverVisible(true);
        }
    }

    /**
     * Abstract method to set the shot location on the ship.
     * @param enemy EnemyArray object.
     * @param score Score object.
     */
    public abstract void setShot(EnemyArray enemy, Score score);


}
