package s3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static s3.NewJFrame.jTextArea1;

public class MakeBucket implements Runnable {

    NewJFrame mainFrame;
    public static String response = null;
    public static String region = null;

    public MakeBucket(NewJFrame Frame) {
        mainFrame = Frame;

    }

    public void run() {
        try {

            URL music_url = null;

            final JButton createBucket = new JButton("Create Bucket");
            final JButton close = new JButton("Close");
            final JTextField bucketName = new JTextField();
            final JTextField regionName = new JTextField(mainFrame.cred.getRegion());
            final JLabel name = new JLabel("Bucket Name:");
            createBucket.setBackground(Color.white);
            createBucket.setForeground(Color.blue);
            createBucket.setBorder(null);
            close.setBackground(Color.white);
            close.setBorder(null);
            close.setForeground(Color.blue);

            createBucket.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    if (bucketName.getText().length() < 3) {
                        close.doClick();
                    } else {
                        mainFrame.jTextArea1.append("\n" + mainFrame.bucket.makeBucket(mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), bucketName.getText().toLowerCase(), mainFrame.cred.getEndpoint(), regionName.getText()));
                        close.doClick();
                        mainFrame.reloadBuckets();
                    }
                }
            });

            close.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    mainFrame.jPanel14.removeAll();
                    mainFrame.jPanel14.repaint();
                    mainFrame.jPanel14.revalidate();
                    mainFrame.jPanel14.validate();
                }
            });

            mainFrame.jPanel14.removeAll();
            mainFrame.jPanel14.setLayout(new BoxLayout(mainFrame.jPanel14, BoxLayout.Y_AXIS));
            mainFrame.jPanel14.add(name);
            mainFrame.jPanel14.add(bucketName);
            mainFrame.jPanel14.add(regionName);
            mainFrame.jPanel14.add(createBucket);
            mainFrame.jPanel14.add(close);
            mainFrame.jPanel14.repaint();
            mainFrame.jPanel14.revalidate();
            mainFrame.jPanel14.validate();

        } catch (Exception mp3player) {
            jTextArea1.append("\n" + mp3player.getMessage());
        }
        mainFrame.calibrateTextArea();

    }

    void startc() {
        (new Thread(new MakeBucket(mainFrame))).start();
    }
}
