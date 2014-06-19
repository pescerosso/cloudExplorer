package s3;

public class DeleteEverything implements Runnable {

    NewJFrame mainFrame;
    Delete del;
    Thread deleteEverything;
    ShowVersions showVersions;

    public DeleteEverything(NewJFrame Frame) {
        mainFrame = Frame;
    }

    public void run() {
        showVersions = new ShowVersions(null, mainFrame.cred.getAccess_key(), mainFrame.cred.getSecret_key(), mainFrame.cred.getBucket(), mainFrame.cred.getEndpoint(), mainFrame);
        showVersions.run();
    }

    public void startc(NewJFrame Frame) {
        deleteEverything = new Thread(new DeleteEverything(Frame));
        deleteEverything.start();
    }

}
