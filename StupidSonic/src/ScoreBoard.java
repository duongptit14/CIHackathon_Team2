import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ScoreBoard extends GameObject {
    private BufferedImage score0, score1, score2, score3;

    public ScoreBoard(int positionX, int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
    }

    public BufferedImage xuli(int a) {
        String s = "Resources/Number/"+a+".png";
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private void diem() {
        int[] a = {0, 0, 0, 0};
        int score = GamePlayScene.timeRun;
        a[3] = score % 10;
        score /= 10;
        a[2] = score % 10;
        score /= 10;
        a[1] = score % 10;
        score /= 10;
        a[0] = score;
        score0 = xuli(a[0]);
        score1 = xuli(a[1]);
        score2 = xuli(a[2]);
        score3 = xuli(a[3]);
    }
    @Override
    public void update() {
        this.diem();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(score0, getPositionX(), getPositionY(), null);
        g.drawImage(score1, getPositionX()+35, getPositionY(), null);
        g.drawImage(score2, getPositionX()+70, getPositionY(), null);
        g.drawImage(score3, getPositionX()+105, getPositionY(), null);
    }
}
