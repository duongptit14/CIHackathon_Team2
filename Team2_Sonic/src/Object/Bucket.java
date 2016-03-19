package Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import Control.*;
/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class Bucket extends Enemy {
    Random random = new Random();
    public Bucket() {

        try {
            setSprite(ImageIO.read(new File(Resources.bucket)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPositionY(479);
        setPositionX(2000);
        setSpeed(6);
    }

    public boolean checkCollistion() {
        Rectangle rectBucket = new Rectangle(this.getPositionX(), this.getPositionY()
                , 58
                , 76);
        Rectangle rectSonic = new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                , SonicManager.getInstance().getStupidSonic().getPositionY()
                , 60
                , 70);

        if (rectBucket.intersects(rectSonic)) {
            return true;
        } else return false;
    }

    private void move() {
        setPositionX(getPositionX() - getSpeed());
        if (getPositionX() <= -300) {
            setPositionX(random.nextInt(500) + 1000);
        }
    }
    @Override
    public void update() {
        if(this.checkCollistion() && Sonic.isSuper==false){
            GameWindow.dieSound.loop(2);
            Sonic.isDie = true;
        }
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(), getPositionX(), getPositionY(), null);
    }
}

