package s3;

import java.io.File;
import static s3.NewJFrame.jTextArea1;

public class PutThread {

    NewJFrame foo;

    PutThread(NewJFrame bar) {
        foo = bar;
    }

    public void run() {
        foo.dialog("Please wait for the upload operation to complete.");
        File file = foo.jFileChooser1.getSelectedFile();
        String upload = (file.getAbsolutePath());
        String new_object_name = foo.convertObject(file.getAbsolutePath().toString(), "upload");
        foo.jTextField7.setText(foo.jTextField7.getText().replace("null", ""));
        jTextArea1.append("\n" + foo.put.put(upload, foo.cred.getAccess_key(), foo.cred.getSecret_key(), foo.cred.getBucket(), foo.cred.getEndpoint(), foo.jTextField7.getText() + new_object_name));
        foo.jTextArea1.setCaretPosition(foo.jTextArea1.getSelectionEnd());
        foo.dialog.setVisible(false);
    }

}
