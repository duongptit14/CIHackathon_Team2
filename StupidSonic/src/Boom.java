import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Boom extends Enemy {
    Random random = new Random();
    public Boom() {
        setPositionY(-90);
        setPositionX(600);
        setSpeed(7);
        try {
            setSprite(ImageIO.read(new File(Resources.boom)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkCollistion() {
        Rectangle rectBoom = new Rectangle(this.getPositionX(), this.getPositionY()
                , 70
                , 70);
        Rectangle rectSonic =
                new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                        , SonicManager.getInstance().getStupidSonic().getPositionY()
                        , 60
                        , 70);
        if (rectBoom.intersects(rectSonic)) {
            return true;
        } else return false;
    }

    private void move() {
        setPositionY(getPositionY()+getSpeed());
        setPositionX(getPositionX()-4);
        if( getPositionY() >= 1200) {
            setPositionY(-90);
            setPositionX(80 + random.nextInt(650));
        }
    }
    @Override
    public void update() {
        if(this.checkCollistion()){
            GameWindow.dieSound.loop(2);
            Sonic.isDie = true;
        }
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(),getPositionX(),getPositionY(),null);
    }
}
