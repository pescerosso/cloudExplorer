package s3;

import java.io.File;

public class SyncFromS3 implements Runnable {

    NewJFrame mainFrame;
    public static volatile boolean isRunning = true;
    String[] objectarray;
    String[] ObjectsConverted;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    Get get;
    Thread syncFromS3;

    SyncFromS3(String[] Aobjectarray, String[] AObjectsConverted, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adestination) {
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
                       // Get.isRunning = true;
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
        syncFromS3 = new Thread(new SyncFromS3(Aobjectarray, AObjectsConverted, Aaccess_key, Asecret_key, Abucket, Aendpoint, Adestination));
        syncFromS3.start();
    }

    void stop() {
        syncFromS3.stop();
        get.stop();
        Get.isRunning = false;
        syncFromS3.isInterrupted();
        mainFrame.jTextArea1.setText("\nAborted Download\n");
    }
}
