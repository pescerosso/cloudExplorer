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
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class get {

    void writeFile(InputStream is, String where) {
        try {
            FileOutputStream fo = new FileOutputStream(where);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = is.read(bytes)) != -1) {
                fo.write(bytes, 0, read);
            }
            fo.close();
        } catch (Exception add) {

        }

    }

    void get(String what, String access_key, String secret_key, String bucket, String endpoint) {
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        File file = new File(what);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);

        try {
            S3Object s3object = s3Client.getObject(new GetObjectRequest(bucket, what));
            InputStream objectData = s3object.getObjectContent();
            this.writeFile(objectData, what);
        } catch (Exception get) {
            System.out.print("\n\nAn error has occured in GET.");
            System.out.println("\n\nError Message:    " + get.getMessage());
            System.out.print("\nDebug: Access key: " + access_key);
            System.out.print("\nDebug: Secret key: " + secret_key);
            System.out.print("\nDebug: key:" + what);
        }

    }

}
