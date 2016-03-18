/**
 * Created by Administrator on 3/17/2016.
 */
public class BirdManager {
    private Bird bird;
    private static BirdManager ourInstance = new BirdManager();

    public static BirdManager getInstance() {
        return ourInstance;
    }

    private BirdManager() {
        bird = new Bird();
    }
    public Bird getBird() {
        return bird;
    }
}
