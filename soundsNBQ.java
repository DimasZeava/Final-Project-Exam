package pkg;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class soundsNBQ {

    Clip clip;
    URL soundsE[] = new URL[10];
    
    public soundsNBQ() {
        
        soundsE[0] = getClass().getResource("soundEffect/You-Stupid.wav");
        soundsE[1] = getClass().getResource("soundEffect/Not-Bad.wav");
        soundsE[2] = getClass().getResource("soundEffect/Uh-Interesting.wav");
        soundsE[3] = getClass().getResource("soundEffect/Wunderbar-Score.wav");
        soundsE[4] = getClass().getResource("soundEffect/Perfect-Score.wav");
        soundsE[5] = getClass().getResource("soundEffect/bruh-sound.wav");
        soundsE[6] = getClass().getResource("soundEffect/ding-sound.wav");
        soundsE[7] = getClass().getResource("soundEffect/Unacceptable-Score.wav");
        soundsE[8] = getClass().getResource("soundEffect/Low-Than-Six.wav");
        soundsE[9] = getClass().getResource("soundEffect/ChillBGMLoop.wav");

    }

    public void settingFile(int i) {

        try {

            AudioInputStream newSound = AudioSystem.getAudioInputStream(soundsE[i]);
            clip = AudioSystem.getClip();
            clip.open(newSound);

        } catch (Exception e) {

        }
    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
    
}
