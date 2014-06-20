package cloudExplorer;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import cloudExplorer.Get;
import cloudExplorer.NewJFrame;

public class ShowVersions implements Runnable {

    NewJFrame mainFrame;
    String what = null;
    String access_key = null;
    String bucket = null;
    String endpoint = null;
    String secret_key = null;
    String destination = null;
    String version = null;
    Thread showVersions;

    ShowVersions(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, NewJFrame Frame) {
        what = Awhat;
        access_key = Aaccess_key;
        secret_key = Asecret_key;
        bucket = Abucket;
        endpoint = Aendpoint;
        mainFrame = Frame;
    }

    public void run() {
        String foo = null;
        mainFrame.versioning_id = new ArrayList<>();
        mainFrame.versioning_name = new ArrayList<>();
        mainFrame.versioning_date = new ArrayList<>();

        Versioning version = new Versioning(mainFrame);
        version.getVersions(what, access_key, secret_key, bucket, endpoint);

        mainFrame.jPanel11.removeAll();
        mainFrame.jPanel11.revalidate();
        mainFrame.jPanel11.setLayout(new BoxLayout(mainFrame.jPanel11, BoxLayout.PAGE_AXIS));
        mainFrame.jPanel11.setLayout(new BoxLayout(mainFrame.jPanel11, BoxLayout.Y_AXIS));
        int i = 0;

        for (String what : mainFrame.versioning_id) {
            if (what != null) {
                mainFrame.object_item[i] = new JRadioButton();
                mainFrame.object_item[i].setText(mainFrame.versioning_name.get(i) + "     " + mainFrame.versioning_date.get(i));
                mainFrame.object_item[i].setBackground(Color.white);
                mainFrame.object_item[i].setForeground(Color.blue);
                mainFrame.jPanel11.add(mainFrame.object_item[i]);
                mainFrame.versionDownload = true;
            }
            i++;
        }

        mainFrame.jPanel11.setLayout(new BoxLayout(mainFrame.jPanel11, BoxLayout.Y_AXIS));
        mainFrame.jPanel11.repaint();
        mainFrame.jPanel11.revalidate();
        mainFrame.jPanel11.validate();
        System.gc();
    }

    void startc(String Awhat, String Aaccess_key, String Asecret_key, String Abucket, String Aendpoint, NewJFrame Frame) {
        showVersions = new Thread(new ShowVersions(Awhat, Aaccess_key, Asecret_key, Abucket, Aendpoint, Frame));
        showVersions.start();
    }

    void stop() {
        showVersions.stop();
        mainFrame.jTextArea1.setText("\nDownload completed or aborted.\n");
    }

}
