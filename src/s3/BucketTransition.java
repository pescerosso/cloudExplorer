package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Transition;
import java.util.ArrayList;
import java.util.List;
import static s3.NewJFrame.jTextArea1;

public class BucketTransition implements Runnable {

    NewJFrame mainFrame;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    String version = null;
    Thread transition;
    String days;
    String prefix = null;
    Boolean disabled = false;

    public void calibrate() {
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {
        }
    }

    BucketTransition(String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adays, String Aprefix, Boolean Adisabled) {

        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        days = Adays;
        prefix = Aprefix;
        disabled = Adisabled;
    }

    public void run() {
        AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
        AmazonS3 s3Client = new AmazonS3Client(credentials);
        s3Client.setEndpoint(endpoint);
        int converted_days = 0;
        if (!disabled) {
            converted_days = Integer.parseInt(days);
        }
        BucketLifecycleConfiguration.Rule ruleArchiveAndExpire = null;
        if (!disabled) {
            ruleArchiveAndExpire = new BucketLifecycleConfiguration.Rule()
                    .withPrefix(prefix)
                    .withExpirationInDays(converted_days)
                    .withStatus(BucketLifecycleConfiguration.ENABLED.toString());
        } else {
            ruleArchiveAndExpire = new BucketLifecycleConfiguration.Rule()
                    .withPrefix(prefix)
                    .withExpirationInDays(100)
                    .withStatus(BucketLifecycleConfiguration.DISABLED.toString());
        }
        List<BucketLifecycleConfiguration.Rule> rules = new ArrayList<BucketLifecycleConfiguration.Rule>();
        rules.add(ruleArchiveAndExpire);

        try {
            BucketLifecycleConfiguration configuration = new BucketLifecycleConfiguration()
                    .withRules(rules);
            s3Client.setBucketLifecycleConfiguration(bucket, configuration);
        } catch (Exception get) {
            mainFrame.jTextArea1.append("\n" + get.getMessage());
        }
        if (!disabled) {
            mainFrame.jTextArea1.append("\nSent request to change bucket life cycle to " + converted_days + " day(s).");
        } else {
            mainFrame.jTextArea1.append("\nSent request to disable the bucket life");
        }
        calibrate();
    }

    void startc(String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String Adays, String Aprefix, Boolean Adisabled) {
        transition = new Thread(new BucketTransition(Aaccess_key, Asecret_key, Abucket, Aendpoint, Adays, Aprefix, Adisabled));
        transition.start();
    }

    void stop() {
        transition.stop();
        mainFrame.jTextArea1.setText("\nDownload completed or aborted.\n");
    }

}
