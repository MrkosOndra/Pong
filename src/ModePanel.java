import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModePanel extends JPanel {
    private int winscore=0;
    private boolean twoPlayers;
    private JButton startButton;
    private JButton button3;
    private JButton button5;
    private JButton button10;
    private JButton button15;
    private JButton twoPlayerButton;

    private JButton aiButton;

    public ModePanel(ActionListener startListener) {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        JLabel title = new JLabel("PONG", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 52));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        add(Box.createVerticalStrut(30));

        JLabel modeLabel = new JLabel("Zvol herní mód:", SwingConstants.CENTER);
        modeLabel.setForeground(Color.WHITE);
        modeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        modeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(modeLabel);

        add(Box.createVerticalStrut(10));

        aiButton = new JButton("Hráč vs AI");
        aiButton.setFont(new Font("Arial", Font.PLAIN, 24));
        aiButton.setMaximumSize(new Dimension(300, 80));
        aiButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        aiButton.addActionListener(e -> {
            twoPlayers = false;
            aiButton.setBackground(Color.GREEN);
            twoPlayerButton.setBackground(null);
        });
        add(aiButton);

        add(Box.createVerticalStrut(10));

        twoPlayerButton = new JButton("Hráč vs Hráč");
        twoPlayerButton.setFont(new Font("Arial", Font.PLAIN, 24));
        twoPlayerButton.setMaximumSize(new Dimension(300, 80));
        twoPlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        twoPlayerButton.addActionListener(e -> {
            twoPlayers = true;
           twoPlayerButton.setBackground(Color.GREEN);
           aiButton.setBackground(null);
        });
        add(twoPlayerButton);

        add(Box.createVerticalStrut(30));

        JLabel scoreLabel = new JLabel("Vyber do kolika se hraje:", SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(scoreLabel);

        add(Box.createVerticalStrut(10));

        JPanel scoreButtons = new JPanel();
        scoreButtons.setBackground(Color.BLACK);
        scoreButtons.setLayout(new FlowLayout());
        button3 = new JButton("3");
        button5 = new JButton("5");
        button10 = new JButton("10");
        button15 = new JButton("15");

        button3.addActionListener(e ->{
            winscore = 3;
            highlightSelectedButton(button3);
        });
        button5.addActionListener(e -> {
            winscore = 5;
            highlightSelectedButton(button5);
        });
        button10.addActionListener(e -> {
            winscore = 10;
            highlightSelectedButton(button10);
        });
        button15.addActionListener(e -> {
            winscore = 15;
            highlightSelectedButton(button15);
        });

        scoreButtons.add(button3);
        scoreButtons.add(button5);
        scoreButtons.add(button10);
        scoreButtons.add(button15);
        add(scoreButtons);
        add(Box.createVerticalStrut(30));

        JPanel bottomButtons = new JPanel();
        bottomButtons.setBackground(Color.BLACK);
        bottomButtons.setLayout(new FlowLayout());

        startButton=new JButton("Spustit hru");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setPreferredSize(new Dimension(250, 80));
        add(startButton);

        JButton statsButton = new JButton("Zobraz statistiky");
        statsButton.setFont(new Font("Arial", Font.BOLD, 18));
        statsButton.setPreferredSize(new Dimension(280, 80));
        statsButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            StatsPanel statsPanel = new StatsPanel(frame);
            frame.setContentPane(statsPanel);
            frame.revalidate();
        });
        JButton shopButton = new JButton("Obchod");
        shopButton.setFont(new Font("Arial", Font.PLAIN, 18));
        shopButton.setPreferredSize(new Dimension(280,80));
        shopButton.addActionListener(e -> {
            ShopPanel shop = new ShopPanel(SwingUtilities.getWindowAncestor(this));
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.setContentPane(shop);
            frame.revalidate();
        });
        bottomButtons.add(shopButton);
        bottomButtons.add(startButton);
        bottomButtons.add(statsButton);
        add(bottomButtons);
    }
    private void highlightSelectedButton(JButton selected) {
        resetButtonStyle(button3);
        resetButtonStyle(button5);
        resetButtonStyle(button10);
        resetButtonStyle(button15);


        selected.setContentAreaFilled(false);
        selected.setOpaque(true);
        selected.setBackground(Color.GREEN);
    }
    private void resetButtonStyle(JButton button) {
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBackground(null);
    }


    public int getWinscore() {
        return winscore;
    }

    public boolean isTwoPlayers() {
        return twoPlayers;
    }

    public JButton getStartButton() {
        return startButton;
    }
}
