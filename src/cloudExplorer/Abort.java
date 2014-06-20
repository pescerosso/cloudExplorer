package cloudExplorer;

public class Abort implements Runnable {

    Thread abort;
    NewJFrame mainFrame;
    BucketClass bucketObject = new BucketClass();
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String ObjectKey = null;
    String secret_key = null;
    String objectlist = null;
    SyncToS3 SyncToS3;
    SyncFromS3 SyncFromS3;
    String operation = null;

    public String objectlist() {
        return objectlist;
    }

    public Abort(String what) {
        operation = what;
    }

    public void run() {

        if (operation.contains("To")) {
            SyncToS3.running = false;
            SyncToS3.stop();
        }
        if (operation.contains("From")) {
            SyncFromS3.running = false;
            SyncFromS3.stop();
        }
    }

    public void startc(String operation) {
        abort = new Thread(new Abort(operation));
        abort.start();
    }

    public void stop() {
        abort.stop();
    }
}
