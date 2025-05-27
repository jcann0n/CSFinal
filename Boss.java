import java.awt.*;

/**
 * Represents a boss enemy for level 5.
 * Inherits from Enemy but includes health and special drawing.
 */
public class Boss extends Enemy {
    private int health;

    /**
     * Creates a boss enemy at the given position with extra health.
     */
    public Boss(int x, int y) {
        super(x, y);
        this.health = 5; // Boss takes 5 hits to defeat
    }

    /**
     * Draws the boss with a different color and health display.
     */
    @Override
    public void draw(Graphics g) {
        Rectangle bounds = getBounds();
        g.setColor(Color.MAGENTA);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

        g.setColor(Color.WHITE);
        g.drawString("Boss HP: " + health, bounds.x, bounds.y - 10);
    }

    /**
     * Reduces boss health when hit.
     */
    public void takeDamage() {
        health--;
    }

    /**
     * Returns true if the boss is defeated.
     */
    public boolean isDefeated() {
        return health <= 0;
    }
}
