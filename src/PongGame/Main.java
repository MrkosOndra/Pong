package PongGame;

import PongGame.Panels.GamePanel;
import PongGame.Panels.ModePanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Pong Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ModePanel menu = new ModePanel(window);
        menu.getStartButton().addActionListener(e -> {
            int winscore = menu.getWinscore();
            boolean twoPlayers = menu.isTwoPlayers();

            GamePanel game = new GamePanel(winscore, twoPlayers, window);
            window.setContentPane(game);
            window.revalidate();
            game.requestFocusInWindow();
        });
        window.setContentPane(menu);
        window.setVisible(true);
    }
}