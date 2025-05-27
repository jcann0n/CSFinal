import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * GamePanel is the main game engine class.
 * It handles the game loop, drawing, user input, and transitions between levels.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Player player;
    private ArrayList<Platform> platforms;
    private LevelManager levelManager;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.CYAN);
        setFocusable(true);
        addKeyListener(this);

        levelManager = new LevelManager();
        loadCurrentLevel();

        timer = new Timer(16, this); // ~60 frames per second
        timer.start();
    }

    /**
     * Ensures this panel gets keyboard focus when the game starts.
     * This is called from Main.java.
     */
    public void startGame() {
        requestFocusInWindow(); // Ensure key listener works
    }

    // Loads player and platform data for the current level
    private void loadCurrentLevel() {
        platforms = levelManager.loadLevel(levelManager.getCurrentLevel());
        player = new Player(100, 500); // Reset player to starting position
    }

    // Draw everything
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Platform p : platforms) p.draw(g);
        player.draw(g);

        // Display the level number
        g.setColor(Color.BLACK);
        g.drawString("Level " + levelManager.getCurrentLevel(), 10, 20);
    }

    // Main game update loop
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update(platforms);

        // If the player moves off screen to the right, load the next level
        if (player.getX() > 800) {
            if (!levelManager.isLastLevel()) {
                levelManager.nextLevel();
                loadCurrentLevel();
            } else {
                timer.stop();
                JOptionPane.showMessageDialog(this, "You beat the game!");
                System.exit(0);
            }
        }

        repaint(); // Repaint screen every frame
    }

    // Handle key press events and forward them to the player
    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
