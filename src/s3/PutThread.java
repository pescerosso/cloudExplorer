package s3;

import java.io.File;
import static s3.NewJFrame.jTextArea1;

public class PutThread {

    NewJFrame mainFrame;

    PutThread(NewJFrame bar) {
        mainFrame = bar;
    }

    public void run() {
        mainFrame.dialog("Please wait for the upload operation to complete.");
        File file = mainFrame.jFileChooser1.getSelectedFile();
        String upload = (file.getAbsolutePath());
        String new_object_name = mainFrame.convertObject(file.getAbsolutePath().toString(), "upload");
        mainFrame.jTextField7.setText(mainFrame.jTextField7.getText().replace("null", ""));
        jTextArea1.append("\n" + mainFrame.put.put(upload, mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getBucket(), mainFrame.cred.getEndpoint(), mainFrame.jTextField7.getText() + new_object_name));
        mainFrame.jTextArea1.setCaretPosition(mainFrame.jTextArea1.getSelectionEnd());
        mainFrame.dialog.setVisible(false);
    }

}
