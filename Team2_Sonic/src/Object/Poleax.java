package Object;

import java.awt.*;
import java.util.Random;
import Control.*;
/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class Poleax extends Enemy{
    Random random = new Random();
    //    AffineTransform at;
    PoleaxAnimation dungduaAnimation;
    public Poleax() {
////        at.rotate(Math.toRadians(45));
////        at.scale(2,2);
////       at = AffineTransform.getTranslateInstance(getPositionX(),getPositionY());
        setPositionY(-50);
        setPositionX(1500);
        setSpeed(6);
//        try {
//            setSprite(ImageIO.read(new File(Resources.poleax2)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        dungduaAnimation = new PoleaxAnimation(0, 4, "Resources/Sprite/Poleax/Poleax", ".png", 90);
    }
    //
//    }
    //riu thang va cham chuan
    public boolean checkCollistion() {
        Rectangle rectSonic =
                new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                        , SonicManager.getInstance().getStupidSonic().getPositionY()
                        ,60
                        ,70);
        Rectangle rec1 = new Rectangle(this.getPositionX()+82, this.getPositionY()+54
                , 13
                , 242);
        Rectangle rec2 = new Rectangle(this.getPositionX(), this.getPositionY()+310
                , 360
                , 50);
        if(rectSonic.intersects(rec1)|| rectSonic.intersects(rec2)) {
            return true;
        } return false;
    }

    private void move() {
        setPositionX(getPositionX() - getSpeed());
        if(getPositionX()<= -500) {
            setPositionX(1500 + random.nextInt(500));
        }
    }


    @Override
    public void update() {
        if(this.checkCollistion()&& Sonic.isSuper==false){
            GameWindow.dieSound.loop(2);
            Sonic.isDie = true;
        }
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        dungduaAnimation.draw(g, getPositionX(), getPositionY());
    }
}
