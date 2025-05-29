package PongGame.Entities;

import PongGame.Managers.SkinManager;

import java.awt.*;

public class Ball {
    private Color color;

    private int x, y;
    private int width, height;
    private int xVelocity, yVelocity;
    private int speed = 5;
    private int maxSpeed=15;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color= SkinManager.getBallColor();

        xVelocity= speed;
        yVelocity= speed;
    }
public void move(){
    x += xVelocity;
    y += yVelocity;
}
public void draw(Graphics g){
    g.setColor(color);
    g.fillOval(x, y, width, height);
}
public void ReverseXDirection(){
xVelocity=-xVelocity;
}
public void ReverseYDirection(){
        yVelocity=-yVelocity;
}
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
