package PongGame.Panels;

import PongGame.Panels.GamePanel;
import PongGame.Panels.ModePanel;

import javax.swing.*;
import java.awt.*;
/**
 * The GameOverOverlay class is responsible for displaying a game over screen
 * with the final score and winner message.
 * It draws a semi-transparent overlay over the game panel and shows
 * relevant information such as who won and the final score.
 */
public class GameOverOverlay extends JPanel {
    private JButton restartButton;
    private JButton menuButton;
    /**
     * Constructs the GameOverOverlay panel.
     *
     * @param parentFrame the main JFrame where the game is displayed
     * @param winscore    the score required to win the game
     * @param twoPlayers  whether the game mode was two-player or vs AI
     */
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
    /**
     * Makes the overlay visible to indicate the game has ended.
     */
    public void showOverlay() {
        setVisible(true);
    }
}
