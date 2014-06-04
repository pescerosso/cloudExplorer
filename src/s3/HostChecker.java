package s3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import static s3.NewJFrame.jTextArea1;

public class HostChecker implements Runnable {

    public static String host;
    public static boolean host_alive;

    NewJFrame mainFrame;

    Boolean ping(String address) {
        host_alive = true;
        try {
            InetAddress s3address = InetAddress.getByName(address);
            System.out.print("\nLooking up: " + s3address.isReachable(3000));
        } catch (UnknownHostException e) {
            host_alive = false;
        } catch (IOException e) {
            host_alive = false;
        }
        return host_alive;
    }

    public HostChecker(String Host, NewJFrame Frame) {
        host = Host;
        mainFrame = Frame;

    }

    public void run() {

        if (host.contains("http") || host.contains("https")) {
            if (host.contains("http")) {
                host = host.replace("http://", "");
            } else {
                host = host.replace("https://", "");
            }
        }

        if (ping(host)) {
            mainFrame.bucketLoader();
        } else {
            NewJFrame.jTextArea1.append("\nError: host not found");
        }
    }

    void startc() {
        (new Thread(new HostChecker(host, mainFrame))).start();
    }
}
