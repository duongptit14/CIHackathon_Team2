import java.awt.*;


import java.util.Random;

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
        dungduaAnimation = new PoleaxAnimation(0, 4, "Resources/Poleax/Poleax", ".png", 90);
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
    //
//    //riu xoay phai
////    public boolean checkCollistion() {
////        Rectangle rectSonic =
////                new Rectangle2D.Float ((SonicManager.getInstance().getStupidSonic().getPositionX()
////                        , SonicManager.getInstance().getStupidSonic().getPositionY()
////                        ,60
////                        ,70);
////        int temp1 = SonicManager.getInstance().getStupidSonic().getPositionX();
////        int temp2 =  SonicManager.getInstance().getStupidSonic().getPositionY();
////        Rectangle rect = new Rectangle(temp1,temp2,60,70);
////
////        if(line1.intersects(rect)|| line2.intersects(rect)) {
////            return true;
////        } return false;
////
//    boolean check = false;
//    int i=2;
//    int count =0;
//    private void move() {
//       setPositionX(getPositionX() - getSpeed());
//        at = AffineTransform.getTranslateInstance(getPositionX()-getSpeed(), getPositionY());
//        count++;
//        if(count <= 30 ) {
//            at.rotate(Math.toRadians(-i), getSprite().getWidth() / 2, 0);
//        }
//        else if( count > 30 && count <= 90 ) {
//            at.rotate(Math.toRadians(i), getSprite().getWidth() / 2, 0);
//        } else count =-30;
//
////        if (getPositionX() <= -300) {
//////            int x = random.nextInt(3);
//////            if(x==1)
//////            {
//////                try {
//////                    setSprite(ImageIO.read(new File(Resources.poleax1)));
//////                } catch (IOException e) {
//////                    e.printStackTrace();
//////                }
//////                setPositionY(400);
//////                setPositionX(random.nextInt(500) + 2500);
//////            }
//////            else{
//////                try {
//////                    setSprite(ImageIO.read(new File(Resources.poleax2)));
//////                } catch (IOException e) {
//////                    e.printStackTrace();
//////                }
////                setPositionY(-50);
////                setPositionX(random.nextInt(500) + 2500);
////            }
//
//        }
//
//
    private void move() {
        setPositionX(getPositionX() - getSpeed());
        if(getPositionX()<= -500) {
            setPositionX(1500 + random.nextInt(500));
        }
    }


    @Override
    public void update() {
//            count++;
//        if(count <= 30 ) {
//            at.rotate(Math.toRadians(-i), getSprite().getWidth() / 2, 0);
//        }
//        else if( count > 30 && count <= 90 ) {
//            at.rotate(Math.toRadians(i), getSprite().getWidth() / 2, 0);
//        } else count =-30;
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