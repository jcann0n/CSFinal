import java.awt.*;

/**
 * Displays HUD elements like score, lives, and boss HP if applicable.
 */
public class HUD {
    private Player player;
    private Boss boss;

    public HUD(Player player) {
        this.player = player;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    /**
     * Draw HUD: score, lives, and optionally boss health.
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));

        // Player stats
        g.drawString("Score: " + player.getScore(), 20, 30);
        g.drawString("Lives: " + player.getLives(), 20, 50);

        // Boss HP (only in level 5)
        if (boss != null) {
            g.drawString("Boss HP: " + (boss.isDefeated() ? "DEFEATED" : " " + boss.getBounds().getWidth()), 600, 30);
        }
    }
}
