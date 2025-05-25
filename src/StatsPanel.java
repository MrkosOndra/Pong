import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {
    public StatsPanel(JFrame frame) {
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);

        JPanel innerPanel = new JPanel(new BorderLayout());
        innerPanel.setPreferredSize(new Dimension(600, 400));
        innerPanel.setBackground(Color.DARK_GRAY);

        JTextArea area = new JTextArea();
        area.setEditable(false);
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
        innerPanel.add(area);

        JButton backButton = new JButton("Zpět do menu");
        backButton.setPreferredSize(new Dimension(160, 35));
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);

        innerPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(innerPanel);
    }
}
