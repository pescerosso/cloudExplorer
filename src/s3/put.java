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
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;

/**
 *
 * @author ptribble
 */
public class put {

    void put(String what, String access_key, String secret_key, String bucket, String endpoint, String ObjectKey) {
        File file = new File(what);
        
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);

        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);

        try {
            s3Client.putObject(new PutObjectRequest(bucket, ObjectKey, file));
 
        } catch (Exception put) {
            System.out.print("\n\nAn error has occured with PUT.");
            System.out.println("\n\nError Message:    " + put.getMessage());
           
        }

    }
}
