import java.awt.*;
public class Enemy {
    

/**
 * Represents a basic enemy in the game.
 * The enemy moves back and forth horizontally and checks for collision with the player.
 */
    private int x, y, width, height;
    private int speed;
    private boolean movingRight;
    private Rectangle bounds;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.speed = 2;
        this.movingRight = true;
        this.bounds = new Rectangle(x, y, width, height);
    }

    /**
     * Updates the enemy's position and patrol logic.
     */
    public void update() {
        // Move back and forth
        if (movingRight) {
            x += speed;
        } else {
            x -= speed;
        }

        // Reverse direction if hitting screen boundaries (adjust based on level design)
        if (x < 0 || x > 800 - width) {
            movingRight = !movingRight;
        }

        // Update collision bounds
        bounds.setLocation(x, y);
    }

    /**
     * Draws the enemy on the screen.
     */
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    /**
     * Returns the collision bounds of the enemy.
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * Checks if this enemy collides with the player.
     */
    public boolean collidesWith(Player player) {
        return bounds.intersects(player.getBounds());
    }
}

