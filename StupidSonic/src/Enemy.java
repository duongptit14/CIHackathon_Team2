import java.awt.*;


public abstract class Enemy extends GameObject {
    private int speed;

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void update() {
    }
    @Override
    public void draw(Graphics g) {
    }
}
