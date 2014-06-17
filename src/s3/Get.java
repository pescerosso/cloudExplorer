package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static s3.NewJFrame.jTextArea1;

public class Get implements Runnable {

    NewJFrame mainFrame;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    String version = null;
    Thread get;

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
    }

    Get(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adestination, String Aversion) {
        what = Awhat;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        destination = Adestination;
        version = Aversion;
    }

    void writeFile(InputStream is, String destination) {
        try {
            FileOutputStream fo = new FileOutputStream(destination);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = is.read(bytes)) != -1) {
                fo.write(bytes, 0, read);
            }
            fo.close();
        } catch (Exception add) {
        }

    }

    public void run() {
        String message = null;
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        File file = new File(what);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);

        try {
            long t1 = System.currentTimeMillis();
            S3Object s3object = s3Client.getObject(new GetObjectRequest(bucket, what, version));
            InputStream objectData = s3object.getObjectContent();
            this.writeFile(objectData, destination);
            long t2 = System.currentTimeMillis();
            long diff = t2 - t1;
            mainFrame.jTextArea1.append("\nDownloaded: " + what + " in " + diff / 100 + " second(s).");
            mainFrame.calibrateTextArea();

        } catch (Exception get) {
            //mainFrame.jTextArea1.append("\n\nAn error has occurred in GET.");
            //mainFrame.jTextArea1.append("\n\nError Message: " + get.getMessage());
            //message = message + "\n" + get.getMessage();
        }

        calibrate();
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adestination, String Aversion) {
        get = new Thread(new Get(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint, Adestination, Aversion));
        get.start();
    }

    void stop() {
        get.stop();
        mainFrame.jTextArea1.setText("\nDownload completed or aborted.\n");
    }

}
