package Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import Control.*;
/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class MinhBird extends Enemy {
    Random random = new Random();
    public static Vector<Bullet> vectorBullet ;
    private int count =0;
    public MinhBird() {
        vectorBullet = new Vector<Bullet>();
        setPositionY(200);
        setPositionX(1000);
        setSpeed(8);
        try {
            setSprite(ImageIO.read(new File(Resources.minhBird)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shot() {
        Bullet bullet = new Bullet(getPositionX()+ 10, getPositionY() + 60, 15);
        vectorBullet.add(bullet);

    }
    public boolean checkCollistion() {
        Rectangle rectMinhBird = new Rectangle(this.getPositionX(), this.getPositionY()
                , 70
                , 95);
        Rectangle rectSonic =
                new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                        , SonicManager.getInstance().getStupidSonic().getPositionY()
                        , 60
                        , 70);
        if (rectMinhBird.intersects(rectSonic)) {
            return true;
        } else {
            return false;
        }
    }

    private void move() {

        setPositionX(getPositionX() - getSpeed());
        if (getPositionX() <= -1000) {
            setPositionY(100 + random.nextInt(200));
            setPositionX(random.nextInt(500) + 1500);
        }
    }

    @Override
    public void update() {
        for(Bullet bullet : vectorBullet) {
            bullet.update();
        }
        count++;
        if(count>=60) {
            this.shot();
            count = 0;
        }
        if(this.checkCollistion() && Sonic.isSuper==false){
            GameWindow.dieSound.loop(2);
            Sonic.isDie = true;
        }
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(), getPositionX(), getPositionY(), null);
        for(Bullet bullet : vectorBullet) {
            bullet.draw(g);
        }
    }
}

