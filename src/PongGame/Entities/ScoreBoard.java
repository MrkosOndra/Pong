package PongGame.Entities;

import java.awt.*;
/**
 * Represents the scoreboard displaying the current score of both players.
 */
public class ScoreBoard {
    private int playerScore;
    private int aiScore;
    /**
     * Constructs a new ScoreBoard with both scores initialized to 0.
     */
    public ScoreBoard() {
        this.playerScore = 0;
        this.aiScore = 0;
    }
    /**
     * Increments the score of Player by 1.
     */
    public void addPointPlayer(){
        playerScore=playerScore+1;
    }
    /**
     * Increments the score of Ai by 1.
     */
    public void addPointAi(){
        aiScore=aiScore+1;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getAiScore() {
        return aiScore;
    }

    /**
     * Draws the current scores on the screen.
     *
     * @param g           the Graphics context used to draw
     * @param screenWidth the width of the screen, used to center the score
     */
    public void draw(Graphics g, int screenWidth) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 100));

        String scoreText = aiScore + " : " + playerScore;

        FontMetrics metrics = g.getFontMetrics();
        int textWidth = metrics.stringWidth(scoreText);

        int x = (screenWidth - textWidth) / 2;
        int y = 75;

        g.drawString(scoreText, x, y);
    }

}