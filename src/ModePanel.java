import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModePanel extends JPanel {
    private int winscore=0;
    private boolean twoPlayers;
    private JButton startButton;

    public ModePanel(ActionListener startListener) {
        setLayout(new GridLayout(6, 1));
        setBackground(Color.BLACK);

        JLabel title = new JLabel("PONG", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        add(title);
        JLabel modeLabel = new JLabel("Zvol herní mód:", SwingConstants.CENTER);
        modeLabel.setForeground(Color.WHITE);
        add(modeLabel);

        JButton aiButton = new JButton("Hráč vs AI");
        aiButton.addActionListener(e -> {
            twoPlayers = false;
        });
        add(aiButton);

        JButton twoPlayerButton = new JButton("Hráč vs Hráč");
        twoPlayerButton.addActionListener(e -> {
            twoPlayers = true;
        });
        add(twoPlayerButton);

        JLabel scoreLabel = new JLabel("Vyber do kolika se hraje:", SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        add(scoreLabel);

        JPanel scoreButtons = new JPanel();
        scoreButtons.setBackground(Color.BLACK);
        JButton button3 = new JButton("3");
        JButton button5 = new JButton("5");
        JButton button10 = new JButton("10");
        JButton button15 = new JButton("15");

        button3.addActionListener(e -> winscore = 3);
        button5.addActionListener(e -> winscore = 5);
        button10.addActionListener(e -> winscore = 10);
        button15.addActionListener(e -> winscore = 15);

        scoreButtons.add(button3);
        scoreButtons.add(button5);
        scoreButtons.add(button10);
        scoreButtons.add(button15);
        add(scoreButtons);

        startButton=new JButton("Spustit hru");
        add(startButton);
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
