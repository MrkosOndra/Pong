import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {
    public ShopPanel(JFrame frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        JLabel title = new JLabel("OBCHOD");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(20));
        add(title);


        JLabel coinsLabel = new JLabel("Máš " + SkinManager.getCoins() + " coinu");
        coinsLabel.setForeground(Color.GREEN);
        coinsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        coinsLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(10));
        add(coinsLabel);

    }
}
