package sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
//import sun.applet.Main;

public class Sound {
    public static Clip getClip(String filename) {
        Clip clip = null;
        File file = new File("res\\sound\\" + filename +".wav");
        try {
            AudioInputStream input = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(input);
        } catch (Exception e) {
            System.out.println("No input file found" + filename);
        }
        return clip;
    }       
}
