/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.io.File;
import java.util.List;

/**
 *
 * @author ptribble
 */
public class bucket {

    String objectlist = null;

    void makeBucket(String access_key, String secret_key, String bucket, String endpoint, String region) {
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);
        try {
            s3Client.createBucket(new CreateBucketRequest(bucket, region));

        } catch (Exception Delete) {
            System.out.print("\n\nAn error has occured in makeBucket.");
            System.out.println("\n\nError Message:    " + Delete.getMessage());
            System.out.print("\nDebug: Access key: " + access_key);
            System.out.print("\nDebug: Secret key: " + secret_key);
        }

    }

    String listBuckets(String access_key, String secret_key, String endpoint) {
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);
        String[] array = new String[10];

        String bucketlist = null;

        int i = 0;
        try {

            for (Bucket bucket : s3Client.listBuckets()) {
                bucketlist = bucketlist + " "  + bucket.getName();

            }
        } catch (Exception listBucket) {
            System.out.print("\n\nAn error has occured in listBucket.");
            System.out.println("\n\nError Message:    " + listBucket.getMessage());
        }
        String parse = null;
        
        if (bucketlist != null) {
            parse = bucketlist.replace("null", "");

        } else {
            parse = "no_bucket_found";
        }

        return parse;
    }

    String listBucketContents(String access_key, String secret_key, String bucket, String endpoint) {
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);
        objectlist = null;
        try {
            ObjectListing current = s3Client.listObjects((bucket));
            for (S3ObjectSummary objectSummary : current.getObjectSummaries()) {
                objectlist = objectlist + " " +  objectSummary.getKey();
            }

        } catch (Exception listBucket) {
            System.out.print("\n\nAn error has occured in listBucketContents.");
            System.out.println("\n\nError Message:    " + listBucket.getMessage());
        }

        String parse = null;

        if (objectlist != null) {
            parse = objectlist.replace("null", "");
        } else {
            parse = "no_objects_found";
        }
        return parse;
    }

    void deleteBucket(String access_key, String secret_key, String bucket, String endpoint, String region) {
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);

        try {
            s3Client.deleteBucket(new DeleteBucketRequest(bucket));
        } catch (Exception Delete) {
            System.out.print("\n\nAn error has occured in DeleteBucket.");
            System.out.println("\n\nError Message:    " + Delete.getMessage());
        }
    }
}
