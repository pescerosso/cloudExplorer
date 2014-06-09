package s3;

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
import static s3.NewJFrame.jTextArea1;

public class BucketACL implements Runnable {

    NewJFrame mainFrame;
    public static String object_acl_change = null;

    public BucketACL(NewJFrame Frame) {
        mainFrame = Frame;

    }

    public void run() {
        try {

            URL music_url = null;

            final JCheckBox static_website = new JCheckBox("Static Website");
            final JButton bucketACLbutton = new JButton("        Commit");

            static_website.setBackground(Color.white);
            static_website.setBorder(null);
            static_website.setForeground(Color.blue);

            bucketACLbutton.setBackground(Color.white);
            bucketACLbutton.setBorder(null);
            bucketACLbutton.setForeground(Color.blue);

            bucketACLbutton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    try {
                        if (static_website.isSelected()) {
                            mainFrame.objectacl.setBUCKETwebsite(object_acl_change, mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getEndpoint(), mainFrame.cred.getBucket());
                            jTextArea1.append("\nWebsite access enabled.\n");
                        } else {
                            mainFrame.objectacl.removeBUCKETwebsite(object_acl_change, mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getEndpoint(), mainFrame.cred.getBucket());
                            jTextArea1.append("\nBucket is no longer serving a website.\n");

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
            mainFrame.jPanel14.add(static_website);
            mainFrame.jPanel14.add(bucketACLbutton);
            mainFrame.jPanel14.repaint();
            mainFrame.jPanel14.revalidate();
            mainFrame.jPanel14.validate();

        } catch (Exception mp3player) {
            jTextArea1.append("\n" + mp3player.getMessage());
        }
        mainFrame.calibrateTextArea();

    }

    void startc() {
        (new Thread(new BucketACL(mainFrame))).start();
    }
}
