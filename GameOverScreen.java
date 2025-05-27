import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * GameOverScreen is displayed when the player loses or finishes the game.
 * It gives the option to restart the game.
 */
public class GameOverScreen {
    private boolean restartGame = false;

    /**
     * Called every frame, could add animations or effects here.
     */
    public void update() {
        // Add flickering effect or animations if desired
    }

    /**
     * Draws the game over screen.
     */
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600); // Clear screen with black

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("GAME OVER", 270, 200);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Press ENTER to Restart", 270, 300);
    }

    /**
     * Called when a key is pressed; waits for ENTER to restart the game.
     */
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_ENTER) {
            restartGame = true;
        }
    }

    /**
     * Returns true when the player has pressed ENTER to restart.
     */
    public boolean shouldRestartGame() {
        return restartGame;
    }
}
