package com.Alpha.Space.Shooter;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Alec McDaugale
 *The Styling tool class contains methods to easily construct Text and buttons with a set style
 */
public class StylingTool
{
	/**
     * Method to create Text with set size,font and color
     * @return text that will be displayed
     */
	public static Text textCreator(String stringToDisplay)
    {
        Text text = new Text(stringToDisplay);
        text.setFont(new Font(60));
        text.setFill(Color.LIGHTGRAY);

        return  text;
    }
	/**
     * Method to create text with set font and color. Font size can be altered
     * @return text that will be displayed
     */
    public static Text textCreator(String stringToDisplay, int fontSize)
    {
        Text text = new Text(stringToDisplay);
        text.setFont(new Font(fontSize));
        text.setFill(Color.LIGHTGRAY);

        return  text;
    }

    public static Text inGameTextCreator(String stringToDisplay)
    {
        Text text = new Text(stringToDisplay);
        text.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, FontPosture.REGULAR, 25));
        text.setStrokeWidth(1);
        text.setStroke(Color.BLACK);
        text.setFill(Color.RED);

        return text;
    }
    /**
     * Method to create button with set background color, font color and font size
     * @return button that was created
     */
    public static Button buttonCreator (String stringToDisplay)
    {
        Button button = new Button(stringToDisplay);
        button.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");

        return button;
    }
    /**
     * Method to create button with image on top of the button
     * @return button that was created
     */
    public static Button imageButtonCreator(String FilePath)
    {
        Button button = new Button("");
        button.setGraphic(SpriteTool.getImage(FilePath));
        button.setStyle("-fx-background-color: #000000");

        return button;
    }
    /**
     * Method to create button with image on top of the button and set button size
     * @return button that was created
     */
    public static Button imageButtonCreator(String FilePath, double size)
    {
        Button button = new Button("");
        button.setGraphic(SpriteTool.getImage(FilePath, size, size));
        button.setStyle("-fx-background-color: #000000");

        return button;
    }
}
