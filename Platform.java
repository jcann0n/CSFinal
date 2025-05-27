import java.awt.*;

/**
 * The Platform class represents solid objects in the level the player can stand on.
 * Each platform has a position and size, and can be drawn and collided with.
 */
public class Platform {
    private int x, y, width, height;

    public Platform(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Draws the platform on screen
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, width, height);
    }

    // Returns a Rectangle representing the bounds of the platform (for collision detection)
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    // Used in player collision logic to check vertical positioning
    public int getY() {
        return y;
    }
}

