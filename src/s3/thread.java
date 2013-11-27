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

   
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
