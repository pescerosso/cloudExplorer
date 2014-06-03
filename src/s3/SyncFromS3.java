package s3;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import static s3.NewJFrame.jTextArea1;

public class SyncFromS3 implements Runnable {

    NewJFrame mainFrame;
    String[] objectarray;
    String[] ObjectsConverted;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    public static Boolean running = false;
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

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
    }

    String makeDirectory(String what) {

        if (what.substring(0, 2).contains(":")) {
            what = what.substring(3, what.length());
        }
        if (what.substring(0, 1).contains("/")) {
            what = what.substring(1, what.length());
        }
        if (what.contains("/")) {
            what = what.replace("/", File.separator);
        }

        if (what.contains("\\")) {
            what = what.replace("\\", File.separator);
        }

        int slash_counter = 0;
        int another_counter = 0;

        for (int y = 0; y != what.length(); y++) {
            if (what.substring(y, y + 1).contains(File.separator)) {
                slash_counter++;
                another_counter = y;
            }
        }

        File dir = new File(File.separator + what.substring(0, another_counter));
        dir.mkdirs();
        return what;
    }

    public void run() {
        try {
            File[] foo = new File[objectarray.length];
            for (int i = 1; i != objectarray.length; i++) {
                if (objectarray[i] != null) {

                    foo[i] = new File(destination + File.separator + objectarray[i]);
                    if (foo[i].exists()) {
                        mainFrame.jTextArea1.append("\n" + objectarray[i] + " already exists on this machine.");
                        calibrate();
                    } else {

                        makeDirectory(destination + File.separator + objectarray[i]);
                        String object = makeDirectory(objectarray[i]);
                        if (SyncFromS3.running) {
                            get = new Get(objectarray[i], access_key, secret_key, bucket, endpoint, destination + File.separator + object);
                            get.run();
                        }
                    }

                }
            }

        } catch (Exception SyncLocal) {
            mainFrame.jTextArea1.append("\n" + SyncLocal.getMessage());
        }
    }

    void startc(String[] Aobjectarray, String[] AObjectsConverted, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adestination) {

        if (SyncFromS3.running) {
            syncFromS3 = new Thread(new SyncFromS3(Aobjectarray, AObjectsConverted, Aaccess_key, Asecret_key, Abucket, Aendpoint, Adestination));
            syncFromS3.start();
        }
    }

    void stop() {
        SyncFromS3.running = false;
        syncFromS3.stop();
        syncFromS3.isInterrupted();
        mainFrame.jTextArea1.setText("\nAborted Download\n");
    }
}
