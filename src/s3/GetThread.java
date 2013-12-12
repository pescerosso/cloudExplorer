package s3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static s3.NewJFrame.jTextArea1;

public class GetThread implements Runnable {

    NewJFrame mainFrame;

    GetThread(NewJFrame frame) {
        mainFrame = frame;
    }

    public void run() {

        final JFrame download = new JFrame("Please choose destination directory.");
        final JPanel downloadPanel = new JPanel();
        final JFileChooser downloadChooser = new JFileChooser();
        downloadChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        final JButton downloadButton = new JButton("OK");

        downloadButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mainFrame.dialog("Please wait for the download operation to complete.");
                if (downloadChooser.getSelectedFile().getAbsolutePath() != null) {
                    File File_Destination = new File(downloadChooser.getSelectedFile().getAbsolutePath());
                    for (int i = 1; i != mainFrame.objectarray.length; i++) {
                        if (mainFrame.d[i] != null) {
                            if (mainFrame.d[i].isSelected()) {
                                download.setVisible(false);
                                String new_object_name = mainFrame.convertObject(mainFrame.d[i].getText(), "download");
                                mainFrame.OScheck();
                                jTextArea1.append("\n" + mainFrame.get.get(mainFrame.d[i].getText(), mainFrame.cred.access_key, mainFrame.cred.getSecret_key(), mainFrame.cred.getBucket(), mainFrame.cred.getEndpoint(), File_Destination.toString() + mainFrame.slash + new_object_name));
                                jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
                                mainFrame.d[i].setSelected(false);
                            }
                        }
                    }
                    mainFrame.dialog.setVisible(false);
                    mainFrame.reloadObjects();
                } else {
                    download.setVisible(false);
                    jTextArea1.append("\nError: destination not specified.");
                }
            }
        });

        downloadPanel.setLayout(new BoxLayout(downloadPanel, BoxLayout.PAGE_AXIS));
        downloadPanel.add(downloadChooser);
        downloadPanel.add(downloadButton);
        download.add(downloadPanel);
        download.setLocation(500, 500);
        download.pack();
        try {
            for (int i = 1; i != mainFrame.objectarray.length; i++) {
                if (mainFrame.d[i] != null) {
                    if (mainFrame.d[i].isSelected()) {
                        download.setVisible(true);
                    }
                }
            }
        } catch (Exception GetThreadRUN) {
        }
    }

}
