package com.Alpha.Space.Shooter;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundTool
{
    /**
     * setMedia finds a file and returns the audio clip.
     * @param file Strung value that holds the file name.
     * @return Media Object.
     */
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

    /**
     * Adds the Media node to the Media.
     * @param file A String containing the file name.
     * @return A MediaPlayer that contains the sounds.
     */
    public static MediaPlayer getMediaPlayer(String file)
    {
        return new MediaPlayer(setMedia(file));
    }

    /**
     * Returns an AudioClip from a file.
     * @param file A String containing the file name.
     * @return AudioClip that we looked up the file name and confirmed it works.
     */
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
