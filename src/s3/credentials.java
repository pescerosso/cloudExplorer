/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3;

/**
 *
 * @author ptribble
 */
public class credentials {

    String access_key = null;
    String secret_key = null;
    String end_point = null;
    String bucket = null;
    String region = null;

    public String getRegion() {
        return region;
    }

    public String getBucket() {
        return bucket;
    }

    public String getEndpoint() {
        return end_point;
    }

    public String getAccess_key() {
        return access_key;
    }

    public String getSecret_key() {
        return secret_key;
    }

    void setAccess_key(String what) {
        access_key = what;
    }

    void setSecret_key(String what) {
        secret_key = what;
    }

    void setEndpoint(String what) {
        end_point = what;
    }

    void setBucket(String what) {
        bucket = what;
    }

    void setRegion(String what) {
        region = what;
    }
}
