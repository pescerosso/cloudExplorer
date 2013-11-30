package s3;

import java.io.File;
import static s3.NewJFrame.jTextArea1;

public class SyncPutThread {

    NewJFrame foo;

    SyncPutThread(NewJFrame bar) {
        foo = bar;
    }

    public void run(String what) {
        File file = foo.jFileChooser2.getSelectedFile();
        String upload = (file.getAbsolutePath());
        String new_object_name = foo.convertObject(file.getAbsolutePath().toString(), "upload");
        foo.jTextField7.setText(foo.jTextField7.getText().replace("null", ""));
        jTextArea1.append("\n" + foo.Put.put(what, foo.Cred.getAccess_key(), foo.Cred.getSecret_key(), foo.Cred.getBucket(), foo.Cred.getEndpoint(), what));
        foo.jTextArea1.setCaretPosition(foo.jTextArea1.getSelectionEnd());
    }

}
