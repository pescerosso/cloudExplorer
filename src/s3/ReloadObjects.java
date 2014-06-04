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

    public ReloadObjects(String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, NewJFrame Frame) {
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        mainFrame = Frame;
    }

    public void run() {

        objectlist = bucketObject.listBucketContents(access_key, secret_key, bucket, endpoint);
        mainFrame.objectarray = objectlist.split("@@");
        mainFrame.previous_objectarray_length = mainFrame.objectarray.length;
    }

    public void startc(String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint) {
        reloadObjects = new Thread(new ReloadObjects(Aaccess_key, Asecret_key, Abucket, Aendpoint, mainFrame));
        reloadObjects.start();
    }

    public void stop() {
        reloadObjects.stop();
    }
}
