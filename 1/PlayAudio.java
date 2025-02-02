import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayAudio {
    public static void main(String[] args) {
        try {
            // Specify the path to the audio file
            File audioFile = new File("audio.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            // Play the audio clip
            clip.start();
            System.out.println("Playing audio...");

            // Keep the program running until the audio finishes
            while (clip.isRunning()) {
                Thread.sleep(100);
            }

            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

