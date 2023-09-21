import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class SplashScreen {

    private void createAndShowGUI() {
        // Create a JFrame for the splash screen
        JFrame splashFrame = new JFrame("Splash Screen");
        splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashFrame.setSize(1800, 1000);

        String logoUrl = "https://github.com/jstrother123/photon-main/blob/main/logo.jpg?raw=true";
       
        

        try { //I had an unhandle exception so I had to have a try catch for it to run
            URL url = new URL(logoUrl);
            // Create a JLabel to display the image
            ImageIcon splashImageIcon = new ImageIcon(url); //
            JLabel splashLabel = new JLabel(splashImageIcon);

            // Add the label to the frame
            splashFrame.add(splashLabel);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Center the splash screen on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - splashFrame.getWidth()) / 2;
        int y = (screenSize.height - splashFrame.getHeight()) / 2;
        splashFrame.setLocation(x, y);

        // Set the visibility of the splash screen
        splashFrame.setVisible(true);

        // Simulate some initialization/loading time (e.g., 3 seconds)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the splash screen and proceed to the main application
        splashFrame.dispose();

        // start main program after this
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SplashScreen example = new SplashScreen();
            example.createAndShowGUI();
        });
    }
}
