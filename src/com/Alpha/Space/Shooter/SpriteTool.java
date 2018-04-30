package com.Alpha.Space.Shooter;
/**Author Alec McDaugale
 * This Class provides static methods for a means to set return a sprite with an image path. You may also get the image
 * view and define the parameters to return this object directly.
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteTool
{
    /**
     * This method returns an Image from a filepath.
     * @param filePath String which specifies a file path.
     * @return Returns the image if the file path is valid.
     */
    public static Image setImage(String filePath)
    {
        try
        {
            return  new Image(SpaceShooter.class.getResourceAsStream(filePath));
        }catch(Exception e)
        {
            System.out.println("Image file was not found: " + filePath);
        }

        return null;
    }

    /**
     * This is a static method which gets an image from a designated filepath, and allows the user to define the x, y,
     * width, height, and preservation ratio and return an image view. Simplifies this process as it could get quite
     * redundant.
     * @param filePath String value specifying the file path starting at the sprite folder.
     * @param x double value of x.
     * @param y double value of y.
     * @param width double value of width.
     * @param height double value of height.
     * @param preservationRatio A boolean value which determines wether or not to keep an images native ratio when
     *                          changing the size.
     * @return Returns an ImageView object which we defined.
     */
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
    public static ImageView getImage(String filePath)
    {
        ImageView imageView = new ImageView();
        imageView.setImage(setImage(filePath));
        imageView.setVisible(false);
        return imageView;
    }

}
