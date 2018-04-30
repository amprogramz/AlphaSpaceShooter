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


       int index = 0;
       int index2 = 0;
       double width = 64;
       double height = 64;

        public Explosion()
        {
            hitExplosionSprite.setVisible(false);
            hitExplosionSprite.setViewport(new Rectangle2D(0,0,63.33,63.33));
            explosion.getChildren().add(hitExplosionSprite);

        }

        public void setHitExplosion(double x, double y)
        {

            hitExplosionSprite.setVisible(true);
            explosion.setLayoutX(x);
            explosion.setLayoutY(y);
            if (index < 8) {
                hitExplosionSprite.setViewport(new Rectangle2D(index * width, index2 * height, 63, 63.33));
                index++;
            }else
            {
                hitExplosionSprite.setViewport(new Rectangle2D(index * width, index2 * height, 63, 63.33));
                index = 0;
                index2++;
            }
        }
        public void animateHitExplosion(double x, double y)
        {
            index = 0;
            index2 = 0;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(20),
                    ae ->  setHitExplosion(x, y) ));


            timeline.setCycleCount(100);
            timeline.play();
           // setHitExplosion(x, y);

        }

        public Group getHitExplosionSprite()
        {

            return explosion;
        }
}
