package com.Alpha.Space.Shooter;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;

public class SoundTool
{
    public static Media setSound(String file)
    {
        try
        {
            return new Media(( SpaceShooter.class.getResource(file)).toURI().toString());
        }catch (Exception e)
        {
            System.out.println("Sound file not found.");
        }
        return null;
    }

    public static MediaPlayer getSound(String file)
    {
        return new MediaPlayer(setSound(file));
    }
}
