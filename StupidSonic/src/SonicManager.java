
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
