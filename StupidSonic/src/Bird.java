import java.awt.*;
import java.util.Random;

public class Bird extends Enemy {
    Random random = new Random();
    private Animation flyAnimation;
    private boolean isCollistion ;
    public Bird() {
        isCollistion = false;
        flyAnimation = new Animation(1, 7, "Resources/Bird/", ".png", 120);
        setPositionY(300);
        setPositionX(1400);
        setSpeed(7);
    }

    public boolean checkCollistion() {
        Rectangle rectBird = new Rectangle(this.getPositionX(), this.getPositionY()
                , 30
                , 30);
        Rectangle rectSonic =
                new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                        , SonicManager.getInstance().getStupidSonic().getPositionY()
                        , 60
                        , 70);
        if (rectBird.intersects(rectSonic)) {
//            isCollistion = true;
            return true;
        } else {
//            isCollistion = false;
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
        if(this.checkCollistion()) {
            isCollistion = true;
        }
        if(isCollistion) {
            setPositionY(getPositionY()+12);
        }
        if(getPositionY() >=700) {
            isCollistion = false;
            setPositionX(-1200);
        }
        if(isCollistion == false) this.move();
    }

    @Override
    public void draw(Graphics g) {
        flyAnimation.draw(g, getPositionX(), getPositionY());
    }
}
