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
    String File_Destination = Home + "/Desktop/";

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

    String loadConfig() {
        String data = null;
        try {
            FileReader fr = new FileReader(Home + "/s3.config");
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

    String writeConfig(String access_key, String secret_key, String host, String port, String region) {
        try {
            FileWriter fr = new FileWriter(Home + "/s3.config");
            BufferedWriter bfr = new BufferedWriter(fr);
            bfr.write(access_key + "@" + secret_key + "@" + host + "@" + port + "@" + region);
            bfr.close();
        } catch (Exception writeConfig) {
        }
        return "Saved Config";
    }
}
