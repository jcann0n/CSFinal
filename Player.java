import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Represents the player character in the game.
 */
public class Player {
    private int x, y;
    private int width = 40;
    private int height = 50;

    private int dx = 0; // x velocity
    private int dy = 0; // y velocity

    private boolean left, right, jumping, onGround;
    private int jumpStrength = -15;
    private int gravity = 1;
    private int maxFallSpeed = 10;

    private Rectangle bounds;

    private int score;
    private int lives;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.bounds = new Rectangle(x, y, width, height);

        this.score = 0;
        this.lives = 3;
    }

    /**
     * Basic update — handles movement, jumping, and gravity.
     */
    public void update() {
        dx = 0;

        if (left) dx -= 5;
        if (right) dx += 5;

        if (jumping && onGround) {
            dy = jumpStrength;
            onGround = false;
        }

        dy += gravity;
        if (dy > maxFallSpeed) {
            dy = maxFallSpeed;
        }

        x += dx;
        y += dy;

        bounds.setLocation(x, y);

        // Simple ground collision
        if (y + height >= 400) {
            y = 400 - height;
            dy = 0;
            onGround = true;
        }
    }

    /**
     * Extended update — also handles collision with platforms.
     */
    public void update(ArrayList<Platform> platforms) {
        update(); // run basic update

        // Check collision with each platform
        for (Platform p : platforms) {
            if (getBounds().intersects(p.getBounds())) {
                // If falling onto the platform
                if (y + height - dy <= p.getY()) {
                    y = p.getY() - height;
                    dy = 0;
                    onGround = true;
                }
            }
        }

        bounds.setLocation(x, y);
    }

    /**
     * Draws the player rectangle.
     */
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getX() {
        return x;
    }

    // Movement setters
    public void setLeft(boolean b) {
        left = b;
    }

    public void setRight(boolean b) {
        right = b;
    }

    public void setJumping(boolean b) {
        jumping = b;
    }

    // Score and lives
    public int getScore() {
        return score;
    }

    public void addScore(int amount) {
        score += amount;
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }

    public void gainLife() {
        lives++;
    }

    // Optional reset (for respawn)
    public void resetPosition(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.dy = 0;
        bounds.setLocation(x, y);
    }

    // Handle key input
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) setLeft(true);
        if (code == KeyEvent.VK_RIGHT) setRight(true);
        if (code == KeyEvent.VK_SPACE) setJumping(true);
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) setLeft(false);
        if (code == KeyEvent.VK_RIGHT) setRight(false);
        if (code == KeyEvent.VK_SPACE) setJumping(false);
    }
}
