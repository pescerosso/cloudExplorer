package s3;

public class ReloadObjects implements Runnable {

    Thread reloadObjects;
    NewJFrame mainFrame;
    BucketClass bucketObject = new BucketClass();
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String ObjectKey = null;
    String secret_key = null;
    String objectlist = null;

    public String objectlist() {
        return objectlist;
    }

    public ReloadObjects(String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint) {
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
    }

    public void run() {
        mainFrame.object_thread_status = true;
        objectlist = bucketObject.listBucketContents(access_key, secret_key, bucket, endpoint);
        mainFrame.object_thread_status = false;
    }

    public void startc(String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint) {
        reloadObjects = new Thread(new ReloadObjects(Aaccess_key, Asecret_key, Abucket, Aendpoint));
        reloadObjects.start();
    }

    public void stop() {
        reloadObjects.stop();
    }
}
