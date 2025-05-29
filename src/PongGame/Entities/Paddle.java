package PongGame.Entities;

import PongGame.Managers.SkinManager;

import java.awt.*;

public class Paddle {
    private int x, y;
    private int width;
    private int height;
    private int speed = 10;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(Graphics g){
        g.setColor(SkinManager.getPaddleColor());
        g.fillRect(x, y, width, height);
    }
    public void moveUp() {
        y -= speed;
        if (y < 0) y = 0;
    }

    public void moveDown(int panelHeight) {
        if (y + height < panelHeight) {
            y += speed;
        }
    }
public void moveUpAi(){
        y=y-10;
        if(y<0){
            y=0;
        }
}
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

