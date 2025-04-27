import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private Paddle player;

    private int screenWidth;
    private int screenHeight;
    private int direction=0;
    private Timer timer;


    public GamePanel() {
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setLayout(null);
        this.addKeyListener(this);

        // chat gpt
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;


        int paddleWidth = screenWidth / 60;
        int paddleHeight = screenHeight / 5;
        int paddleX = screenWidth / 30;
        int paddleY = screenHeight / 2 - paddleHeight / 2;

        player = new Paddle(paddleX, paddleY, paddleWidth, paddleHeight);

        timer = new Timer(10, e -> {
            update();
            repaint();
        });
        timer.start();
    }
//chat gpt

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            direction = -1;
        }
        if (key == KeyEvent.VK_S) {
            direction = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public void update(){
        if (direction == -1) {
            player.moveUp();
        }
        if (direction == 1) {
            player.moveDown(screenHeight);
        }
    }
    }

