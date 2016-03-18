import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 3/19/2016.
 */
public class Bullet extends Enemy {
    public Bullet(int x, int y, int speed) {
        setPositionX(x);
        setPositionY(y);
        setSpeed(speed);
        try {
            setSprite(ImageIO.read(new File(Resources.bullet)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean checkCollistion() {
        Rectangle rectBullet = new Rectangle(this.getPositionX(), this.getPositionY()
                , 30
                , 30);
        Rectangle rectSonic = new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                , SonicManager.getInstance().getStupidSonic().getPositionY()
                , 60
                , 70);

        if (rectBullet.intersects(rectSonic)) {
            return true;
        } else return false;
    }

    public void move() {
        setPositionX(getPositionX() - getSpeed());
    }
    public void update() {
        if(checkCollistion()) {
//            GameWindow.isLose = true;
            GameWindow.dieSound.loop(2);
            Sonic.isDie = true;
        }
        this.move();
    }
    public void draw(Graphics g) {
        g.drawImage(getSprite(), getPositionX(), getPositionY(), null);
    }

}
