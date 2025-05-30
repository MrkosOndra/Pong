package PongGame.Panels;

import PongGame.Entities.Ball;
import PongGame.Entities.Paddle;
import PongGame.Entities.ScoreBoard;
import PongGame.Managers.SkinManager;
import PongGame.Managers.StatsManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * GamePanel handles the core gameplay of Pong.
 * It manages game objects like paddles, ball, score, and game loop.
 */
public class GamePanel extends JPanel implements KeyListener {
    private Paddle player;
    private Ball ball;
    private Paddle ai;
    private ScoreBoard scoreBoard;
    private GameOverOverlay gameOverOverlay;
    JFrame parentFrame;

    private int screenWidth;
    private int screenHeight;
    private int direction = 0;
    private int winscore;
    private Timer timer;
    private Timer speedTimer;
    private boolean gameover = false;
    private int direction2 = 0;
    private boolean twoPlayers;

    /**
     * Constructs a new GamePanel instance.
     *
     * @param winscore   number of points needed to win the game
     * @param twoPlayers true if the game mode is Player vs Player, false if vs AI
     * @param frame      the parent JFrame to allow content switching
     */
    public GamePanel(int winscore, boolean twoPlayers, JFrame frame) {
        this.winscore = winscore;
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setLayout(null);
        this.addKeyListener(this);
        this.twoPlayers = twoPlayers;
        this.parentFrame = frame;

        // chat gpt
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;


        int paddleWidth = screenWidth / 60;
        int paddleHeight = screenHeight / 5;
        int paddleX = screenWidth - screenWidth / 30 - paddleWidth;
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
        scoreBoard = new ScoreBoard();

        ball.reset(screenWidth, screenHeight, true);


        gameOverOverlay = new GameOverOverlay(parentFrame, winscore, twoPlayers);
        gameOverOverlay.setBounds(0, 0, screenWidth, screenHeight);
        this.add(gameOverOverlay);
    }
    /**
     * Paints the game components including paddles, ball, score, and game over message.
     *
     * @param g the Graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        ball.draw(g);
        ai.draw(g);
        scoreBoard.draw(g, screenWidth);
        if (gameover) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 64));

            String winner;
            if (scoreBoard.getPlayerScore() >= winscore) {
                winner = "VYHRÁL HRÁČ!";
            } else {
                if (twoPlayers) {
                    winner = "VYHRÁL HRÁČ2!";
                } else {
                    winner = "VYHRÁLA AI!";
                }
            }

            int textWidth = g.getFontMetrics().stringWidth(winner);
            g.drawString(winner, (screenWidth - textWidth) / 2, screenHeight / 2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    /**
     * Handles key press events to control paddles.
     *
     * @param e the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            direction = -1;
        }
        if (key == KeyEvent.VK_S) {
            direction = 1;
        }
        if (twoPlayers) {
            if (key == KeyEvent.VK_UP) {
                direction2 = -1;
            }
            if (key == KeyEvent.VK_DOWN) {
                direction2 = 1;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    /**
     * Main game update loop. Called regularly by a timer.
     */
    public void update() {
        if (gameover) return;

        updatePlayerMovement();
        updateSecondPlayerMovementOrAI();
        updateBallPosition();
        checkWallCollision();
        checkPaddleCollision();
        checkGoal();
    }
    /** Updates the player paddle position based on input. */
    private void updatePlayerMovement() {
        if (direction == -1) {
            player.moveUp();
        }
        if (direction == 1) {
            player.moveDown(screenHeight);
        }
    }
    /** Updates the second paddle: either player-controlled or AI. */
    private void updateSecondPlayerMovementOrAI() {
        if (twoPlayers) {
            if (direction2 == -1) {
                ai.moveUp();
            }
            if (direction2 == 1) {
                ai.moveDown(screenHeight);
            }
        } else {
            if ((ball.getX() < screenWidth / 2) && (ball.getY() < ai.getY())) {
                ai.moveUpAi();
            }
            if (ball.getY() > ai.getY() + ai.getHeight()) {
                ai.moveDownAI(screenHeight);
            }
        }
    }
    /** Moves the ball according to its current velocity. */
    private void updateBallPosition() {
        ball.move();
    }
    /** Reverses the Y direction if ball hits top or bottom wall. */
    private void checkWallCollision() {
        if (ball.getY() <= 10 || ball.getY() + ball.getHeight() >= screenHeight) {
            ball.ReverseYDirection();
        }
    }
    /** Detects and handles ball collisions with paddles. */
    private void checkPaddleCollision() {
        if (ball.getX() < player.getX() + player.getWidth() &&
                ball.getX() + ball.getWidth() > player.getX() &&
                ball.getY() < player.getY() + player.getHeight() &&
                ball.getY() + ball.getHeight() > player.getY()) {
            ball.ReverseXDirection();
        }
        if (ball.getX() < ai.getX() + ai.getWidth() &&
                ball.getX() + ball.getWidth() > ai.getX() &&
                ball.getY() < ai.getY() + ai.getHeight() &&
                ball.getY() + ball.getHeight() > ai.getY()) {
            ball.ReverseXDirection();
        }
    }
    /**
     * Checks if a goal has been scored and updates the score or ends the game.
     */
    private void checkGoal() {
        if (ball.getX() + ball.getWidth() < 0) {
            scoreBoard.addPointPlayer();
            if (scoreBoard.getPlayerScore() >= winscore) {
                endGame();
            } else {
                ball.reset(screenWidth, screenHeight, false);
                speedTimer.restart();
            }
        }

        if (ball.getX() > screenWidth) {
            scoreBoard.addPointAi();
            if (scoreBoard.getAiScore() >= winscore) {
                endGame();
            } else {
                ball.reset(screenWidth, screenHeight, true);
                speedTimer.restart();
            }
        }
    }
    /**
     * Ends the game, stops timers and displays game over overlay.
     */
    private void endGame() {
        gameover = true;
        timer.stop();
        speedTimer.stop();
        gameOverOverlay.showOverlay();

        boolean player1Won = scoreBoard.getPlayerScore() >= winscore;
        StatsManager.recordMatch(twoPlayers, player1Won, scoreBoard.getPlayerScore(), scoreBoard.getAiScore());
        if (player1Won) {
            SkinManager.addCoins(15);
        }else{
            SkinManager.addCoins(5);
        }
    }
}
