import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(){
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }
//chat gpt
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(100, 100, 20, 80);
        g.fillOval(200, 200, 20, 20);
    }
}
