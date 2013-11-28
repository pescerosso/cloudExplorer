package s3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class credentials {

    String access_key = null;
    String secret_key = null;
    String end_point = null;
    String bucket = null;
    String region = null;
    String Home = System.getProperty("user.home");
    String userid = null;
    String groupid = null;
    String OS = System.getProperty("os.name");
    String config_file = (Home + "/s3.config");

    boolean OScheck() {
        boolean result;
        if ((OS.contains("windows")) || OS.contains("Windows")) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public String getRegion() {
        return region;
    }

    public String getBucket() {
        return bucket;
    }

    public String getGROUPID() {
        return groupid;
    }

    public String getUSERID() {
        return userid;
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

    void setGROUPID(String what) {
        groupid = what;
    }

    void setUSERID(String what) {
        userid = what;
    }

    String loadConfig() {
        String data = null;

        if (!OScheck()) {
            config_file = (Home + "\\s3.config");
        }
        try {
            FileReader fr = new FileReader(config_file);
            BufferedReader bfr = new BufferedReader(fr);
            String read = null;

            while ((read = bfr.readLine()) != null) {
                data = data + read;
            }
        } catch (Exception loadConfig) {
        }
        String remove_null = data.replace("null", "");
        String remove_symbol = remove_null.replace("@", " ");
        return remove_symbol;

    }

    String writeConfig(String access_key, String secret_key, String host, String port, String region, String userid, String groupid) {
        try {

            if (!OScheck()) {
                config_file = (Home + "\\s3.config");
            }

            FileWriter fr = new FileWriter(config_file);
            BufferedWriter bfr = new BufferedWriter(fr);
            bfr.write(access_key + "@" + secret_key + "@" + host + "@" + port + "@" + region + "@" + userid + "@" + groupid);
            bfr.close();
        } catch (Exception writeConfig) {
        }
        return "\nSaved Config";
    }
}
