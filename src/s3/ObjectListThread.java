package s3;

public class ObjectListThread implements Runnable {
NewJFrame mainFrame;

    ObjectListThread(NewJFrame frame) {
       mainFrame = frame;
    }

    public void run() {
        mainFrame.dialog("Gathering Objects..........");
        mainFrame.reloadObjects();
        mainFrame.dialog.setVisible(false);
    }

}
