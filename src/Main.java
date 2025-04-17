import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window=new JFrame("Pong Game");
        GamePanel GamePanel = new GamePanel();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(GamePanel);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(false);
        window.setVisible(true);
    }
}