import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {
    private JLabel title;
    private JButton backButton;
    private JLabel coinsLabel;
    private JLabel ballLabel;
    private JLabel paddleLabel;
    private JButton  footballBtn;
    private JButton volleyballBtn;
    private JButton tennisBtn;
    private JButton redBtn;
    private JButton blueBtn;
    private JButton greenBtn;
    private JButton back;

    public ShopPanel(JFrame parentFrame) {
        setLayout(null);
        setBackground(Color.BLACK);

        title = new JLabel("OBCHOD");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        title.setBounds(300, 20, 300, 40);
        add(Box.createVerticalStrut(20));
        add(title);


        coinsLabel = new JLabel("Máš " + SkinManager.getCoins() + " coinu");
        coinsLabel.setForeground(Color.GREEN);
        coinsLabel.setBounds(50, 30, 200, 30);
        coinsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(Box.createVerticalStrut(10));
        add(coinsLabel);

        add(Box.createVerticalStrut(30));

        ballLabel = new JLabel("Vyber barvu míčku(cena 20 coinu:");
        ballLabel.setForeground(Color.WHITE);
        ballLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ballLabel.setBounds(50, 130, 200, 30);
        add(ballLabel);

        JButton redBall = new JButton();
        redBall.setBackground(Color.RED);
        redBall.setBounds(50, 170, 50, 50);
        redBall.addActionListener(e -> handleBallColorSelection(Color.RED, coinsLabel));
        add(redBall);

        JButton greenBall = new JButton();
        greenBall.setBackground(Color.GREEN);
        greenBall.setBounds(110, 170, 50, 50);
        greenBall.addActionListener(e -> handleBallColorSelection(Color.GREEN, coinsLabel));
        add(greenBall);

        JButton yellowBall = new JButton();
        yellowBall.setBackground(Color.YELLOW);
        yellowBall.setBounds(170, 170, 50, 50);
        yellowBall.addActionListener(e -> handleBallColorSelection(Color.YELLOW, coinsLabel));
        add(yellowBall);




        paddleLabel = new JLabel("Vyber barvu pálky(cena 20 coinu):");
        paddleLabel.setForeground(Color.WHITE);
        paddleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        paddleLabel.setBounds(50, 230, 200, 30);
        add(paddleLabel);


        redBtn = new JButton();
        redBtn.setBackground(Color.RED);
        redBtn.setBounds(50, 270, 50, 50);
        redBtn.setFocusPainted(false);
        redBtn.addActionListener(e -> handlePaddleColorSelection(Color.RED, coinsLabel));
        add(redBtn);

        blueBtn = new JButton();
        blueBtn.setBackground(Color.BLUE);
        blueBtn.setBounds(110, 270, 50, 50);
        blueBtn.setFocusPainted(false);
        blueBtn.addActionListener(e -> handlePaddleColorSelection(Color.BLUE, coinsLabel));
        add(blueBtn);

        greenBtn = new JButton();
        greenBtn.setBackground(Color.GREEN);
        blueBtn.setBounds(110, 270, 50, 50);
        greenBtn.setFocusPainted(false);
        greenBtn.addActionListener(e -> handlePaddleColorSelection(Color.GREEN, coinsLabel));
        add(greenBtn);

        back = new JButton("Zpět do menu");
        back.setBounds(50, 350, 150, 40);
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
    private void handleBallColorSelection(Color color, JLabel coinsLabel) {
        if (SkinManager.isBallColorUnlocked(color)) {
            SkinManager.selectBallColor(color);
            JOptionPane.showMessageDialog(this, "Používáš novou barvu míčku!");
        } else {
            boolean success = SkinManager.purchaseBallColor(color);
            if (success) {
                JOptionPane.showMessageDialog(this, "Zakoupil jsi novou barvu micku");
            } else {
                JOptionPane.showMessageDialog(this, "Nedostatek bodu!");
            }
            coinsLabel.setText("Máš " + SkinManager.getCoins() + " coinu");
        }
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
                JOptionPane.showMessageDialog(this, "Nedostatek bodu!");
            }
        }

        coinsLabel.setText("Máš " + SkinManager.getCoins() + " bodů");
    }
}
