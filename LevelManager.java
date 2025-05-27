import java.util.ArrayList;

/**
 * The LevelManager class manages which level is currently loaded.
 * It provides platforms based on the current level and moves to the next level when requested.
 */
public class LevelManager {
    private int currentLevel = 1;
    private final int maxLevel = 5;

    // Returns a list of platforms for the current level
    public ArrayList<Platform> loadLevel(int level) {
        ArrayList<Platform> platforms = new ArrayList<>();
        platforms.add(new Platform(0, 550, 800, 50)); // Ground for all levels

        // Add level-specific platforms
        switch (level) {
            case 1:
                platforms.add(new Platform(200, 450, 100, 20));
                platforms.add(new Platform(400, 350, 100, 20));
                break;
            case 2:
                platforms.add(new Platform(250, 400, 120, 20));
                platforms.add(new Platform(500, 300, 100, 20));
                break;
            case 3:
                platforms.add(new Platform(100, 400, 100, 20));
                platforms.add(new Platform(300, 300, 100, 20));
                platforms.add(new Platform(500, 200, 100, 20));
                break;
            case 4:
                platforms.add(new Platform(350, 450, 150, 20));
                platforms.add(new Platform(600, 350, 100, 20));
                break;
            case 5:
                platforms.add(new Platform(300, 400, 200, 20));
                platforms.add(new Platform(550, 300, 150, 20));
                break;
        }

        return platforms;
    }

    // Move to the next level (if not already at max)
    public void nextLevel() {
        if (currentLevel < maxLevel) {
            currentLevel++;
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public boolean isLastLevel() {
        return currentLevel == maxLevel;
    }
}
