package s3;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import static s3.NewJFrame.jTextArea1;

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

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
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
        String[] extensions = new String[]{" "};
        List<File> files = (List<File>) FileUtils.listFiles(location, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        for (File file_found : files) {
            int found = 0;

            for (int y = 1; y != objectarray.length; y++) {
                if (objectarray[y].contains(file_found.getAbsolutePath().toString())) {
                    mainFrame.jTextArea1.append("\nObject already exists on S3: " + file_found);
                    calibrate();
                    found++;
                }
            }

            if (found == 0) {
                if (this.isRunning) {
                    put = new Put(file_found.getAbsolutePath().toString(), access_key, secret_key, bucket, endpoint, file_found.getAbsolutePath().toString());
                    put.run();
                    found = 0;

                }
            }
        }
    }
        void startc
        (File location, String Aaccess_key
        , String Asecret_key, String Abucket
        , String Aendpoint, String[] Aobjectarray
    
            ) {
        (new Thread(new SyncToS3(location, Aaccess_key, Asecret_key, Abucket, Aendpoint, Aobjectarray))).start();
        }

        void stop
        
            () {
        this.isRunning = false;
            mainFrame.jTextArea1.setText("\nUpload complete or aborted.\n");
        }

    }
