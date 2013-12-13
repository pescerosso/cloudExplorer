package s3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class Daemon {

    NewJFrame mainFrame;
    String Home = System.getProperty("user.home");
    String OS = System.getProperty("os.name");
    String slash = "/";
    String temp_file = (Home + "/object.tmp");
    String sync_config_file = Home + slash + "s3config.sync";
    String s3_config_file = Home + slash + "s3.config";
    Credentials cred = new Credentials();
    BucketClass bucket = new BucketClass();
    Delete delete = new Delete();
    Acl objectacl = new Acl();
    Get get = new Get();
    String[] bucketarray = null;
    String[] locationarray = null;
    String[] objectarray = null;
    String[] syncarray = null;
    String[] saved_s3_configs = null;
    String[] saved_directory_to_sync = null;
    File dirToSync = new File("");
    boolean gui = false;

    public Put put = new Put();

    void messageParser(String message) {
        if (gui) {
            mainFrame.jTextArea1.append(message);
        } else {
            System.out.print(message);
        }
    }

    boolean OScheck() {
        boolean result;
        result = !((OS.contains("windows")) || OS.contains("Windows"));
        return result;
    }

    void mainmenu() {
        if (!gui) {
            for (int i = 0; i != 20; i++) {
                messageParser("\n");
            }
            messageParser("\n------------------------------------------------");
            messageParser("\nCloudian Explorer is running in Daemon mode.");
            messageParser("\n------------------------------------------------");
        } else {
            messageParser("\n Backgrond Sync mode is running.....");
        }
    }

    void loadS3credentials() {
        try {
            for (String what : saved_s3_configs) {
                if (what == null) {
                    messageParser("\nError: an S3 config was null");
                    if (!gui) {
                        System.exit(-1);
                    }
                }
            }
            cred.setAccess_key(saved_s3_configs[0]);
            cred.setSecret_key(saved_s3_configs[1]);
            String endpoint = (saved_s3_configs[2] + ":" + saved_s3_configs[3]);
            cred.setEndpoint(endpoint);
            cred.setRegion(saved_s3_configs[4]);
        } catch (Exception loadS3Credentials) {
            messageParser("\n" + loadS3Credentials.getMessage());
        }
    }

    String loadConfig(String what) {
        String data = null;

        try {
            FileReader fr = new FileReader(what);
            BufferedReader bfr = new BufferedReader(fr);
            String read = null;

            while ((read = bfr.readLine()) != null) {
                data = data + read;
            }
        } catch (Exception loadConfig) {
        }
        String remove_null = data.replace("null", "");
        String remove_symbol = remove_null.replace("@", " ");
        return remove_symbol;
    }

    void start() {
        OScheck();
        if (!OScheck()) {
            //Needs testing on Windows
            sync_config_file = (Home + slash + "s3config.sync");
        }
        mainmenu();
        if (!gui) {
            messageParser("\n\nCloudian Explorer will perform a bidirectional \nsync on the directory listed in the config file:\n\n" + sync_config_file);
        }
        try {
            File s3config = new File(s3_config_file);
            if (s3config.exists()) {
            } else {
                messageParser("\nError: Sync config file not found.");
                if (!gui) {
                    System.exit(-1);
                }
            }

            File syncconfig = new File(sync_config_file);
            if (syncconfig.exists()) {
            } else {
                messageParser("\nError: Sync config file not found.");
                if (!gui) {
                    System.exit(-1);
                }
            }

            saved_s3_configs = cred.loadConfig().toString().split(" ");

            loadS3credentials();

            saved_directory_to_sync = loadConfig(sync_config_file).toString().split(" ");
            cred.setBucket(saved_directory_to_sync[1]);

            dirToSync = new File(saved_directory_to_sync[0]);

            File syncDIR = new File(saved_directory_to_sync[0]);
            if (syncDIR.exists()) {

                messageParser("\n\nDirectroy to sync: " + dirToSync.toString() + "  Bucket: " + cred.getBucket());

                new Thread(new Runnable() {
                    public void run() {
                        try {
                            reloadObjects();
                            SyncToS3(dirToSync);
                            syncFromS3(dirToSync.toString());
                            Thread.sleep(TimeUnit.MINUTES.toMillis(5));
                            if (gui) {
                                mainFrame.jTextArea1.setText("");
                            }
                            run();

                        } catch (InterruptedException e) {
                        }
                    }
                }).start();

            } else {
                messageParser("\nError: " + syncDIR.toString() + " does not exist");
            }
        } catch (Exception Start) {
            messageParser("\n" + Start.getMessage());
        }

    }

    String convertObject(String what, String operation) {

        if (!OScheck()) {
            if (what.contains("/")) {
                what = what.replace("/", "\\");
            }
        }

        if (OScheck()) {
            if (what.contains("\\")) {
                what = what.replace("\\", "/");
            }
        }

        int count = 0;
        int slash_counter = 0;
        String out_file = null;
        int another_counter = 0;

        for (int y = 0; y != what.length(); y++) {
            if (what.substring(y, y + 1).contains(slash)) {
                slash_counter++;
                another_counter = y;
            }
        }

        for (int y = 0; y != what.length(); y++) {
            if (y == another_counter) {
                if (operation.contains("download")) {
                    if (what.contains(slash)) {
                        out_file = (what.substring(y, what.length()));
                    } else {
                        out_file = (what);
                    }
                } else {
                    out_file = (what.substring(y + 1, what.length()));
                }
            }
        }
        return out_file;
    }

    void SyncToS3(File dir) {
        try {
            File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    SyncToS3(file);
                } else {
                    String simple_what = convertObject(file.getAbsolutePath(), "upload");

                    int found = 0;
                    for (int y = 1; y != objectarray.length; y++) {
                        if (objectarray[y].contains(simple_what)) {
                            messageParser("\nObject already exists on S3: " + simple_what);
                            found++;
                        }
                    }

                    if (found == 0) {
                        put.put(file.getAbsolutePath(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), simple_what);
                        found = 0;
                    }
                }
            }
        } catch (Exception Sync) {
            messageParser("\n" + Sync.getMessage());
        }
    }

    void syncFromS3(String Destination) {
        try {
            File[] foo = new File[objectarray.length];
            for (int i = 1; i != objectarray.length; i++) {
                String new_object_name = convertObject(objectarray[i], "download");
                foo[i] = new File(Destination + slash + new_object_name);
                if (foo[i].exists()) {
                    messageParser("\n" + new_object_name + " already exists on this machine.");
                } else {
                    get.get(objectarray[i], cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), Destination + slash + new_object_name);
                }
            }
        } catch (Exception SyncLocal) {
            messageParser("\n" + SyncLocal.getMessage());
        }
    }

    void reloadObjects() {
        try {
            String objectlist = bucket.listBucketContents(cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint());
            objectarray = objectlist.split("@");
        } catch (Exception reloadObjects) {
            messageParser("\n" + reloadObjects.getMessage());
        }
    }
}
