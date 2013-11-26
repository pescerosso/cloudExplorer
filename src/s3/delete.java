package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;

public class delete {

    String message = null;

    String deleteFile(String what, String access_key, String secret_key, String bucket, String endpoint) {
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);

        try {
            s3Client.deleteObject(new DeleteObjectRequest(bucket, what));
            message = ("Deleting object: " + what);
        } catch (Exception Delete) {
            System.out.print("\n\nAn error has occured in DeleteFile.");
            System.out.println("\n\nError Message:    " + Delete.getMessage());
            message = message + "\n" + Delete.getMessage();
        }
        message.replace("null", "");
        return message;
    }
}
