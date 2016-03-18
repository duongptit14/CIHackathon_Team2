/**
 * Created by Administrator on 3/18/2016.
 */
public class BucketManager {
    private Bucket bucket;

    private static BucketManager ourInstance = new BucketManager();

    public static BucketManager getInstance() {
        return ourInstance;
    }

    private BucketManager() {
        bucket = new Bucket();
    }

    public Bucket getBucket() {
        return bucket;
    }
}
