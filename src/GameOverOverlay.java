import javax.swing.*;
import java.awt.*;

public class GameOverOverlay extends JPanel {
    private JButton restartButton;
    private JButton menuButton;

    public GameOverOverlay(JFrame parentFrame, int winscore, boolean twoPlayers) {
        setLayout(null);
        setBackground(new Color(0, 0, 0, 150));
        setVisible(false);
        //chatgpt
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        restartButton = new JButton("Hrát znovu");
        restartButton.setBounds(screenWidth / 2 - 150, screenHeight / 2 + 60, 140, 40);
        restartButton.addActionListener(e -> {
            GamePanel newGame = new GamePanel(winscore, twoPlayers, parentFrame);
            parentFrame.setContentPane(newGame);
            parentFrame.revalidate();
            newGame.requestFocusInWindow();
        });

        menuButton = new JButton("Zpět do menu");
        menuButton.setBounds(screenWidth / 2 + 10, screenHeight / 2 + 60, 140, 40);
        //chatgpt
        menuButton.addActionListener(e -> {
            ModePanel menu = new ModePanel(null);
            menu.getStartButton().addActionListener(event -> {
                int newScore = menu.getWinscore();
                boolean newMode = menu.isTwoPlayers();
                GamePanel game = new GamePanel(newScore, newMode, parentFrame);
                parentFrame.setContentPane(game);
                parentFrame.revalidate();
                game.requestFocusInWindow();
            });
            parentFrame.setContentPane(menu);
            parentFrame.revalidate();
        });

        add(restartButton);
        add(menuButton);
    }
    public void showOverlay() {
        setVisible(true);
    }
}
