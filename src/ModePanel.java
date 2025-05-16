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
        setLayout(new GridLayout(7, 1));
        setBackground(Color.BLACK);

        JLabel title = new JLabel("PONG", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        add(title);
        JLabel modeLabel = new JLabel("Zvol herní mód:", SwingConstants.CENTER);
        modeLabel.setForeground(Color.WHITE);
        add(modeLabel);

        aiButton = new JButton("Hráč vs AI");
        aiButton.addActionListener(e -> {
            twoPlayers = false;
            aiButton.setBackground(Color.GREEN);
            twoPlayerButton.setBackground(null);
        });
        add(aiButton);

        twoPlayerButton = new JButton("Hráč vs Hráč");
        twoPlayerButton.addActionListener(e -> {
            twoPlayers = true;
           twoPlayerButton.setBackground(Color.GREEN);
           aiButton.setBackground(null);
        });
        add(twoPlayerButton);

        JLabel scoreLabel = new JLabel("Vyber do kolika se hraje:", SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        add(scoreLabel);

        JPanel scoreButtons = new JPanel();
        scoreButtons.setBackground(Color.BLACK);
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

        startButton=new JButton("Spustit hru");
        add(startButton);
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
