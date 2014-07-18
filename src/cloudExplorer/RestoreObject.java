package cloudExplorer;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import java.io.File;
import static cloudExplorer.NewJFrame.jTextArea1;
import com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class RestoreObject implements Runnable {

    NewJFrame mainFrame;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    Thread restoreobject;

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
    }

    RestoreObject(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint) {
        what = Awhat;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;

    }

    public void run() {
        String message = null;
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        File file = new File(what);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);

        try {
            GetObjectMetadataRequest request = new GetObjectMetadataRequest(bucket, what);
            ObjectMetadata response = s3Client.getObjectMetadata(request);
            response.getOngoingRestore();

            mainFrame.jTextArea1.append("\nRestored operation ran for Object: " + what + ". Please examiene this window for any errors.");
            mainFrame.calibrateTextArea();

        } catch (Exception get) {
            //  mainFrame.jTextArea1.append("\n\nError Message: " + get.getMessage());
        }

        calibrate();
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint) {
        restoreobject = new Thread(new RestoreObject(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint));
        restoreobject.start();
    }

}
