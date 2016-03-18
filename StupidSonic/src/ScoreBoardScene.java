import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScoreBoardScene extends Scene {
    private ScoreBoard scoreBoard;
    private BufferedImage gameOverImage;
    public ScoreBoardScene() {
        scoreBoard = new ScoreBoard(350,460);
        try {
            gameOverImage = ImageIO.read(new File("Resources/game over.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(gameOverImage,0,0,null);
        scoreBoard.draw(g);
    }

    @Override
    public void update() {
        scoreBoard.update();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_B) {
            GamePlayScene.timeRun = 0;
            GameManager.getInstance().stackMenuGame.pop();
        }
        else if( e.getKeyCode() == KeyEvent.VK_ESCAPE ) {
            GamePlayScene.timeRun = 0;
            GameManager.getInstance().stackMenuGame.pop();
            GameManager.getInstance().stackMenuGame.pop();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
