import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Administrator on 3/19/2016.
 */
public class Gift extends Enemy {
    Random random = new Random();
    public Gift() {
        setPositionY(-300);
        setPositionX(650);
        setSpeed(4);
        try {
            setSprite(ImageIO.read(new File(Resources.gift)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkCollistion() {
        Rectangle rectGift = new Rectangle(this.getPositionX(), this.getPositionY()
                , 60
                , 69);
        Rectangle rectSonic =
                new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                        , SonicManager.getInstance().getStupidSonic().getPositionY()
                        , 60
                        , 70);
        if (rectGift.intersects(rectSonic)) {
            return true;
        } else return false;
    }

    private void move() {
        setPositionY(getPositionY()+getSpeed());
        setPositionX(getPositionX()-4);
        if( getPositionY() >= 3500) {
            setPositionY(-150);
            setPositionX(80 + random.nextInt(650));
        }
    }
    @Override
    public void update() {
        if(this.checkCollistion()){
//            setPositionY(-300);
//            setPositionX(600);
            GameWindow.dieSound.loop(4);
            Sonic.isSuper = true;
//            Sonic.isDie = true;
        }
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(),getPositionX(),getPositionY(),null);
    }
}
