import java.awt.*;
import java.awt.event.KeyListener;

public abstract class Scene implements KeyListener{
    public abstract void draw(Graphics g);
    public abstract void update();
}
