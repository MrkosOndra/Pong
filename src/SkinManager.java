import java.awt.*;

public class SkinManager {
    private static int coins = 0;

    private static String selectedBallSkin = "default";
    private static Color paddleColor = Color.WHITE;

    private static final int footballPrice = 15;
    private static final int volleyballPrice = 20;
    private static final int tennisPrice = 30;
    private static final int paddleColorPrice = 10;


    private static boolean defaultSkinUnlocked = true;
    private static boolean footballUnlocked = false;
    private static boolean volleyballUnlocked = false;
    private static boolean tennisUnlocked = false;


    private static boolean redPaddleUnlocked = false;
    private static boolean bluePaddleUnlocked = false;
    private static boolean greenPaddleUnlocked = false;


    public static void addCoins(int amount) {
        coins += amount;
    }

    public static int getCoins() {
        return coins;
    }


    public static String getSelectedBallSkin() {
        return selectedBallSkin;
    }
    public static boolean selectBallSkin(String skinName) {
        switch (skinName) {
            case "default":
                if (defaultSkinUnlocked) {
                    selectedBallSkin = "default";
                    return true;
                }
                break;
            case "football":
                if (footballUnlocked) {
                    selectedBallSkin = "football";
                    return true;
                }
                break;
            case "volleyball":
                if (volleyballUnlocked) {
                    selectedBallSkin = "volleyball";
                    return true;
                }
                break;
            case "tennis":
                if (tennisUnlocked) {
                    selectedBallSkin = "tennis";
                    return true;
                }
                break;
        }
        return false;
    }

    public static boolean purchaseBallSkin(String skinName) {
        switch (skinName) {
            case "football":
                if (!footballUnlocked && coins >= footballPrice) {
                    coins -= footballPrice;
                    footballUnlocked = true;
                    selectedBallSkin = "football";
                    return true;
                }
                break;
            case "volleyball":
                if (!volleyballUnlocked && coins >= volleyballPrice) {
                    coins -= volleyballPrice;
                    volleyballUnlocked = true;
                    selectedBallSkin = "volleyball";
                    return true;
                }
                break;
            case "tennis":
                if (!tennisUnlocked && coins >= tennisPrice) {
                    coins -= tennisPrice;
                    tennisUnlocked = true;
                    selectedBallSkin = "tennis";
                    return true;
                }
                break;
        }
        return false;
    }

    public static boolean isBallSkinUnlocked(String skinName) {
        switch (skinName) {
            case "default":
                return defaultSkinUnlocked;
            case "football":
                return footballUnlocked;
            case "volleyball":
                return volleyballUnlocked;
            case "tennis":
                return tennisUnlocked;
            default:

                return false;
        }
    }
    public static Color getPaddleColor() {
        return paddleColor;
    }

    public static boolean purchasePaddleColor(Color color) {
        if (color.equals(Color.RED)) {
            if (!redPaddleUnlocked && coins >= paddleColorPrice) {
                coins -= paddleColorPrice;
                redPaddleUnlocked = true;
            }
            if (redPaddleUnlocked) {
                paddleColor = color;
                return true;
            }
        }

        if (color.equals(Color.BLUE)) {
            if (!bluePaddleUnlocked && coins >= paddleColorPrice) {
                coins -= paddleColorPrice;
                bluePaddleUnlocked = true;
            }
            if (bluePaddleUnlocked) {
                paddleColor = color;
                return true;
            }
        }

        if (color.equals(Color.GREEN)) {
            if (!greenPaddleUnlocked && coins >= paddleColorPrice) {
                coins -= paddleColorPrice;
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
}

