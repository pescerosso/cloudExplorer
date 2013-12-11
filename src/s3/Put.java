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

public class Put {

    String message = null;
    NewJFrame mainFrame;

    String put(String what, String access_key, String secret_key, String bucket, String endpoint, String ObjectKey) {
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
            message = ("Put object: " + what);
        } catch (Exception put) {
            mainFrame.jTextArea1.append("\n\nAn error has occurred with PUT.");
            mainFrame.jTextArea1.append("\n\nError Message:    " + put.getMessage());
            message = message + put.getMessage();
        }
        message.replace("null", "");
        return message;
    }
}
