package Object;

import java.awt.*;

/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
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