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

public class get {

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

    String get(String what, String access_key, String secret_key, String bucket, String endpoint, String destination) {
        String message = null;

        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        File file = new File(what);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);
        message = ("Get object: " + what);
        
        try {
            S3Object s3object = s3Client.getObject(new GetObjectRequest(bucket, what));
            InputStream objectData = s3object.getObjectContent();
            this.writeFile(objectData, destination);
        } catch (Exception get) {
            System.out.print("\n\nAn error has occured in GET.");
            System.out.println("\n\nError Message:    " + get.getMessage());
            message = message + "\n" + get.getMessage();
        }
        message.replace("null", "");
        return message;
    }

}
