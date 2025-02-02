import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AudioControl {
    public static void main(String[] args) {
        try {
            // Specify the path to the audio file
            File audioFile = new File("audio.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            Scanner scanner = new Scanner(System.in);
            String command = "";

            System.out.println("Commands: play, loop, stop, exit");
            while (!command.equals("exit")) {
                System.out.print("Enter command: ");
                command = scanner.nextLine();

                switch (command) {
                    case "play":
                        clip.start();
                        System.out.println("Playing audio...");
                        break;
                    case "loop":
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                        System.out.println("Looping audio...");
                        break;
                    case "stop":
                        clip.stop();
                        System.out.println("Audio stopped.");
                        break;
                    case "exit":
                        clip.close();
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
            }

            scanner.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}

