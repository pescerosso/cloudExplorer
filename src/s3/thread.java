/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s3;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static s3.NewJFrame.jPanel1;
import static s3.NewJFrame.jTextArea1;

/**
 *
 * @author ptribble
 */
class thread implements Runnable {

    private NewJFrame foo;

    public thread(NewJFrame bar) {
        foo = bar;
    }

    public void listObjects(int h) {
         foo.jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        foo.d[h] = new JCheckBox();
        foo.d[h].setText(foo.objectarray[h]);
        foo.jPanel1.add(foo.d[h]);
        foo.setLocation(h, 5);
        foo.jPanel1.revalidate();
        foo.validate();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
    }

    public void deleteObject(int h) {
       jTextArea1.append("\n" + foo.Delete.deleteFile(foo.d[h].getText(), foo.Cred.getAccess_key(), foo.Cred.getSecret_key(), foo.Cred.getBucket(), foo.Cred.getEndpoint()));
    }
    
    public void listBuckets(int h) {
        foo.jPanel5.setLayout(new BoxLayout(foo.jPanel5, BoxLayout.Y_AXIS));
        foo.b[h] = new JCheckBox();
        foo.b[h].setText(foo.bucketarray[h]);
        foo.jPanel5.add(foo.b[h]);
        foo.setLocation(h, 5);
        foo.jPanel5.revalidate();
        foo.validate();
    }

    public void get(int h) {

    }
public void put(String what) {
  jTextArea1.append("\n" + foo.Put.put(what, foo.Cred.getAccess_key(), foo.Cred.getSecret_key(), foo.Cred.getBucket(), foo.Cred.getEndpoint(), what));
    }

    public void saveFile(int h) {

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
