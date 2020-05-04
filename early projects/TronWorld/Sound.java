/**
 * The code used to add music into the game. 
 * The song used is "Ace of Clubs" by RoccoW, I DID NOT MAKE THE SONG.
 * The song's download link can be found here: http://freemusicarchive.org/genre/Chiptune/
 * The song is free, and can be used in works, so long as I do not claim that I made it, which I have not.
 */

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
   
// To play sound using Clip, the process needs to be alive.
// Hence, we use a Swing application.

public class Sound extends JFrame {
   // Constructor
   Clip clip;
   public Sound() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("\"Ace of Clubs\" by RoccoW");
      this.setSize(300, 200);
      this.setVisible(true);
   
      try {
         // Open an audio input stream.
         File soundFile = new File("music.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         // Get a sound clip resource.
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         // Because of the "LOOP_CONTINUOUSLY" the clip will loop until the game ends.
         clip.loop(clip.LOOP_CONTINUOUSLY);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
   public Clip getClip()
   {
       return clip;
    }
}