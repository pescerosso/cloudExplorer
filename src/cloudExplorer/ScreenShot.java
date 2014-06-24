package cloudExplorer;

import static cloudExplorer.NewJFrame.jTextArea1;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class ScreenShot implements Runnable {

    Thread screenshot;
    String message = null;
    NewJFrame mainFrame;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String ObjectKey = null;
    String secret_key = null;
    Put put;

    public ScreenShot(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String AObjectKey, NewJFrame Aframe) {
        what = Awhat;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        ObjectKey = AObjectKey;
        mainFrame = Aframe;
    }

    void calibrateTextArea() {
        jTextArea1.append("\n");
        try {
            jTextArea1.setCaretPosition(jTextArea1.getLineStartOffset(jTextArea1.getLineCount() - 1));
        } catch (Exception e) {

        }
    }

    public void run() {
        try {
            File screenshot_file = new File(mainFrame.Home + File.separator + "screenshot.s3");
            Random rand = new Random(System.currentTimeMillis());
            int random = rand.nextInt(256);
            String random_name = "Screenshot-" + random;
            long t1 = System.currentTimeMillis();
            long diff = 0;
            while (diff < 5000) {
                long t2 = System.currentTimeMillis();
                diff = t2 - t1;
            }
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRectangle = new Rectangle(screenSize);
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);
            ImageIO.write(image, "png", new File(screenshot_file.getAbsolutePath()));
            mainFrame.jTextArea1.append("\nCreated Screen Shot.");
            put = new Put(screenshot_file.getAbsolutePath(), mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getBucket(), mainFrame.cred.getEndpoint(), random_name);
            put.startc(screenshot_file.getAbsolutePath(), mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getBucket(), mainFrame.cred.getEndpoint(), random_name);
        } catch (Exception screenShot) {

        }
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, String AObjectKey, NewJFrame Aframe) {

        screenshot = new Thread(new ScreenShot(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint, AObjectKey, Aframe));
        screenshot.start();
    }
}
