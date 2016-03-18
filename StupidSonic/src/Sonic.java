import java.awt.*;

public class Sonic  extends GameObject{
    public static boolean isRun;
    public static int isTop;
    public static int sum = 0;
    public static boolean isDie;
    private Animation runAnimation;
    private Animation jumpAnimation;
    private Animation dieAnimation;

    public Sonic(int positionX, int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
        isRun = true;
        isDie = false;
        isTop = -1;

        runAnimation = new Animation(165, 169, "Resources/Sonic/image ", ".png", 80);
        jumpAnimation = new Animation(171, 185, "Resources/Sonic/image ", ".png", 80);
        dieAnimation = new Animation(199, 201,"Resources/Sonic/image ", ".png", 80 );
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
    @Override
    public void update() {
        this.move();
        if(this.getPositionY()<=50) setPositionY(50);
        if(isDie && this.getPositionY() >= 475 ) GameWindow.isLose = true; //
    }

    @Override
    public void draw(Graphics g) {
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
