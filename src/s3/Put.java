package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import static s3.NewJFrame.jTextArea1;

public class Put implements Runnable {

    String message = null;
    NewJFrame mainFrame;
    public static boolean isRunning = true;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String ObjectKey = null;
    String secret_key = null;
    Thread put;
    public static Boolean running = true;

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
    }

    Put(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String AObjectKey) {
        what = Awhat;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        ObjectKey = AObjectKey;
    }

    public void run() {
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
            mainFrame.jTextArea1.append("\nUploaded object: " + what);
        } catch (Exception put) {
        }

        calibrate();
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String AObjectKey) {

        put = new Thread(new Put(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint, AObjectKey));
        put.start();
        try {
            put.wait();
        } catch (InterruptedException ex) {
        }
    }

    void stop() {
        put.stop();
        mainFrame.jTextArea1.append("\nUpload completed or aborted");
    }

}
