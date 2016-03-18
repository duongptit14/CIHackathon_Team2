import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePlayScene extends Scene {
    private Background background;
    private Bucket bucket;
    private Crab crab;
    private Bird bird;
    private Poleax poleax;
    private Boom boom;
    private ScoreBoard scoreBoard;

    public static int timeRun = 0;
    private int count = 0;

    public GamePlayScene() {
        crab = new Crab();
        background = new Background();
        bird = new Bird();
        bucket = new Bucket();
        poleax = new Poleax();
        boom = new Boom();
        scoreBoard = new ScoreBoard(600,50);
    }
    @Override
    public void draw(Graphics g) {
        background.draw(g);
        SonicManager.getInstance().getStupidSonic().draw(g);
        bucket.draw(g);
        scoreBoard.draw(g);
        crab.draw(g);
        bird.draw(g);
        poleax.draw(g);
        boom.draw(g);
    }
    public void update() {
        background.update();
        SonicManager.getInstance().getStupidSonic().update();
        bucket.update();
        crab.update();
        bird.update();
        boom.update();
        poleax.update();
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
            crab = new Crab();
            bird = new Bird();
            background = new Background();
            bucket = new Bucket();
            poleax = new Poleax();
            boom = new Boom();
            scoreBoard = new ScoreBoard(600,50);
            SonicManager.getInstance().getStupidSonic().reInit();
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Sonic.isRun = false; // chuyen Animation sang Jump
            Sonic.isTop = 0; // posY--;
            Sonic.sum = 0; // khoi tao sum ve 0
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
