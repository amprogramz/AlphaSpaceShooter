package com.Alpha.Space.Shooter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Explosion
{
        private ImageView hitExplosionSprite =  new ImageView(SpriteTool.setImage("sprite/explosion.png"));
        Group explosion = new Group();

        public Explosion()
        {
            hitExplosionSprite.setViewport(new Rectangle2D(190,0,65,75));
            explosion.getChildren().add(hitExplosionSprite);

        }

        public void setHitExplosion(double x, double y)
        {

            hitExplosionSprite.getParent().setVisible(true);
            explosion.setLayoutX(x);
            explosion.setLayoutY(y);

        }
        public void animateHitExplosion(double x, double y)
        {
//            Timeline timeline = new Timeline(new KeyFrame(
//                    Duration.millis(10),
//                    ae ->  setHitExplosion(x, y) ));
//
//
//            timeline.setCycleCount(70);
//            timeline.play();
            setHitExplosion(x, y);

        }

        public Group getHitExplosionSprite()
        {

            return explosion;
        }
}
