
package s3;

import static s3.NewJFrame.jTextArea1;

public class thread implements Runnable {

    public static put Put = new put();
    public static String upload = null;
    public static String access_key = null;
    public static String secret_key = null;
    public static String bucket = null;
    public static String endpoint = null;

    @Override
    public void run() {
        Put.put(upload, access_key, secret_key, bucket, endpoint, upload);
          jTextArea1.append("\n\nFinished uploading object: " + thread.upload);
    }

}
