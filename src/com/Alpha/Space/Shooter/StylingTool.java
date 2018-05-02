package com.Alpha.Space.Shooter;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class StylingTool
{
    public static Text textCreator(String stringToDisplay)
    {
        Text text = new Text(stringToDisplay);
        text.setFont(new Font(60));
        text.setFill(Color.LIGHTGRAY);

        return  text;
    }

    public static Text textCreator(String stringToDisplay, int fontSize)
    {
        Text text = new Text(stringToDisplay);
        text.setFont(new Font(fontSize));
        text.setFill(Color.LIGHTGRAY);

        return  text;
    }

    public static Button buttonCreator (String stringToDisplay)
    {
        Button button = new Button(stringToDisplay);
        button.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font-size: 2em");

        return button;
    }

    public static Button imageButtonCreator(String FilePath)
    {
        Button button = new Button("");
        button.setGraphic(SpriteTool.getImage(FilePath));
        button.setStyle("-fx-background-color: #000000");

        return button;
    }
}
