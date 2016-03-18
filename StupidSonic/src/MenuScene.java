import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

public class MenuScene extends Scene {
    public BufferedImage menuImage ;
    public MenuScene() {
        try {
            menuImage = ImageIO.read(new File("Resources/MENU.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(menuImage,0,0,null);
    }

    @Override
    public void update() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_N){
            GameManager.getInstance().stackMenuGame.push(new GamePlayScene());
        }
        else if(e.getKeyCode()== KeyEvent.VK_A) {
            GameManager.getInstance().stackMenuGame.push(new AboutScene());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
