import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Paddle player;

    private int screenWidth;
    private int screenHeight;

    public GamePanel() {
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setLayout(null);

        // chat gpt
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;


        int paddleWidth = screenWidth / 60;
        int paddleHeight = screenHeight / 5;
        int paddleX = screenWidth / 30;
        int paddleY = screenHeight / 2 - paddleHeight / 2;

        player = new Paddle(paddleX, paddleY, paddleWidth, paddleHeight);
    }
//chat gpt

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
}
