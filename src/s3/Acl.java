package s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import java.net.URL;

public class Acl {

    void setACLpublic(String object, String access_key, String secret_key, String endpoint, String bucket) {
        try {
            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            s3Client.setObjectAcl(bucket, object, CannedAccessControlList.PublicRead);
        } catch (Exception setACLpublic) {
            System.out.print("\nException occured in ACL");
        }
    }

    void setACLprivate(String object, String access_key, String secret_key, String endpoint, String bucket) {
        try {
            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            s3Client.setObjectAcl(bucket, object, CannedAccessControlList.Private);
        } catch (Exception setACLprivate) {
            System.out.print("\nException occured in setACLprivate");
        }
    }

    String viewACL(String object, String access_key, String secret_key, String endpoint, String bucket) {
        String message = null;
        try {
            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            message = s3Client.getObjectAcl(bucket, object).toString();
        } catch (Exception viewACL) {
            System.out.print("\nException occured in viewACL");
        }

        return object + ":     " + message;
    }

    void setBUCKETwebsite(String object, String access_key, String secret_key, String endpoint, String bucket) {
        try {
            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            BucketWebsiteConfiguration bucketWebsiteConfiguration = s3Client.getBucketWebsiteConfiguration(bucket);
            s3Client.setBucketAcl(bucket, CannedAccessControlList.PublicRead);
            s3Client.setBucketWebsiteConfiguration(bucket, new BucketWebsiteConfiguration("index.html", "error.html"));
        } catch (Exception setACLpublic) {
            System.out.print("\nException occured in ACL");
        }
    }

    void removeBUCKETwebsite(String object, String access_key, String secret_key, String endpoint, String bucket) {
        try {
            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            s3Client.deleteBucketWebsiteConfiguration(bucket);
        } catch (Exception removeBUCKETwebsite) {
            System.out.print("\nException occured in ACL");
        }
    }

    String setACLurl(String object, String access_key, String secret_key, String endpoint, String bucket) {
        String URL = null;
        try {
            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            java.util.Date expiration = new java.util.Date();
            long milliSeconds = expiration.getTime();
            milliSeconds += 1000 * 60 * 60; // Add 1 hour.
            expiration.setTime(milliSeconds);
            GeneratePresignedUrlRequest generatePresignedUrlRequest
                    = new GeneratePresignedUrlRequest(bucket, object);
            generatePresignedUrlRequest.setMethod(HttpMethod.GET);
            generatePresignedUrlRequest.setExpiration(expiration);
            URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
            URL = ("Pre-Signed URL = " + url.toString());
        } catch (Exception setACLpublic) {
            System.out.print("\nException occured in ACL");
        }
        return URL;
    }
}
