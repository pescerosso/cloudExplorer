package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.File;
import javax.activation.MimetypesFileTypeMap;

public class Put implements Runnable {

    String message = null;
    NewJFrame mainFrame;
    boolean isRunning = true;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String ObjectKey = null;
    String secret_key = null;

    Put(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String AObjectKey) {
        what = Awhat;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        ObjectKey = AObjectKey;
    }

    public void run() {
        while (isRunning) {

            File file = new File(what);
            MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
            String mimeType = mimeTypesMap.getContentType(file);
            mimeType = mimeTypesMap.getContentType(file);
            ObjectMetadata objectMetadata = new ObjectMetadata();

            if ((ObjectKey.contains(".html")) || ObjectKey.contains(".txt")) {
                objectMetadata.setContentType("text/html");
            } else {
                objectMetadata.setContentType(mimeType);
            }

            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            PutObjectRequest putRequest = new PutObjectRequest(bucket, ObjectKey, file);
            putRequest.setMetadata(objectMetadata);

            try {
                PutObjectResult response = s3Client.putObject(putRequest);
                message = ("Uploaded object: " + what);
                mainFrame.jTextArea1.setText(message);
                mainFrame.jTextArea1.setCaretPosition(0);
                this.isRunning = false;
            } catch (Exception put) {
                mainFrame.jTextArea1.append("\n\nAn error has occurred with PUT.");
                mainFrame.jTextArea1.append("\n\nError Message:    " + put.getMessage());
                message = message + put.getMessage();
            }
            message.replace("null", "");

        }
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String AObjectKey) {
        (new Thread(new Put(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint, AObjectKey))).start();
    }

    void stop() {
        this.isRunning = false;
        mainFrame.jTextArea1.setText("\nAborted upload\n");
    }

}
