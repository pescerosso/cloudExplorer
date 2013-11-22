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
        credentials Cred = new credentials();
        Cred.setAccess_key("1696dffa32015a5782fe");
        Cred.setSecret_key("6uzntS3cAgUkDQkzmtGoFzQOmVB57KjJGc+koJ8N");
        Cred.setEndpoint("http://s3.linux-toys.com:18080");
        Cred.setBucket("test");
        //   get Get = new get();
        //  Get.get("/tmp/text.txt", Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint());
        // put Put = new put();
        // Put.put("/tmp/text.txt", Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint());
        // delete Del = new delete();
        //Del.deleteFile("/tmp/text.txt", Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint());
        // Del.deleteBucket(Cred.getAccess_key(), Cred.getSecret_key(), Cred.getBucket(), Cred.getEndpoint());

    }
}
