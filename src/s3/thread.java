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

/**
 *
 * @author ptribble
 */
class thread implements Runnable {

    private NewJFrame foo;

    public thread(NewJFrame bar) {
        foo = bar;
    }

    public void run(int h) {
        foo.d[h] = new JCheckBox();
        foo.d[h].setText(foo.objectarray[h]);
        foo.jPanel1.add(foo.d[h]);
        foo.setLocation(h, 5);
        foo.jPanel1.revalidate();
        foo.validate();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
