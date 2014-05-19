package s3;

import java.io.File;

public class Sync implements Runnable {

    NewJFrame mainFrame;
    public static volatile boolean isRunning = true;
    String[] objectarray;
    String[] ObjectsConverted;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    Thread sync;
    Get get;

    Sync(String[] Aobjectarray, String[] AObjectsConverted, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adestination) {
        objectarray = Aobjectarray;
        ObjectsConverted = AObjectsConverted;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        destination = Adestination;
    }

    public void run() {
        try {
            File[] foo = new File[objectarray.length];
            for (int i = 1; i != objectarray.length; i++) {
                if (objectarray[i] != null) {

                    foo[i] = new File(destination + File.separator + ObjectsConverted[i]);
                    if (foo[i].exists()) {
                        mainFrame.jTextArea1.append("\n" + ObjectsConverted[i] + " already exists on this machine.");
                    } else {
                        Get.isRunning = true;
                        get = new Get(objectarray[i], access_key, secret_key, bucket, endpoint, destination + File.separator + ObjectsConverted[i]);
                        get.startc(objectarray[i], access_key, secret_key, bucket, endpoint, destination + File.separator + ObjectsConverted[i]);
                    }

                }
            }

        } catch (Exception SyncLocal) {
            mainFrame.jTextArea1.append("\n" + SyncLocal.getMessage());
        }
    }

    void startc(String[] Aobjectarray, String[] AObjectsConverted, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adestination) {
        sync = new Thread(new Sync(Aobjectarray, AObjectsConverted, Aaccess_key, Asecret_key, Abucket, Aendpoint, Adestination));
        sync.start();
    }

    void stop() {
        Get.isRunning = false;
        sync.isInterrupted();
        mainFrame.jTextArea1.setText("\nAborted Download\n");
    }
}
