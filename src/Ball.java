import java.awt.*;

public class Ball {

    private int x, y;
    private int width, height;
    private int xVelocity, yVelocity;
    private int speed = 5;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        xVelocity= speed;
        yVelocity= speed;
    }
public void move(){
    x += xVelocity;
    y += yVelocity;
}
public void draw(Graphics g){
    g.setColor(Color.WHITE);
    g.fillOval(x, y, width, height);
}
public void ReverseXDirection(){
xVelocity=-xVelocity;
}
public void ReverseYDirection(){
        yVelocity=-yVelocity;
}

}
