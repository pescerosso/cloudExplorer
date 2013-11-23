/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;

/**
 *
 * @author ptribble
 */
public class S3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        NewJFrame gui = new NewJFrame();
        gui.main(args);

    }
}
