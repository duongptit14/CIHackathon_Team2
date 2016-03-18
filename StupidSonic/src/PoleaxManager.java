
public class PoleaxManager {
    private Poleax poleax;

    private static PoleaxManager ourInstance = new PoleaxManager();

    public static PoleaxManager getInstance() {
        return ourInstance;
    }

    private PoleaxManager() {
        poleax = new Poleax();
    }

    public Poleax getPoleax() {
        return poleax;
    }
}
