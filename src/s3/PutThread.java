package s3;

import java.io.File;
import static s3.NewJFrame.jTextArea1;

public class PutThread {

    NewJFrame foo;

    PutThread(NewJFrame bar) {
        foo = bar;
    }

    public void run() {
   File file =  foo.jFileChooser1.getSelectedFile();
            String upload = (file.getAbsolutePath());
            String new_object_name =  foo.convertObject(file.getAbsolutePath().toString(), "upload");
            foo.jTextField7.setText( foo.jTextField7.getText().replace("null", ""));
            jTextArea1.append("\n" +  foo.Put.put(upload,  foo.Cred.getAccess_key(),  foo.Cred.getSecret_key(),  foo.Cred.getBucket(),  foo.Cred.getEndpoint(),   foo.jTextField7.getText() + new_object_name));
    }

}
