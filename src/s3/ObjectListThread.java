package s3;

public class ObjectListThread implements Runnable {
NewJFrame foo;

    ObjectListThread(NewJFrame bar) {
       foo = bar;
    }

    

    public void run() {
        foo.reloadObjects();
    }

}
