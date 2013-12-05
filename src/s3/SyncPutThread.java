package s3;

import java.io.File;
import static s3.NewJFrame.jTextArea1;

public class SyncPutThread {

    NewJFrame mainFrame;

    SyncPutThread(NewJFrame frame) {
        mainFrame = frame;
    }

    public void run(String what) {
        File file = mainFrame.jFileChooser2.getSelectedFile();
        String upload = (file.getAbsolutePath());
        String new_object_name = mainFrame.convertObject(file.getAbsolutePath().toString(), "upload");
        mainFrame.jTextField7.setText(mainFrame.jTextField7.getText().replace("null", ""));
        jTextArea1.append("\n" + mainFrame.put.put(what, mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getBucket(), mainFrame.cred.getEndpoint(), what));
        mainFrame.jTextArea1.setCaretPosition(mainFrame.jTextArea1.getSelectionEnd());
    }

}
