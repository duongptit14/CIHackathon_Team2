package Object;

/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {
    private int positionX;
    private int positionY;
    private BufferedImage sprite;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public abstract void update();
    public abstract void draw(Graphics g);
}

