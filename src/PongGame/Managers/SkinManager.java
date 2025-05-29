package PongGame.Managers;

import java.awt.*;

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
    public static void selectBallColor(Color color) {
        if (isBallColorUnlocked(color)) {
            ballColor = color;
        }
    }
    public static void selectPaddleColor(Color color) {
        if (isPaddleColorUnlocked(color)) {
            paddleColor = color;
        }
    }

    public static boolean isBallColorUnlocked(Color color) {
        if (color.equals(Color.RED)) return redBallUnlocked;
        if (color.equals(Color.GREEN)) return greenBallUnlocked;
        if (color.equals(Color.YELLOW)) return yellowBallUnlocked;
        return false;
    }

    private static void unlockBallColor(Color color) {
        if (color.equals(Color.RED)) redBallUnlocked = true;
        if (color.equals(Color.GREEN)) greenBallUnlocked = true;
        if (color.equals(Color.YELLOW)) yellowBallUnlocked = true;
    }


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

    public static boolean isPaddleColorUnlocked(Color color) {
        if (color.equals(Color.RED)) return redPaddleUnlocked;
        if (color.equals(Color.BLUE)) return bluePaddleUnlocked;
        if (color.equals(Color.GREEN)) return greenPaddleUnlocked;
        return false;
    }
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

