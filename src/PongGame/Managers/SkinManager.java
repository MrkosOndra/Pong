package PongGame.Managers;

import java.awt.*;
/**
 * The SkinManager class handles unlocking, purchasing, and selecting
 * paddle and ball colors. It also manages player coins.
 */
public class SkinManager {
    private static int coins = 0;

    private static String selectedBallSkin = "default";
    private static Color paddleColor = Color.WHITE;
    private static Color ballColor = Color.WHITE;

    private static final int colorPrice = 20;


    private static boolean redBallUnlocked = false;
    private static boolean greenBallUnlocked = false;
    private static boolean yellowBallUnlocked = false;


    private static boolean redPaddleUnlocked = false;
    private static boolean bluePaddleUnlocked = false;
    private static boolean greenPaddleUnlocked = false;

    /**
     * Tries to purchase or select a ball color.
     * @param color the desired ball color
     * @return true if the purchase or selection was successful
     */
    public static boolean purchaseBallColor(Color color) {
        if (isBallColorUnlocked(color)) {
            ballColor = color;
            return true;
        }

        if (coins >= colorPrice) {
            coins -= colorPrice;
            unlockBallColor(color);
            ballColor = color;
            return true;
        }
        return false;
    }
    /**
     * Sets the selected ball color if it is already unlocked.
     * @param color the desired ball color
     */
    public static void selectBallColor(Color color) {
        if (isBallColorUnlocked(color)) {
            ballColor = color;
        }
    }
    /**
     * Sets the selected paddle color if it is already unlocked.
     * @param color the desired paddle color
     */
    public static void selectPaddleColor(Color color) {
        if (isPaddleColorUnlocked(color)) {
            paddleColor = color;
        }
    }
    /**
     * Checks if the given ball color is unlocked.
     * @param color the ball color to check
     * @return true if the color is unlocked
     */
    public static boolean isBallColorUnlocked(Color color) {
        if (color.equals(Color.RED)) return redBallUnlocked;
        if (color.equals(Color.GREEN)) return greenBallUnlocked;
        if (color.equals(Color.YELLOW)) return yellowBallUnlocked;
        return false;
    }
    /**
     * Unlocks the given ball color.
     * @param color the color to unlock
     */
    private static void unlockBallColor(Color color) {
        if (color.equals(Color.RED)) redBallUnlocked = true;
        if (color.equals(Color.GREEN)) greenBallUnlocked = true;
        if (color.equals(Color.YELLOW)) yellowBallUnlocked = true;
    }

    /**
     * Tries to purchase or select a paddle color.
     * @param color the desired paddle color
     * @return true if the purchase or selection was successful
     */
    public static boolean purchasePaddleColor(Color color) {
        if (color.equals(Color.RED)) {
            if (!redPaddleUnlocked && coins >= colorPrice) {
                coins -= colorPrice;
                redPaddleUnlocked = true;
            }
            if (redPaddleUnlocked) {
                paddleColor = color;
                return true;
            }
        }

        if (color.equals(Color.BLUE)) {
            if (!bluePaddleUnlocked && coins >= colorPrice) {
                coins -= colorPrice;
                bluePaddleUnlocked = true;
            }
            if (bluePaddleUnlocked) {
                paddleColor = color;
                return true;
            }
        }

        if (color.equals(Color.GREEN)) {
            if (!greenPaddleUnlocked && coins >= colorPrice) {
                coins -= colorPrice;
                greenPaddleUnlocked = true;
            }
            if (greenPaddleUnlocked) {
                paddleColor = color;
                return true;
            }
        }

        return false;
    }
    /**
     * Checks if the given paddle color is unlocked.
     * @param color the paddle color to check
     * @return true if the color is unlocked
     */
    public static boolean isPaddleColorUnlocked(Color color) {
        if (color.equals(Color.RED)) return redPaddleUnlocked;
        if (color.equals(Color.BLUE)) return bluePaddleUnlocked;
        if (color.equals(Color.GREEN)) return greenPaddleUnlocked;
        return false;
    }
    /**
     * Adds coins to the player's balance.
     * @param amount the number of coins to add
     */
    public static void addCoins(int amount) {
        coins += amount;
    }

    public static int getCoins() {
        return coins;
    }


    public static String getSelectedBallSkin() {
        return selectedBallSkin;
    }

    public static Color getPaddleColor() {
        return paddleColor;
    }

    public static Color getBallColor() {
        return ballColor;
    }
}

