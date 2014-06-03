package s3;

public class ReloadBuckets implements Runnable {

    Thread reloadBuckets;
    NewJFrame mainFrame;
    BucketClass bucketObject = new BucketClass();
    String what = null;
    String access_key = null;
    String endpoint = null;
    String secret_key = null;
    String bucketlist = null;

    public String bucketlist() {
        return bucketlist;
    }

    public ReloadBuckets(String Aaccess_key, String Asecret_key, String Aendpoint) {
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        endpoint = Aendpoint;
    }

    public void run() {
        NewJFrame.bucket_thread_status = true;
        if (NewJFrame.bucket_thread_status) {
            bucketlist = bucketObject.listBuckets(access_key, secret_key, endpoint);
        }
        NewJFrame.bucket_thread_status = false;
    }

    public void startc(String Aaccess_key, String Asecret_key, String Aendpoint) {
        reloadBuckets = new Thread(new ReloadBuckets(Aaccess_key, Asecret_key, Aendpoint));
        reloadBuckets.start();
    }

    public void stop() {
        reloadBuckets.stop();
    }
}
