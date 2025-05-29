package PongGame.Panels;

import PongGame.Panels.ShopPanel;
import PongGame.Panels.StatsPanel;

import javax.swing.*;
import java.awt.*;

public class ModePanel extends JPanel {
    private int winscore=0;
    private boolean twoPlayers;
    private JFrame parentFrame;
    private JButton startButton;
    private JButton button3;
    private JButton button5;
    private JButton button10;
    private JButton button15;
    private JButton twoPlayerButton;
    private JButton aiButton;
    private JButton statsButton;
    private JButton shopButton;

    private JLabel scoreLabel;

    public ModePanel(JFrame parentFrame) {
        setLayout(null);
        setBackground(Color.BLACK);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int centerX = screenWidth / 2;

        JLabel title = new JLabel("PONG", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 52));
        title.setForeground(Color.WHITE);
        title.setBounds(centerX - 200, 50, 400, 60);
        add(title);

        JLabel modeLabel = new JLabel("Zvol herní mód:", SwingConstants.CENTER);
        modeLabel.setForeground(Color.WHITE);
        modeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        modeLabel.setBounds(centerX - 150, 140, 300, 40);
        add(modeLabel);

        aiButton = new JButton("Hráč vs AI");
        aiButton.setFont(new Font("Arial", Font.PLAIN, 24));
        aiButton.setBounds(centerX - 150, 190, 300, 50);
        aiButton.addActionListener(e -> {
            twoPlayers = false;
            aiButton.setBackground(Color.GREEN);
            twoPlayerButton.setBackground(null);
        });
        add(aiButton);


        twoPlayerButton = new JButton("Hráč vs Hráč");
        twoPlayerButton.setFont(new Font("Arial", Font.PLAIN, 24));
        twoPlayerButton.setBounds(centerX - 150, 250, 300, 50);
        twoPlayerButton.addActionListener(e -> {
            twoPlayers = true;
           twoPlayerButton.setBackground(Color.GREEN);
           aiButton.setBackground(null);
        });
        add(twoPlayerButton);

        scoreLabel = new JLabel("Vyber do kolika se hraje:", SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        scoreLabel.setBounds(centerX - 200, 320, 400, 40);
        add(scoreLabel);


        button3 = new JButton("3");
        button5 = new JButton("5");
        button10 = new JButton("10");
        button15 = new JButton("15");

        int buttonWidth = 60;
        int buttonHeight = 40;
        int spacing = 20;
        int startX = centerX - ((buttonWidth + spacing) * 2);

        button3.setBounds(startX, 370, buttonWidth, buttonHeight);
        button5.setBounds(startX + (buttonWidth + spacing), 370, buttonWidth, buttonHeight);
        button10.setBounds(startX + 2 * (buttonWidth + spacing), 370, buttonWidth, buttonHeight);
        button15.setBounds(startX + 3 * (buttonWidth + spacing), 370, buttonWidth, buttonHeight);


        add(button3);
        add(button5);
        add(button10);
        add(button15);

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

        add(button3);
        add(button5);
        add(button10);
        add(button15);


        startButton=new JButton("Spustit hru");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setBounds(centerX - 150, 440, 300, 50);
        add(startButton);

        statsButton = new JButton("Zobraz statistiky");
        statsButton.setFont(new Font("Arial", Font.BOLD, 18));
        statsButton.setBounds(centerX - 150, 510, 300, 45);
        statsButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            StatsPanel statsPanel = new StatsPanel(frame);
            frame.setContentPane(statsPanel);
            frame.revalidate();
        });
        shopButton = new JButton("Obchod");
        shopButton.setFont(new Font("Arial", Font.PLAIN, 18));
        shopButton.setBounds(centerX - 150, 570, 300, 45);
        shopButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            ShopPanel shop = new ShopPanel(frame);
            frame.setContentPane(shop);
            frame.revalidate();
        });
        add(shopButton);
        add(startButton);
        add(statsButton);
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
