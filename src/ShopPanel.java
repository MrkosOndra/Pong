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

        add(Box.createVerticalStrut(30));

        JLabel ballLabel = new JLabel("Vyber míček:");
        ballLabel.setForeground(Color.WHITE);
        ballLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ballLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(ballLabel);

        JPanel ballPanel = new JPanel();
        ballPanel.setBackground(Color.BLACK);

        JButton footballBtn = new JButton(new ImageIcon());
        JButton volleyballBtn = new JButton(new ImageIcon());
        JButton tennisBtn = new JButton(new ImageIcon());

        footballBtn.addActionListener(e -> handleBallSelection ("football", coinsLabel));
        volleyballBtn.addActionListener(e -> handleBallSelection("volleyball", coinsLabel));
        tennisBtn.addActionListener(e -> handleBallSelection("tennis", coinsLabel));

        ballPanel.add(footballBtn);
        ballPanel.add(volleyballBtn);
        ballPanel.add(tennisBtn);

        add(ballPanel);

        add(Box.createVerticalStrut(30));

    }
    //chat gpt
    private void handleBallSelection(String skinName, JLabel coinsLabel) {
        if (SkinManager.isBallSkinUnlocked(skinName)) {
            SkinManager.selectBallSkin(skinName);
            JOptionPane.showMessageDialog(this, "Používáš skin: " + skinName);
        } else {
            boolean unlocked = SkinManager.purchaseBallSkin(skinName);
            if (unlocked) {
                JOptionPane.showMessageDialog(this, "Koupil jsi skin: " + skinName);
            } else {
                JOptionPane.showMessageDialog(this, "Nedostatek bodů!");
            }
        }

        coinsLabel.setText("Máš " + SkinManager.getCoins() + " bodů");
    }
}
