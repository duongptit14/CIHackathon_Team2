import java.util.Vector;

public class CrabManager {
    private static CrabManager ourInstance = new CrabManager();
    private Crab crab;
    public static CrabManager getInstance() {
        return ourInstance;
    }

    private CrabManager() {
        crab = new Crab();
    }
    public Crab getCrab() {
        return crab;
    }
}
