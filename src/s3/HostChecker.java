package s3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import static s3.NewJFrame.jTextArea1;

public class HostChecker implements Runnable {

    public static String host;
    NewJFrame mainFrame;

    boolean ping(String address) {
        Boolean host_alive = true;
        try {
            InetAddress s3address = InetAddress.getByName(address);
            if (s3address.isReachable(1000)) {
                host_alive = true;
            } else {
                host_alive = false;
            }
        } catch (Exception ping) {
        }

        return host_alive;
    }

    public HostChecker(String Host, NewJFrame Frame) {
        host = Host;
        mainFrame = Frame;

    }

    public void run() {

        if (host.contains("https")) {
            host = host.replace("https://", "");
        } else {
            host = host.replace("http://", "");
        }

        if (ping(host) || host.contains("amazon")) {
            mainFrame.reloadBuckets();
        } else {
            NewJFrame.jTextArea1.append("\nError: host not found");
        }
    }

    void startc() {
        (new Thread(new HostChecker(host, mainFrame))).start();
    }
}
