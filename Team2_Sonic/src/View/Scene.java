package View;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public abstract class Scene implements KeyListener {
    public abstract void draw(Graphics g);
    public abstract void update();
}

