import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {
    public ShopPanel(Container parentFrame) {
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

        JLabel paddleLabel = new JLabel("Vyber barvu pálky:");
        paddleLabel.setForeground(Color.WHITE);
        paddleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        paddleLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(paddleLabel);

        JPanel paddlePanel = new JPanel();
        paddlePanel.setBackground(Color.BLACK);

        JButton redBtn = new JButton();
        redBtn.setBackground(Color.RED);
        redBtn.setPreferredSize(new Dimension(50, 50));
        redBtn.setFocusPainted(false);

        JButton blueBtn = new JButton();
        blueBtn.setBackground(Color.BLUE);
        blueBtn.setPreferredSize(new Dimension(50, 50));
        blueBtn.setFocusPainted(false);

        JButton greenBtn = new JButton();
        greenBtn.setBackground(Color.GREEN);
        greenBtn.setPreferredSize(new Dimension(50, 50));
        greenBtn.setFocusPainted(false);

        paddlePanel.add(redBtn);
        paddlePanel.add(blueBtn);
        paddlePanel.add(greenBtn);
        add(paddlePanel);

        redBtn.addActionListener(e -> handlePaddleColorSelection(Color.RED, coinsLabel));
        blueBtn.addActionListener(e -> handlePaddleColorSelection(Color.BLUE, coinsLabel));
        greenBtn.addActionListener(e -> handlePaddleColorSelection(Color.GREEN, coinsLabel));

        JButton back = new JButton("Zpět do menu");
        back.addActionListener(e -> {
            ModePanel menu = new ModePanel(null);
            menu.getStartButton().addActionListener(event -> {
                int winScore = menu.getWinscore();
                boolean twoPlayers = menu.isTwoPlayers();
                GamePanel game = new GamePanel(winScore, twoPlayers, (JFrame) parentFrame);
                ((JFrame) parentFrame).setContentPane(game);
                ((JFrame) parentFrame).revalidate();
                game.requestFocusInWindow();
            });
            ((JFrame) parentFrame).setContentPane(menu);
            ((JFrame) parentFrame).revalidate();
        });
        add(back);
    }
    //chat gpt
    private void handleBallSelection(String skinName, JLabel coinsLabel) {
        if (SkinManager.isBallSkinUnlocked(skinName)) {
            SkinManager.selectBallSkin(skinName);
            JOptionPane.showMessageDialog(this, "Používáš skin: " + skinName);
        } else {
            boolean unlockedBall = SkinManager.purchaseBallSkin(skinName);
            if (unlockedBall) {
                JOptionPane.showMessageDialog(this, "Koupil jsi skin: " + skinName);
            } else {
                JOptionPane.showMessageDialog(this, "Nedostatek bodů!");
            }
        }

        coinsLabel.setText("Máš " + SkinManager.getCoins() + " bodů");
    }
    private void handlePaddleColorSelection(Color color, JLabel coinsLabel) {
        if (SkinManager.isPaddleColorUnlocked(color)) {
            SkinManager.purchasePaddleColor(color);
            JOptionPane.showMessageDialog(this, "Používáš novou barvu pálky!");
        } else {
            boolean unlockedPaddle = SkinManager.purchasePaddleColor(color);
            if (unlockedPaddle) {
                JOptionPane.showMessageDialog(this, "Zakoupil jsi novou barvu pálky!");
            } else {
                JOptionPane.showMessageDialog(this, "Nedostatek bodů!");
            }
        }

        coinsLabel.setText("Máš " + SkinManager.getCoins() + " bodů");
    }
}
