package PongGame.Entities;

import java.awt.*;

public class ScoreBoard {
    private int playerScore;
    private int aiScore;

    public ScoreBoard() {
        this.playerScore = 0;
        this.aiScore = 0;
    }
    public void addPointPlayer(){
        playerScore=playerScore+1;
    }
    public void addPointAi(){
        aiScore=aiScore+1;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getAiScore() {
        return aiScore;
    }
    public void resetScore(){
        playerScore=0;
        aiScore=0;
    }
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