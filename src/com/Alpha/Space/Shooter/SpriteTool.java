package com.Alpha.Space.Shooter;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteTool
{
    public static Image setImage(String filePath)
    {
        try
        {
            return  new Image(SpaceShooter.class.getResourceAsStream(filePath));
        }catch(Exception e)
        {
            System.out.println("file was not found.");
        }

        return null;
    }
    public static ImageView getImage(String filePath, double x, double y, double width, double height, boolean preservationRatio)
    {
        ImageView imageView = new ImageView();
        imageView.setImage(setImage(filePath));
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        return imageView;
    }
    public static ImageView getImage(String filePath, double width, double height)
    {
        return getImage(filePath, 0, 0, width, height, true);
    }

}
