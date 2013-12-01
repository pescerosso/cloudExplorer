package s3;

public class ObjectListThread implements Runnable {
NewJFrame foo;

    ObjectListThread(NewJFrame bar) {
       foo = bar;
    }

    public void run() {
         foo.dialog("Gathering Objects..........");
        foo.reloadObjects(1);
        foo.dialog.setVisible(false);
    }

}
