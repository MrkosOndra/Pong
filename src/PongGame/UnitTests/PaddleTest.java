package PongGame.UnitTests;
import PongGame.Entities.Paddle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaddleTest {

    @Test
    public void testMoveUpDoesNotGoNegative() {
        Paddle paddle = new Paddle(100, 0, 10, 100);
        paddle.moveUp();
        assertTrue(paddle.getY() >= 0);
    }

    @Test
    public void testMoveDownWithinBounds() {
        int screenHeight = 600;
        Paddle paddle = new Paddle(100, screenHeight - 100, 10, 100);
        paddle.moveDown(screenHeight);
        assertTrue(paddle.getY() + paddle.getHeight() <= screenHeight);
    }
}
