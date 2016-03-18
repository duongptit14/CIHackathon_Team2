import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Administrator on 3/14/2016.
 */
public class Animation {
    private Vector<Image> vectorFrame;
    private int countTime;
    private int index;
    private int delta;

    public Animation(int start, int end, String direction, String format, int delta) {
        this.delta = delta;
        countTime = 0;
        vectorFrame = new Vector<Image>();
        index = 0;
        for (int i = start; i <= end; i += 2) {
            String s = String.format(direction + "%d" + format, i);
            try {
                BufferedImage temp = ImageIO.read(new File(s));
                vectorFrame.add(temp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    void draw(Graphics g, int x, int y){
        g.drawImage(vectorFrame.get(index), x, y, null);
        countTime += 17;
        if(countTime >= delta) {
            countTime = 0;
            index++;
            if (index >= vectorFrame.size()) {
                index = 0;
            }
        }
    }
}
