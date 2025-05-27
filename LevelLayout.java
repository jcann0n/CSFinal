public class LevelLayout {

    // Returns the requested level layout as a 2D char array
    public static char[][] getLevel(int levelNumber) {
        switch (levelNumber) {
            case 1: return level1;
            case 2: return level2;
            case 3: return level3;
            case 4: return level4;
            case 5: return level5; // Boss level
            default: return level1;
        }
    }

    // Level 1 – Introduction to coins and platforms
    private static final char[][] level1 = {
        "........................".toCharArray(),
        "........................".toCharArray(),
        "....................C...".toCharArray(),
        "........===.............".toCharArray(),
        "......==........==....G.".toCharArray(),
        "P========================".toCharArray()
    };

    // Level 2 – Adds enemies
    private static final char[][] level2 = {
        "........................".toCharArray(),
        "............C...........".toCharArray(),
        ".......===......===.....".toCharArray(),
        ".....................E..".toCharArray(),
        "....==.....E....==....G.".toCharArray(),
        "P========================".toCharArray()
    };

    // Level 3 – More coins, trickier jumps
    private static final char[][] level3 = {
        "........C...............".toCharArray(),
        ".....===...........C....".toCharArray(),
        "...................===..".toCharArray(),
        "....==....C....==.......".toCharArray(),
        "...E........E..........G".toCharArray(),
        "P========================".toCharArray()
    };

    // Level 4 – Heavier challenge
    private static final char[][] level4 = {
        "....C......===......C...".toCharArray(),
        "......===...............".toCharArray(),
        "...E........==.....E....".toCharArray(),
        "..==...E.........===..G.".toCharArray(),
        ".......................G".toCharArray(),
        "P========================".toCharArray()
    };

    // Level 5 – Boss level
    private static final char[][] level5 = {
        "........................".toCharArray(),
        "...............B........".toCharArray(),
        "........................".toCharArray(),
        "....===....===....===...".toCharArray(),
        ".........E.......E....G.".toCharArray(),
        "P========================".toCharArray()
    };
}