package Control;

/**
 * Created by DuongPTIT14 on 3/19/2016.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new GameWindow());
        thread.start();
    }
}
