package Control;
import Object.*;
/**
 * Created by DuongPTIT14 on 3/19/2016.
 */

public class SonicManager {
    private static SonicManager ourInstance = new SonicManager();
    private Sonic stupidSonic;

    private SonicManager() {
        stupidSonic = new Sonic(150,475);
    }
    public static SonicManager getInstance() {
        return ourInstance;
    }
    public Sonic getStupidSonic() {
        return stupidSonic;
    }
}

