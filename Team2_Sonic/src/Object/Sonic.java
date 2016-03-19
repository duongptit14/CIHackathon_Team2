package Object;

import java.awt.*;
import Control.*;
/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class Sonic  extends GameObject{
    public static boolean isRun;
    public static int isTop;
    public static int sum = 0;
    public static boolean isDie;
    public static boolean isSuper;
    private Animation runAnimation;
    private Animation jumpAnimation;
    private Animation dieAnimation;
    private Animation superSonicAnimation;
    public Sonic(int positionX, int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
        isRun = true;
        isDie = false;
        isSuper = false;
        isTop = -1;

        runAnimation = new Animation(165, 169, "Resources/Sprite/Sonic/image ", ".png", 80);
        jumpAnimation = new Animation(171, 185, "Resources/Sprite/Sonic/image ", ".png", 80);
        dieAnimation = new Animation(199, 201,"Resources/Sprite/Sonic/image ", ".png", 80 );
        superSonicAnimation = new Animation(222,228,"Resources/Sprite/Sonic/image ", ".png", 80);
    }
    private void move() {
        if(isTop == 0) {
            sum++;
            setPositionY(getPositionY() - 8 + sum/10);
            if(sum >= 30 ) {
                isTop = 1;
                sum = 0;
            }
        }
        if(isTop == 1) setPositionY(getPositionY() + 6 +(sum*2)/10);
        if(getPositionY() >= 475) {
            isTop = -1;
            isRun = true;
        }
    }
    public void reInit() {
        setPositionX(150);
        setPositionY(475);
    }
    private int i = 0;
    @Override
    public void update() {
        if(isSuper) {
            i++;
            if(i >= 600) {
                isSuper = false;
                isDie = false;

                i = 0;
            }
        }
        this.move();
        if(this.getPositionY()<=50) setPositionY(50);
        if(isDie && this.getPositionY() >= 475 && isSuper==false ) GameWindow.isLose = true; //
    }

    @Override
    public void draw(Graphics g) {
        if(isSuper) {
            superSonicAnimation.draw(g,getPositionX(),getPositionY()-30);
            return;
        }
        if(isDie) { //
            dieAnimation.draw(g,getPositionX(),getPositionY());
            return;
        }
        if(isRun) {
            runAnimation.draw(g,getPositionX(),getPositionY());
        }
        else jumpAnimation.draw(g,getPositionX(),getPositionY());
    }


}

