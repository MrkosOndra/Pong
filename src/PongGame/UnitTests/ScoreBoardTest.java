package PongGame.UnitTests;
import PongGame.Entities.ScoreBoard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ScoreBoardTest {
    @Test
    public void testAddPoints() {
        ScoreBoard sb = new ScoreBoard();
        sb.addPointPlayer();
        sb.addPointAi();
        sb.addPointAi();

        assertEquals(1, sb.getPlayerScore());
        assertEquals(2, sb.getAiScore());
    }
}
