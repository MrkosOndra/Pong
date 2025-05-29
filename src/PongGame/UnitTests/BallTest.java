package PongGame.UnitTests;

import PongGame.Entities.Ball;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class BallTest {
    @Test
    public void testReverseYDirection() {
        Ball ball = new Ball(100, 100, 10, 10);
        int initialY = ball.getxVelocity();
        ball.ReverseYDirection();
        assertEquals(-initialY, ball.getyVelocity());
    }
}
