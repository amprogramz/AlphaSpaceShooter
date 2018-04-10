package com.Alpha.Space.Shooter;


import javafx.scene.image.ImageView;

public class Background
{
    ImageView background;
    String filePath = "sprite/Gods-and-Idols-2012-04-11-21-40-17-86.jpg";

    public Background()
    {
        background = SpriteTool.getImage(filePath, 0, 0);
    }
}
