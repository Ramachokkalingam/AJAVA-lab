import javax.swing.*;
import java.awt.*;

public class LoadImage {
    public static void main(String[] args) {
        // Create a JFrame window
        JFrame frame = new JFrame("Image Loader");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load and display the image
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Specify the path to the image file
        JLabel label = new JLabel(imageIcon);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        frame.add(label);
        frame.setVisible(true);
    }
}

