package Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class Background {
    private BufferedImage background1;
    private BufferedImage background2;
    private BufferedImage botBackground1;
    private BufferedImage botBackground2;
    private int positionXBackground1;
    private int positionXBackground2;

    private int positionXBotBackground1;
    private int positionXBotBackground2;

    private int speedBackground, speedBotBackground;

    public Background() {
        try {
            speedBotBackground = 12;
            speedBackground = 5;
            background1 = ImageIO.read( new File(Resources.background));
            background2 = ImageIO.read(new File(Resources.background));
            botBackground1 = ImageIO.read(new File(Resources.botBackground));
            botBackground2 = ImageIO.read(new File(Resources.botBackground));
        } catch (IOException e) {
            e.printStackTrace();
        }
        positionXBackground1 = 0;
        positionXBackground2 = 1366;
        positionXBotBackground1 = 0;
        positionXBotBackground2 = 1824;
    }
    public void update() {
        if(Sonic.isSuper==false) {
            speedBackground = 5;
            speedBotBackground = 12;
        }
        this.positionXBackground1 -= this.speedBackground;
        if( this.positionXBackground1 <= -background1.getWidth()) this.positionXBackground1 += 2*background1.getWidth();
        this.positionXBackground2 -= this.speedBackground;
        if( this.positionXBackground2 <= -background2.getWidth()) this.positionXBackground2 += 2*background2.getWidth() ;

        this.positionXBotBackground1 -= this.speedBotBackground;
        if(this.positionXBotBackground1 <= -botBackground1.getWidth()) this.positionXBotBackground1 += 2*botBackground1.getWidth();
        this.positionXBotBackground2 -= this.speedBotBackground;
        if(this.positionXBotBackground2 <= -botBackground2.getWidth()) this.positionXBotBackground2 += 2*botBackground2.getWidth();
    }
    public void draw(Graphics g) {
        g.drawImage(background1, positionXBackground1,0,null);
        g.drawImage(background2, positionXBackground2,0,null);
        g.drawImage(botBackground1, positionXBotBackground1,550,null);
        g.drawImage(botBackground2, positionXBotBackground2,550,null);
    }

    public int getSpeedBackground() {
        return speedBackground;
    }

    public void setSpeedBackground(int speedBackground) {
        this.speedBackground = speedBackground;
    }

    public int getSpeedBotBackground() {
        return speedBotBackground;
    }

    public void setSpeedBotBackground(int speedBotBackground) {
        this.speedBotBackground = speedBotBackground;
    }
}

