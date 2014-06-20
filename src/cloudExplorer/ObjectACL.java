package cloudExplorer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static cloudExplorer.NewJFrame.jTextArea1;

public class ObjectACL implements Runnable {

    NewJFrame mainFrame;
    public static String object_acl_change = null;

    public ObjectACL(NewJFrame Frame) {
        mainFrame = Frame;

    }

    public void run() {
        try {

            URL music_url = null;

            final JCheckBox public_box = new JCheckBox("Public");
            final JCheckBox url_box = new JCheckBox("URL Access");
            final JCheckBox private_box = new JCheckBox("Private Access");
            final JButton acl = new JButton("        Commit");

            public_box.setBackground(Color.white);
            public_box.setForeground(Color.blue);
            public_box.setBorder(null);

            url_box.setBackground(Color.white);
            url_box.setBorder(null);
            url_box.setForeground(Color.blue);

            private_box.setBackground(Color.white);
            private_box.setBorder(null);
            private_box.setForeground(Color.blue);

            acl.setBackground(Color.white);
            acl.setBorder(null);
            acl.setForeground(Color.blue);

            acl.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    try {
                        for (int i = 1; i != mainFrame.previous_objectarray_length; i++) {
                            if (mainFrame.object_item[i].isSelected()) {
                                object_acl_change = mainFrame.object_item[i].getText();
                                if (public_box.isSelected()) {
                                    mainFrame.objectacl.setACLpublic(object_acl_change, mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getEndpoint(), mainFrame.cred.getBucket());
                                    jTextArea1.append("\nPublic set for object: " + object_acl_change + "\n");
                                }

                                if (url_box.isSelected()) {
                                    String url = mainFrame.objectacl.setACLurl(object_acl_change, mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getEndpoint(), mainFrame.cred.getBucket());
                                    url = url.replace("Pre-Signed URL = ", "");
                                    String test1[] = url.split("Expires=");
                                    test1[0] = test1[0].replace("?", "");
                                    jTextArea1.append("\n" + test1[0]);
                                }
                                if (private_box.isSelected()) {
                                    mainFrame.objectacl.setACLprivate(object_acl_change, mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getEndpoint(), mainFrame.cred.getBucket());
                                    jTextArea1.append("\nPrivate access set for object: " + object_acl_change + "\n");
                                }
                            }
                        }
                    } catch (Exception ObjectACL) {
                        jTextArea1.append("\n" + ObjectACL.getMessage() + "\n");
                    }

                    mainFrame.jPanel14.removeAll();
                    mainFrame.jPanel14.repaint();
                    mainFrame.jPanel14.revalidate();
                    mainFrame.jPanel14.validate();

                }
            });

            mainFrame.jPanel14.removeAll();
            mainFrame.jPanel14.setLayout(new BoxLayout(mainFrame.jPanel14, BoxLayout.Y_AXIS));
            mainFrame.jPanel14.add(public_box);
            mainFrame.jPanel14.add(url_box);
            mainFrame.jPanel14.add(private_box);
            mainFrame.jPanel14.add(acl);
            mainFrame.jPanel14.repaint();
            mainFrame.jPanel14.revalidate();
            mainFrame.jPanel14.validate();

        } catch (Exception mp3player) {
            jTextArea1.append("\n" + mp3player.getMessage());
        }
        mainFrame.calibrateTextArea();

    }

    void startc() {
        (new Thread(new ObjectACL(mainFrame))).start();
    }
}
