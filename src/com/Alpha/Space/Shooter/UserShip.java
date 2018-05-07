package com.Alpha.Space.Shooter;

import javafx.scene.control.Button;

import java.util.ArrayList;

public abstract class UserShip extends Ship
{
    public void setDefault()
    {
        super.setDefaultObjectLocation(super.getScreenWidth() / 2 , (super.getScreenHeight() / 4) * 3 );
    }
    public void Destruct(int damage, Score score)
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
            buttonKeepPlaying();

        }else if(score.getLives() == 1)
        {
            super.getObj().setLayoutX(super.getObj().getLayoutX() -2000);
            score.decrementLives();
            score.setGameOverVisible(true);
        }
    }
    public abstract void setShot(EnemyArray enemy, Score score);

    Button keepPlaying = StylingTool.buttonCreator("Continue");
    private boolean respawn = false;
    public void buttonKeepPlaying()
    {
        keepPlaying.setVisible(true);

    }
    public Button getKeepPlaying(Score score)
    {
        keepPlaying.setLayoutY((super.getScreenHeight() / 2) + 100);
        keepPlaying.setLayoutX(super.getScreenWidth() / 2 - 100);
        keepPlaying.setOnMouseClicked(e -> {
            score.setHitPoints(super.getHitPoints());
            score.setYouDiedVisible(false);
            keepPlaying.setVisible(false);
            super.getObj().setLayoutX(super.getObj().getLayoutX() + 2000);

        });

        keepPlaying.setVisible(false);
        return keepPlaying;
    }

}
