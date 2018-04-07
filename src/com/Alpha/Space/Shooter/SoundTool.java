package com.Alpha.Space.Shooter;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;

public class SoundTool
{
    public static Media setMedia(String file)
    {
        try
        {
            return new Media( SpaceShooter.class.getResource(file).toURI().toString());
        }catch (Exception e)
        {
            System.out.println("Sound file not found.");
        }
        return null;
    }

    public static MediaPlayer getMediaPlayer(String file)
    {
        return new MediaPlayer(setMedia(file));
    }

    public static AudioClip getAudioClip(String file)
    {
        try
        {
            return new AudioClip( SpaceShooter.class.getResource(file).toURI().toString());
        }catch (Exception e)
        {
            System.out.println("Sound file not found.");
        }
        return null;
    }
}
