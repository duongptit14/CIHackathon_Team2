package View;

import java.awt.*;
import java.awt.event.KeyEvent;
import Object.*;
import Control.*;
/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class GamePlayScene extends Scene {
    private Background background;
    private Bucket bucket;
    private Crab crab;
    private Bird bird;
    private Poleax poleax;
    private Boom boom;
    private ScoreBoard scoreBoard;
    private MinhBird minhBird;
    private Gift gift;
    public static int timeRun = 0;
    private int count = 0;

    public GamePlayScene() {
        gift = new Gift();
//        crab = new Crab();
        background = new Background();
        bird = new Bird();
        bucket = new Bucket();
        poleax = new Poleax();
        boom = new Boom();
        minhBird = new MinhBird();
        scoreBoard = new ScoreBoard(600,50);
    }
    @Override
    public void draw(Graphics g) {

        background.draw(g);
        SonicManager.getInstance().getStupidSonic().draw(g);
        bucket.draw(g);
        scoreBoard.draw(g);
//        crab.draw(g);
        bird.draw(g);
        poleax.draw(g);
        boom.draw(g);
        minhBird.draw(g);
        gift.draw(g);
    }
    public void update() {
        background.update();
        SonicManager.getInstance().getStupidSonic().update();
        bucket.update();
//        crab.update();
        bird.update();
        boom.update();
        poleax.update();
        minhBird.update();
        gift.update();
        count++;
        if (count == 5) {
            GamePlayScene.timeRun++;
            count = 0;
            scoreBoard.update();
        }
        if(GameWindow.isLose) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameWindow.isLose = false;
            GameManager.getInstance().stackMenuGame.push(new ScoreBoardScene());
//            crab = new Crab();
            bird = new Bird();
            background = new Background();
            bucket = new Bucket();
            poleax = new Poleax();
            gift = new Gift();
            MinhBird.vectorBullet.clear();
            boom = new Boom();
            minhBird = new MinhBird();
            scoreBoard = new ScoreBoard(600,50);
            SonicManager.getInstance().getStupidSonic().reInit();
            Sonic.isDie = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_B) {
            GameManager.getInstance().stackMenuGame.pop();
        }
        if (Sonic.isDie == false && e.getKeyCode() == KeyEvent.VK_SPACE) {
            Sonic.isRun = false; // chuyen Animation sang Jump
            Sonic.isTop = 0; // posY--;
            Sonic.sum = 0; // khoi tao sum ve 0
        }
        if(e.getKeyCode()==KeyEvent.VK_F && Sonic.isSuper ) {
            background.setSpeedBackground(15);
            background.setSpeedBotBackground(25);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        if(e.getKeyCode() == KeyEvent.VK_F && Sonic.isSuper) {
//            background.setSpeedBackground(1);
//            background.setSpeedBotBackground(8);
//        }
    }
}

