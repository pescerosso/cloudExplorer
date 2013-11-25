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
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.Permission;

/**
 *
 * @author ptribble
 */
public class acl {

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
        } catch (Exception setACLpublic) {
            System.out.print("\nException occured in ACL");
        }
    }
}
