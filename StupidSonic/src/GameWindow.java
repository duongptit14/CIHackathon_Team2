

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameWindow extends Frame implements Runnable {
    public static boolean isLose = false;
    Graphics seconds;
    Image image;
    private static Clip backgroudSound;
    public static Clip dieSound;
    public GameWindow() {
        JVSound jvSound = new JVSound();
        backgroudSound = jvSound.playWAV("Resources/menu-music-game.wav");
        backgroudSound.loop(20);
        JVSound dieJVSound = new JVSound();
        dieSound = dieJVSound.playWAV("Resources/cartoon004.wav");
        GameManager.getInstance().stackMenuGame.push(new MenuScene());

        this.setTitle("TechKids - code the change");
        this.setSize(800, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                GameManager.getInstance().stackMenuGame.peek().keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    @Override

    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image, 0, 0, null);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        GameManager.getInstance().stackMenuGame.peek().draw(g);
    }

    @Override
    public void run() {

        while(true) {
            GameManager.getInstance().stackMenuGame.peek().update();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}