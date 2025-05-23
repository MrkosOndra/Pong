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

}
