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

public class Get implements Runnable {

    NewJFrame mainFrame;
    boolean isRunning = true;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;

    Get(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adestination) {
        what = Awhat;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        destination = Adestination;
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
        while (isRunning) {
            String message = null;
            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            File file = new File(what);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            message = ("Downloaded object: " + what);

            try {
                S3Object s3object = s3Client.getObject(new GetObjectRequest(bucket, what));
                InputStream objectData = s3object.getObjectContent();
                this.writeFile(objectData, destination);
                mainFrame.jTextArea1.setText("GET:" + what);
                mainFrame.jTextArea1.setCaretPosition(0);
                isRunning = false;
            } catch (Exception get) {
                mainFrame.jTextArea1.append("\n\nAn error has occurred in GET.");
                mainFrame.jTextArea1.append("\n\nError Message:    " + get.getMessage());
                message = message + "\n" + get.getMessage();
            }
            message.replace("null", "");

        }
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adestination) {
        (new Thread(new Get(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint, Adestination))).start();
    }

    void stop() {
        this.isRunning = false;
        mainFrame.jTextArea1.setText("\nAborted Download\n");
    }

       }
