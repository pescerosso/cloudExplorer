package cloudExplorer;

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

    public ReloadBuckets(String Aaccess_key, String Asecret_key, String Aendpoint, NewJFrame Frame) {
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        endpoint = Aendpoint;
        mainFrame = Frame;
    }

    public void run() {
        bucketlist = bucketObject.listBuckets(access_key, secret_key, endpoint);
        mainFrame.bucketarray = bucketlist.split(" ");
        mainFrame.drawBuckets();
        mainFrame.jTabbedPane1.setSelectedIndex(1);
    }

    public void startc(String Aaccess_key, String Asecret_key, String Aendpoint, NewJFrame mainFrame) {
        reloadBuckets = new Thread(new ReloadBuckets(Aaccess_key, Asecret_key, Aendpoint, mainFrame));
        reloadBuckets.start();
    }

    public void stop() {
        reloadBuckets.stop();
    }
}
