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

    NewJFrame foo;

    GetThread(NewJFrame bar) {
        foo = bar;
    }

    public void run() {

        final JFrame download = new JFrame("Please choose destination directory.");
        final JPanel downloadPanel = new JPanel();
        final JFileChooser downloadChooser = new JFileChooser();
        downloadChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        final JButton downloadButton = new JButton("OK");

        downloadButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                foo.dialog("Please wait for the download operation to complete.");
                if (downloadChooser.getSelectedFile().getAbsolutePath() != null) {
                    File File_Destination = new File(downloadChooser.getSelectedFile().getAbsolutePath());
                    for (int i = 1; i != foo.objectarray.length; i++) {
                        if (foo.d[i] != null) {
                            if (foo.d[i].isSelected()) {
                                download.setVisible(false);
                                String new_object_name = foo.convertObject(foo.d[i].getText(), "download");
                                foo.OScheck();
                                jTextArea1.append("\n" + foo.Get.get(foo.d[i].getText(), foo.Cred.access_key, foo.Cred.getSecret_key(), foo.Cred.getBucket(), foo.Cred.getEndpoint(), File_Destination.toString() + foo.slash + new_object_name));
                                jTextArea1.setCaretPosition(jTextArea1.getSelectionEnd());
                                foo.dialog.setVisible(false);
                                foo.d[i].setSelected(false);
                            }
                        }
                    }
                    foo.reloadObjects(1);
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
        for (int i = 1; i != foo.objectarray.length; i++) {
            if (foo.d[i] != null) {
                if (foo.d[i].isSelected()) {
                    download.setVisible(true);
                }
            }
        }
    }

}
