import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * TitleScreen is shown before the game starts.
 * It waits for the player to press ENTER to begin the game.
 */
public class TitleScreen {
    private boolean startGame = false;

    /**
     * Called every frame, currently not doing anything dynamic.
     */
    public void update() {
        // Could add animation or music here
    }

    /**
     * Draws the title screen with a game title and instructions.
     */
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600); // Clear screen with black background

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("My 2D Platformer", 230, 200);

        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Press ENTER to Start", 280, 300);
        g.drawString("Use Arrow Keys to Move and Jump", 230, 340);
    }

    /**
     * Called when a key is pressed; waits for ENTER to start the game.
     */
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_ENTER) {
            startGame = true;
        }
    }

    /**
     * Returns true when the player has pressed ENTER to start.
     */
    public boolean shouldStartGame() {
        return startGame;
    }
}

