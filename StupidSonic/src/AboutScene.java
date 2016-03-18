import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AboutScene extends Scene {
    BufferedImage about;
    public AboutScene() {
        try {
            about = ImageIO.read(new File("Resources/About.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(about,20,20,null);
    }

    @Override
    public void update() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            GameManager.getInstance().stackMenuGame.pop();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
