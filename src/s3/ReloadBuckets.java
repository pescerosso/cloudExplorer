package s3;

public class ReloadBuckets implements Runnable {

    Thread reloadBuckets;
    NewJFrame mainFrame;
    BucketClass bucketObject = new BucketClass();
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String ObjectKey = null;
    String secret_key = null;
    String bucketlist = null;

    public String objectlist() {
        return bucketlist;
    }

    public ReloadBuckets(String Aaccess_key, String Asecret_key, String Aendpoint) {
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        endpoint = Aendpoint;
    }

    public void run() {
        bucketlist = bucketObject.listBuckets(access_key, secret_key, endpoint);
    }

    public void startc(String Aaccess_key, String Asecret_key, String Aendpoint) {
        reloadBuckets = new Thread(new ReloadBuckets(Aaccess_key, Asecret_key, Aendpoint));
        reloadBuckets.start();
    }

    public void stop() {
        reloadBuckets.stop();
    }
}
