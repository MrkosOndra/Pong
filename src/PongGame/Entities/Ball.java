package PongGame.Entities;

import PongGame.Managers.SkinManager;

import java.awt.*;
/**
 * Represents the ball used in the Pong game.
 */
public class Ball {
    private Color color;

    private int x, y;
    private int width, height;
    private int xVelocity, yVelocity;
    private int speed = 5;
    private int maxSpeed=15;

    /**
     * Constructs a new Ball with specified position and size.
     *
     * @param x      the initial x position of the ball
     * @param y      the initial y position of the ball
     * @param width  the width of the ball
     * @param height the height of the ball
     */
    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color= SkinManager.getBallColor();

        xVelocity= speed;
        yVelocity= speed;
    }

    /**
     * Moves the ball by updating its position based on current velocity.
     */
public void move(){
    x += xVelocity;
    y += yVelocity;
}
    /**
     * Draws the ball on the screen.
     *
     * @param g the Graphics object to draw with
     */
public void draw(Graphics g){
    g.setColor(color);
    g.fillOval(x, y, width, height);
}
    /**
     * Reverses the ball's horizontal direction.
     */
public void ReverseXDirection(){
xVelocity=-xVelocity;
}
    /**
     * Reverses the ball's vertical direction.
     */
public void ReverseYDirection(){
        yVelocity=-yVelocity;
}
    /**
     * Resets the ball to the center of the screen and sets its direction.
     *
     * @param screenWidth   width of the game screen
     * @param screenHeight  height of the game screen
     * @param TowardsPlayer true if the ball should move towards the player, false otherwise
     */
public void reset(int screenWidth , int screenHeight , boolean TowardsPlayer){
        x=screenWidth / 2 - width / 2;
        y=screenWidth / 2 - height / 2;
    resetSpeed();
        if(TowardsPlayer){
            xVelocity= -speed;
        }else{
            xVelocity = speed;
        }
    yVelocity = (Math.random() < 0.5) ? speed : -speed;
}
    /**
     * Increases the ball's speed, up to the defined maximum speed.
     */
    public void increaseSpeed() {
        if (xVelocity > 0 && xVelocity < maxSpeed) {
            xVelocity = xVelocity + 1;
        } else if (xVelocity < 0 && xVelocity > -maxSpeed) {
            xVelocity = xVelocity - 1;
        }

        if (yVelocity > 0 && yVelocity < maxSpeed) {
            yVelocity = yVelocity + 1;
        } else if (yVelocity < 0 && yVelocity > -maxSpeed) {
            yVelocity = yVelocity - 1;
        }
    }
    /**
     * Resets the ball's speed to its default starting value.
     */
public void resetSpeed(){
        speed=5;
}
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public int getSpeed() {
        return speed;
    }
}
