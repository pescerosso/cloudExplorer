package cloudExplorer;

import static cloudExplorer.NewJFrame.jTextArea1;

public class ObjectProperties implements Runnable {

    NewJFrame mainFrame;

    public ObjectProperties(NewJFrame Frame) {
        mainFrame = Frame;

    }

    public void run() {
        try {
            for (int i = 1; i != mainFrame.previous_objectarray_length; i++) {

                if (mainFrame.object_item[i].isSelected()) {
                    jTextArea1.setText("\nFile Name: " + mainFrame.object_item[i].getText());
                    jTextArea1.append("\nSize: " + mainFrame.bucket.getObjectInfo(mainFrame.object_item[i].getText(), mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.bucket_item[mainFrame.active_bucket].getText(), mainFrame.cred.getEndpoint(), "objectsize") + " KB");
                    jTextArea1.append("\nModified Date: " + mainFrame.bucket.getObjectInfo(mainFrame.object_item[i].getText(), mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.bucket_item[mainFrame.active_bucket].getText(), mainFrame.cred.getEndpoint(), "objectdate"));
                    break;
                }
            }
        } catch (Exception ObjectACL) {
            jTextArea1.append("\n" + ObjectACL.getMessage() + "\n");
            mainFrame.calibrateTextArea();
        }
    }

    void startc() {
        (new Thread(new ObjectProperties(mainFrame))).start();
    }
}
