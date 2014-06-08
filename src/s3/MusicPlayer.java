package s3;

import jaco.mp3.player.MP3Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static s3.NewJFrame.jTextArea1;

public class MusicPlayer implements Runnable {

    NewJFrame mainFrame;

    public MusicPlayer(NewJFrame Frame) {
        mainFrame = Frame;

    }

    public void run() {
        try {

            // temp_file = (Home + File.separator + "object.tmp");
            URL music_url = null;

            final MP3Player mp3 = new MP3Player();
            final JFrame musicFrame = new JFrame("Music Player");
            final JPanel musicPanel = new JPanel();
            final JButton stopMusic = new JButton("Stop Music");
            final JButton replayMusic = new JButton("Play/Replay");
            final JButton forwardMusic = new JButton("Forward");
            final JButton backwardMusic = new JButton("Backward");
            final JButton closeMusic = new JButton("Close");

            forwardMusic.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    mp3.skipForward();
                }
            });

            backwardMusic.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    mp3.skipBackward();
                }
            });

            stopMusic.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    mp3.stop();
                }
            });
            replayMusic.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    mp3.stop();
                    mp3.play();
                }
            });
            closeMusic.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    mp3.stop();
                    musicFrame.setVisible(false);
                }
            });

            int count = 0;
            for (int h = 1; h != mainFrame.previous_objectarray_length; h++) {
                if (mainFrame.d[h].isSelected()) {
                    if (mainFrame.d[h].getText().contains(".mp3")) {
                        musicFrame.setResizable(false);
                        musicFrame.add(musicPanel);
                        musicPanel.add(stopMusic);
                        musicPanel.add(replayMusic);
                        musicPanel.add(forwardMusic);
                        musicPanel.add(backwardMusic);
                        musicPanel.add(closeMusic);
                        musicFrame.setLocation(500, 200);
                        musicPanel.repaint();
                        musicPanel.revalidate();
                        musicPanel.validate();
                        musicFrame.pack();
                        mainFrame.objectacl.setACLpublic(mainFrame.d[h].getText(), mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getEndpoint(), mainFrame.cred.getBucket());
                        String url = mainFrame.objectacl.setACLurl(mainFrame.d[h].getText(), mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getEndpoint(), mainFrame.cred.getBucket());
                        url = url.replace("Pre-Signed URL = ", "");
                        String test1[] = url.split("Expires=");
                        test1[0] = test1[0].replace("?", "");
                        music_url = (new URL(test1[0]));
                        mp3.addToPlayList(music_url);
                        count++;
                    }
                }
            }
            if (count > 0) {
                musicFrame.setVisible(true);
                musicFrame.setAlwaysOnTop(true);
            }

        } catch (Exception mp3player) {
            jTextArea1.append("\n" + mp3player.getMessage());
        }
        mainFrame.calibrateTextArea();

    }

    void startc() {
        (new Thread(new MusicPlayer(mainFrame))).start();
    }
}
