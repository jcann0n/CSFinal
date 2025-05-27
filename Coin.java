import java.awt.*;

/**
 * Represents a collectible coin in the level.
 * Player can collect these to increase score.
 */
public class Coin {
    private int x, y;
    private int size = 20;
    private Rectangle bounds;
    private boolean collected;

    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
        this.bounds = new Rectangle(x, y, size, size);
        this.collected = false;
    }

    /**
     * Draws the coin if not collected.
     */
    public void draw(Graphics g) {
        if (!collected) {
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, size, size);
        }
    }

    /**
     * Checks if player collides with the coin.
     * Marks as collected if true.
     */
    public void checkCollected(Player player) {
        if (!collected && player.getBounds().intersects(bounds)) {
            collected = true;
            player.addScore(10); // Assumes Player has a score system
        }
    }

    public boolean isCollected() {
        return collected;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
