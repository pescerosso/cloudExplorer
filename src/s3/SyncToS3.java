package s3;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SyncToS3 implements Runnable {

    NewJFrame mainFrame;
    public static volatile boolean isRunning = true;
    String[] objectarray;
    String[] ObjectsConverted;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    File location;
    Get get;
    Thread syncToS3;
    Put put;

    SyncToS3(File Alocation, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String[] Aobjectarray) {
        objectarray = Aobjectarray;
        location = Alocation;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;

    }

    String convertObject(String what, String operation) {

        if (what.contains("/")) {
            what = what.replace("/", File.separator);
        }

        if (what.contains("\\")) {
            what = what.replace("\\", File.separator);
        }

        int count = 0;
        int slash_counter = 0;
        String out_file = null;
        int another_counter = 0;

        for (int y = 0; y != what.length(); y++) {
            if (what.substring(y, y + 1).contains(File.separator)) {
                slash_counter++;
                another_counter = y;
            }
        }

        for (int y = 0; y != what.length(); y++) {
            if (y == another_counter) {
                if (operation.contains("download")) {
                    if (what.contains(File.separator)) {
                        out_file = (what.substring(y, what.length()));
                    } else {
                        out_file = (what);
                    }
                } else {
                    out_file = (what.substring(y + 1, what.length()));
                }
            }
        }
        return out_file;
    }

    public void run() {
        File[] files = location.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {

            } else {
                String simple_what = convertObject(file.getAbsolutePath(), "upload");

                int found = 0;

                for (int y = 1; y != objectarray.length; y++) {
                    if (objectarray[y].contains(simple_what)) {
                        mainFrame.jTextArea1.append("\nObject already exists on S3: " + simple_what);
                        found++;
                    }
                }

                if (found == 0) {
                    if (this.isRunning) {
                        put = new Put(file.getAbsolutePath(), access_key, secret_key, bucket, endpoint, simple_what);
                        put.run();
                        found = 0;
                    }
                }
            }
        }
    }

    void startc(File location, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String[] Aobjectarray
    ) {
        (new Thread(new SyncToS3(location, Aaccess_key, Asecret_key, Abucket, Aendpoint, Aobjectarray))).start();
    }

    void stop() {
        this.isRunning = false;
        mainFrame.jTextArea1.setText("\nUpload complete or aborted.\n");
    }

}
