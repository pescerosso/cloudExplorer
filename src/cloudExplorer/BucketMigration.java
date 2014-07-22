package cloudExplorer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import static cloudExplorer.NewJFrame.jTextArea1;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import java.io.BufferedReader;
import java.io.FileReader;

public class BucketMigration implements Runnable {

    NewJFrame mainFrame;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    String version = null;
    String bucketlist = null;
    String new_bucket = null;
    String new_access_key = null;
    String new_secret_key = null;
    String new_endpoint = null;
    String new_region = null;
    Thread bucketMigration;
    String Home = System.getProperty("user.home");
    String temp_file = (Home + File.separator + "object.tmp");
    String config_file = (Home + File.separator + "s3Migrate.config");
    Get get;
    Put put;

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
    }

    BucketMigration(String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, NewJFrame AmainFrame) {
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        mainFrame = AmainFrame;
    }

   
    String loadMigrationConfig() {
        String data = null;

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
        return remove_null;

    }

    public void migrate() {

        for (int i = 1; i != mainFrame.objectarray.length; i++) {
            if (mainFrame.objectarray[i] != null) {
                get = new Get(mainFrame.objectarray[i], access_key, secret_key, bucket, endpoint, temp_file, null);
                get.run();
                put = new Put(temp_file, new_access_key, new_secret_key, bucket, new_endpoint, mainFrame.objectarray[i]);
                put.run();
            }
        }

    }

    void loadDestinationAccount() {
        String account = loadMigrationConfig();
        String[] account_array = new String[6];
        try {
            account_array = account.split("@");
            for (int i = 0; i != 6; i++) {
                if (account_array[i] != null) {
                    new_access_key = account_array[0];
                    new_secret_key = account_array[1];
                    new_region = account_array[4];
                    new_endpoint = account_array[2] + ":" + account_array[3];
                }
            }

        } catch (Exception loadconfig) {
        }
    }

    String listBuckets(String access_key, String secret_key, String endpoint) {

        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);
        String[] array = new String[10];

        String bucketlist = null;

        try {

            for (Bucket bucket : s3Client.listBuckets()) {
                bucketlist = bucketlist + " " + bucket.getName();
            }

        } catch (Exception listBucket) {
            mainFrame.jTextArea1.append("\n\nAn error has occurred in listBucket.");
            mainFrame.jTextArea1.append("\n\nError Message:    " + listBucket.getMessage());
        }
        String parse = null;

        if (bucketlist != null) {
            parse = bucketlist.replace("null", "");

        } else {
            parse = "no_bucket_found";
        }

        return parse;
    }

    void checkBucket() {
        ReloadBuckets buckets = new ReloadBuckets(new_access_key, new_secret_key, new_endpoint, null);
        bucketlist = listBuckets(new_access_key, new_secret_key, new_endpoint);

    }

    public void run() {
        File config = new File(config_file);
        if (config.exists()) {
            loadDestinationAccount();
            checkBucket();
            if (bucketlist.contains(bucket)) {
                migrate();
            } else {
                jTextArea1.append("\nError: Destination S3 account does not have the same bucket name as the origin bucket: " + bucket + ".");
                calibrate();
            }

        } else {
            jTextArea1.append("\nError: Migration config file does not exist. Please create one under the Settings tab.");
            calibrate();
        }

    }

    void startc(String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, NewJFrame AmainFrame) {
        bucketMigration = new Thread(new BucketMigration(Aaccess_key, Asecret_key, Abucket, Aendpoint, AmainFrame));
        bucketMigration.start();
    }

    void stop() {
        get.stop();
        mainFrame.jTextArea1.setText("\nDownload completed or aborted.\n");
    }

}
