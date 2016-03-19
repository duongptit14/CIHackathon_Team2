package Object;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class JVSound {
    private Clip oClip;
        public Clip playWAV(String dir)
    {

        try {
            File soundFile = new File(dir);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            this.oClip = clip;


        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        return oClip;
    }
}

