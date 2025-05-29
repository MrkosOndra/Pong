package PongGame.UnitTests;
import PongGame.Managers.SkinManager;
import org.junit.jupiter.api.Test;

import java.awt.*;


import static org.junit.jupiter.api.Assertions.*;

public class SkinManagerTest {
    @Test
    public void testPurchasePaddleColor() {
        SkinManager.addCoins(100); // ensure enough coins
        boolean unlocked = SkinManager.purchasePaddleColor(Color.RED);
        assertTrue(unlocked);
        assertEquals(Color.RED, SkinManager.getPaddleColor());
    }
}
