package cloudExplorer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static cloudExplorer.NewJFrame.jTextArea1;

public class MakeDestinationBucket implements Runnable {

    NewJFrame mainFrame;
    public static String response = null;
    public static String region = null;
    public static String dest_bucket = null;

    public MakeDestinationBucket(NewJFrame Frame) {
        mainFrame = Frame;

    }

    public void run() {
        try {

            final JButton createBucket = new JButton("Start Bucket Migration");
            final JButton close = new JButton("Close");
            final JLabel blank = new JLabel(" ");
            final JLabel blank2 = new JLabel(" ");
            final JTextField bucketName = new JTextField();
            final JLabel name = new JLabel("Destination Bucket Name:");
            name.setBackground(Color.white);
            name.setForeground(Color.blue);
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
                        BucketMigration migrate = new BucketMigration(mainFrame.cred.access_key, mainFrame.cred.getSecret_key(), mainFrame.cred.getBucket(), mainFrame.cred.getEndpoint(), mainFrame, bucketName.getText());
                        migrate.startc(mainFrame.cred.access_key, mainFrame.cred.getSecret_key(), mainFrame.cred.getBucket(), mainFrame.cred.getEndpoint(), mainFrame, bucketName.getText());
                        close.doClick();
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
            mainFrame.jPanel14.add(blank);
            mainFrame.jPanel14.add(createBucket);
            mainFrame.jPanel14.add(blank2);
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
        (new Thread(new MakeDestinationBucket(mainFrame))).start();
    }
}
