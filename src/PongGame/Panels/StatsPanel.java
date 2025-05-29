package PongGame.Panels;

import PongGame.Managers.StatsManager;

import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {
    private JButton backButton;
    private JLabel titleLabel;
    private JTextArea area;
    public StatsPanel(JFrame frame) {
        setLayout(null);
        setBackground(Color.BLACK);

        titleLabel = new JLabel("Statistiky hry:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 20, 300, 40);
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);

        area = new JTextArea();
        area.setEditable(false);
        area.setBounds(50, 70, 300, 150);
        area.setFont(new Font("Monospaced", Font.PLAIN, 24));
        area.setBackground(Color.BLACK);
        area.setForeground(Color.WHITE);
        //chat gpt
        StringBuilder stats = new StringBuilder();
        stats.append("CELKEM HER: ").append(StatsManager.getTotalGames()).append("\n");
        stats.append("VÝHRY Hráč 1: ").append(StatsManager.getPlayer1Wins()).append("\n");
        stats.append("VÝHRY Hráč 2: ").append(StatsManager.getPlayer2Wins()).append("\n");
        stats.append("VÝHRY AI:     ").append(StatsManager.getAiWins()).append("\n\n");
        stats.append("HISTORIE ZÁPASŮ:\n");

        for (String result : StatsManager.getMatchHistory()) {
            stats.append(" - ").append(result).append("\n");
        }

        area.setText(stats.toString());
        add(area);

        backButton = new JButton("Zpět do menu");
        backButton.setBounds(50, 240, 200, 40);
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.addActionListener(e -> {
                ModePanel menu = new ModePanel(null);
                menu.getStartButton().addActionListener(event -> {
                    int winscore = menu.getWinscore();
                boolean twoPlayers = menu.isTwoPlayers();
                GamePanel game = new GamePanel(winscore, twoPlayers, frame);
                frame.setContentPane(game);
                frame.revalidate();
                game.requestFocusInWindow();
            });
            frame.setContentPane(menu);
            frame.revalidate();
        });
        add(backButton);

    }
}
