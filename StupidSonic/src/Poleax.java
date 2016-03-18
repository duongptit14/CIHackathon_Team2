import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Poleax extends Enemy{
    Random random = new Random();
    Animation dungduaAnimation;
    public Poleax() {

//        try {
//            setSprite(ImageIO.read(new File(Resources.poleax2)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        dungduaAnimation = new Animation(0,4,"Resources/Poleax/Poleax",".png",90);
        setPositionY(-50);
        setPositionX(3000);
        setSpeed(6);
    }

    public boolean checkCollistion() {
        Rectangle rect1 = new Rectangle(this.getPositionX()+82, this.getPositionY()+54
                , 13
                , 242);
        Rectangle rect2 = new Rectangle(this.getPositionX(), this.getPositionY()+310
                , 360
                , 50);

        Rectangle rectSonic =
                new Rectangle(SonicManager.getInstance().getStupidSonic().getPositionX()
                        , SonicManager.getInstance().getStupidSonic().getPositionY()
                        ,60
                        ,70);
        if (rect1.intersects(rectSonic)||rect2.intersects(rectSonic)) {
            return true;
        }else return false;
    }
    private void move() {
        setPositionX(getPositionX() - getSpeed());
        if (getPositionX() <= -300) {
            int x = random.nextInt(3);
            if(x==1)
            {
                try {
                    setSprite(ImageIO.read(new File(Resources.poleax1)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setPositionY(400);
                setPositionX(random.nextInt(500) + 2500);
            }
            else{
                try {
                    setSprite(ImageIO.read(new File(Resources.poleax2)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setPositionY(-50);
                setPositionX(random.nextInt(500) + 2500);
            }

        }
    }

    @Override
    public void update() {
        if(this.checkCollistion()){
            GameWindow.isLose = true;
        }
        this.move();
    }

    @Override
    public void draw(Graphics g) {
//        g.drawImage(getSprite(), getPositionX(), getPositionY(), null);
        dungduaAnimation.draw(g,getPositionX(),getPositionY());
    }
}
