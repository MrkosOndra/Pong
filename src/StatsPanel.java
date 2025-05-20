import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {
    public StatsPanel(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 16));
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

        JButton backButton = new JButton("Zpět do menu");
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

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
