package Object;

import java.awt.*;
import java.util.Random;
import Control.*;
/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class Crab  extends  Enemy{
    Random random = new Random();
    private Animation runAnimation;

    public Crab() {
        runAnimation = new Animation(20, 26, "Resources/Sprite/Crab/image ", ".png", 80);
        setPositionY(520);
        setPositionX(1000);
        setSpeed(7);
    }

    public boolean checkCollistion() {
        Rectangle rectCrab = new Rectangle(this.getPositionX(), this.getPositionY()
                , 50
                , 41);
        Rectangle rectSonic =
                new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                        , SonicManager.getInstance().getStupidSonic().getPositionY()
                        , 60
                        , 70);
        if (rectCrab.intersects(rectSonic)) {
            return true;
        } else return false;
    }

    private void move() {
        setPositionX(getPositionX() - getSpeed());
        if (getPositionX() <= -800) {
            setPositionX(random.nextInt(500)+2000 );
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
        runAnimation.draw(g, getPositionX(), getPositionY());
    }
}

