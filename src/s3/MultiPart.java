package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import static s3.NewJFrame.jTextArea1;

public class MultiPart implements Runnable {

    String message = null;
    NewJFrame mainFrame;
    public static boolean isRunning = true;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String ObjectKey = null;
    String secret_key = null;
    Thread multipart;
    public static Boolean running = true;

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
    }

    MultiPart(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String AObjectKey) {
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
        List<PartETag> partETags = new ArrayList<PartETag>();
        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucket, ObjectKey);
        InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);

        File partfile = new File(what);
        long contentLength = partfile.length();
        long partSize = 5 * 1024 * 1024; // Set part size to 5 MB.

        try {
            // Step 2: Upload parts.
            long filePosition = 0;
            for (int i = 1; filePosition < contentLength; i++) {
                // Last part can be less than 5 MB. Adjust part size.
                partSize = Math.min(partSize, (contentLength - filePosition));

                // Create request to upload a part.
                UploadPartRequest uploadRequest = new UploadPartRequest()
                        .withBucketName(bucket).withKey(ObjectKey)
                        .withUploadId(initResponse.getUploadId()).withPartNumber(i)
                        .withFileOffset(filePosition)
                        .withFile(file)
                        .withPartSize(partSize);

                // Upload part and add response to our list.
                mainFrame.jTextArea1.append("\nUploading part " + uploadRequest.getPartNumber() + " of: " + ObjectKey);
                calibrate();
                partETags.add(s3Client.uploadPart(uploadRequest).getPartETag());
                filePosition += partSize;
            }

            // Step 3: Complete.
            CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucket,
                    ObjectKey,
                    initResponse.getUploadId(),
                    partETags);

            s3Client.completeMultipartUpload(compRequest);
            mainFrame.jTextArea1.append("\nUploaded object: " + what);
        } catch (Exception e) {
            s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(
                    bucket, ObjectKey, initResponse.getUploadId()));
            jTextArea1.append("\nAn error has occured in MultiPart:");
            mainFrame.calibrateTextArea();
        }

        calibrate();
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String AObjectKey) {

        multipart = new Thread(new MultiPart(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint, AObjectKey));
        multipart.start();
    }

    void stop() {
        multipart.stop();
        mainFrame.jTextArea1.append("\nUpload completed or aborted");
    }

}
