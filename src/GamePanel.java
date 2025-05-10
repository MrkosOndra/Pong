import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private Paddle player;
    private Ball ball;
    private Paddle ai;
    private ScoreBoard scoreBoard;

    private int screenWidth;
    private int screenHeight;
    private int direction=0;
    private Timer timer;
    private Timer speedTimer;


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
        int paddleX =screenWidth - screenWidth / 30 - paddleWidth;
        int paddleY = screenHeight / 2 - paddleHeight / 2;
        player = new Paddle(paddleX, paddleY, paddleWidth, paddleHeight);

        int aiX = screenWidth / 30;
        int aiY = screenHeight / 2 - paddleHeight / 2;
        ai = new Paddle(aiX, aiY, paddleWidth, paddleHeight);

        timer = new Timer(10, e -> {
            update();
            repaint();
        });
        timer.start();
        int ballSize = screenWidth / 70;
        int ballX = screenWidth / 2 - ballSize / 2;
        int ballY = screenHeight / 2 - ballSize / 2;
        ball = new Ball(ballX, ballY, ballSize, ballSize);

        speedTimer = new Timer(5000, e -> {
            ball.increaseSpeed();
        });
        speedTimer.start();
        scoreBoard=new ScoreBoard();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        ball.draw(g);
        ai.draw(g);
        scoreBoard.draw(g,screenWidth);
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
        ball.move();
        if(ball.getY()<= 10 || ball.getY() + ball.getHeight() >= screenHeight){
            ball.ReverseYDirection();
        }
        //chat gpt
        if (ball.getX() < player.getX() + player.getWidth() &&
                ball.getX() + ball.getWidth() > player.getX() &&
                ball.getY() < player.getY() + player.getHeight() &&
                ball.getY() + ball.getHeight() > player.getY()) {

            ball.ReverseXDirection();
        }
        if ((ball.getX() < screenWidth/2)&&(ball.getY()<ai.getY())) {
            ai.moveUpAi();
        }
        if (ball.getY() > ai.getY() + ai.getHeight()) {
            ai.moveDownAI(screenHeight);
        }
        if (ball.getX() < ai.getX() + ai.getWidth() &&
                ball.getX() + ball.getWidth() > ai.getX() &&
                ball.getY() < ai.getY() + ai.getHeight() &&
                ball.getY() + ball.getHeight() > ai.getY()) {

            ball.ReverseXDirection();
        }
        if(ball.getX() + ball.getWidth()<0){
            ball.reset(screenWidth,screenHeight,true);
            speedTimer.restart();
            scoreBoard.addPointPlayer();

        }
        if(ball.getX()>screenWidth){
            ball.reset(screenWidth,screenHeight,false);
            speedTimer.restart();
            scoreBoard.addPointAi();
        }
    }
    }

