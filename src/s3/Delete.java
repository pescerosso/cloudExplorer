package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import static s3.NewJFrame.jTextArea1;

public class Delete implements Runnable {

    String message = null;
    NewJFrame mainFrame;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    Thread delete;

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
    }

    Delete(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint) {
        what = Awhat;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;

    }

    public void run() {
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);

        try {
            s3Client.deleteObject(new DeleteObjectRequest(bucket, what));
            jTextArea1.append("\nDeleting object: " + what);
            calibrate();
        } catch (Exception Delete) {
            mainFrame.jTextArea1.append("\n\nAn error has occurred in DeleteFile.");
            mainFrame.jTextArea1.append("\n\nError Message:    " + Delete.getMessage());
            message = message + "\n" + Delete.getMessage();
            calibrate();
        }
        calibrate();
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint) {
        (new Thread(new Delete(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint))).start();
    }

    void stop() {
        delete.stop();
        mainFrame.jTextArea1.setText("\nDownload compelted or aborted.\n");
    }

}
