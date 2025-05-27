import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Main class that launches the 2D platformer game.
 */
public class Main {

    public static void main(String[] args) {
        // Launch GUI code on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create the game window
            JFrame frame = new JFrame("2D Platformer Game");

            // Create an instance of the GamePanel (the game screen)
            GamePanel gamePanel = new GamePanel();

            // Attach the game panel to the window
            frame.setContentPane(gamePanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();                    // Resize window to fit panel
            frame.setResizable(false);       // Disable resizing
            frame.setLocationRelativeTo(null); // Center window on screen
            frame.setVisible(true);          // Make the window visible

            // Ensure the panel is focused for key input
            gamePanel.startGame();  // You MUST have this method in GamePanel
        });
    }
}
