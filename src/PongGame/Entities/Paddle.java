package PongGame.Entities;

import PongGame.Managers.SkinManager;

import java.awt.*;
/**
 * Represents a paddle used by the player.
 */
public class Paddle {
    private int x, y;
    private int width;
    private int height;
    private int speed = 10;
    /**
     * Constructs a new Paddle.
     * @param x the X position
     * @param y the Y position
     * @param width the paddle width
     * @param height the paddle height
     */
    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    /**
     * Draws the paddle.
     * @param g the graphics context
     */
    public void draw(Graphics g){
        g.setColor(SkinManager.getPaddleColor());
        g.fillRect(x, y, width, height);
    }
    /**
     * Moves the paddle up by its speed.
     */
    public void moveUp() {
        y -= speed;
        if (y < 0) y = 0;
    }
    /**
     * Moves the paddle down by its speed, respecting screen height.
     * @param panelHeight the height of the game screen
     */
    public void moveDown(int panelHeight) {
        if (y + height < panelHeight) {
            y += speed;
        }
    }
    /**
     * Moves the AI-controlled paddle up by a fixed amount.
     * Ensures the paddle does not move above the top of the panel.
     */
public void moveUpAi(){
        y=y-10;
        if(y<0){
            y=0;
        }
}
    /**
     * Moves the AI-controlled paddle down by a fixed amount.
     * Ensures the paddle does not move below the bottom of the panel.
     *
     * @param panelHeight the height of the game panel used to limit movement
     */
public void moveDownAI(int panelHeight) {
        if (y + height < panelHeight) {
            y = y + 10;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}

