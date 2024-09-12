
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Audio {
    public static void main(String[] args) throws LineUnavailableException /*(if Audio line is unavailable) */, IOException /*(if an I/O error occurs) */, UnsupportedAudioFileException /*(If audio file is not supported) */ {

        // Creating a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Load the audio file
        File file = new File("Running It Down - Everet Almond.wav ");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

        // Create a clip to play the audio
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);


        // Initialize the response variable
        String response = "";

        // Loop until the user quits
        while(!response.equals("Q")){
            System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
            System.out.println("Enter your choice");
            response = scanner.next();
            response = response.toUpperCase();


            // Handle user input
            switch (response){
                case ("P"): clip.start();
                break;
                case("S"): clip.stop();
                break;
                case("R"): clip.setMicrosecondPosition(0);
                break;
                case("Q"): clip.close();
                break;
                default:
                    System.out.println("Not a valid response");

            }
        }
        System.out.println("Byeee!");



    }
}
