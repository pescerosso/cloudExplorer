package s3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class Daemon {

    NewJFrame mainFrame;
    String Home = System.getProperty("user.home");
    String OS = System.getProperty("os.name");
    String temp_file = (Home + File.separator + "object.tmp");
    String sync_config_file = Home + File.separator + "s3config.sync";
    String s3_config_file = Home + File.separator + "s3.config";
    BucketClass Bucket = new BucketClass();
    Acl objectacl = new Acl();
    Get get;
    Put put;
    String[] bucketarray = null;
    String[] locationarray = null;
    String[] objectarray = null;
    String[] syncarray = null;
    String[] saved_s3_configs = null;
    String[] saved_directory_to_sync = null;
    File dirToSync = new File("");
    String secret_key = null;
    String access_key = null;
    String endpoint = null;
    String bucket = null;
    String region = null;
    boolean gui = false;

    void messageParser(String message) {
        if (gui) {
            mainFrame.jTextArea1.append(message);
        } else {
            System.out.print(message);
        }
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
            messageParser("\nBackground Sync mode is running.....");
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

            access_key = saved_s3_configs[0];
            secret_key = saved_s3_configs[1];
            endpoint = saved_s3_configs[2] + ":" + saved_s3_configs[3];
            region = saved_s3_configs[4];
        } catch (Exception loadS3Credentials) {
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

        sync_config_file = (Home + File.separator + "s3config.sync");

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

            saved_s3_configs = loadConfig(this.s3_config_file).toString().split(" ");
            loadS3credentials();

            saved_directory_to_sync = loadConfig(sync_config_file).toString().split(" ");
            bucket = saved_directory_to_sync[1];

            dirToSync = new File(saved_directory_to_sync[0]);

            File syncDIR = new File(saved_directory_to_sync[0]);
            if (syncDIR.exists()) {

                messageParser("\n\nDirectroy to sync: " + dirToSync.toString() + "  Bucket: " + bucket);

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
        }

    }

    void makeDirectory(String what) {

        if (what.contains("/")) {
            what = what.replace("/", File.separator);
        }

        if (what.contains("\\")) {
            what = what.replace("\\", File.separator);
        }

        int slash_counter = 0;
        int another_counter = 0;

        for (int y = 0; y != what.length(); y++) {
            if (what.substring(y, y + 1).contains(File.separator)) {
                slash_counter++;
                another_counter = y;
            }
        }

        File dir = new File(what.substring(0, another_counter));
        dir.mkdirs();
    }

    void SyncToS3(File dir) {
        try {
            File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    File[] fileD = file.listFiles();
                    for (File files_in_directory : fileD) {
                        int found = 0;

                        for (int y = 1; y != objectarray.length; y++) {
                            if (objectarray[y].contains(files_in_directory.toString())) {
                                messageParser("\nObject already exists on S3: " + files_in_directory.toString());
                                found++;
                            }
                        }

                        if (found == 0) {
                            put = new Put(files_in_directory.getAbsolutePath(), access_key, secret_key, bucket, endpoint, files_in_directory.getAbsolutePath());
                            put.run();
                            found = 0;
                        }
                    }
                } else {

                    int found = 0;
                    for (int y = 1; y != objectarray.length; y++) {
                        if (objectarray[y].contains(file.getAbsolutePath().toString())) {
                            messageParser("\nObject already exists on S3: " + file.getAbsolutePath().toString());
                            found++;
                        }
                    }

                    if (found == 0) {
                        put = new Put(file.getAbsolutePath(), access_key, secret_key, bucket, endpoint, file.getAbsolutePath().toString());
                        put.run();

                        found = 0;
                    }
                }
            }
        } catch (Exception Sync) {
        }
    }

    String convertObject(String what, String operation) {

        if (what.contains("/")) {
            what = what.replace("/", File.separator);
        }

        if (what.contains("\\")) {
            what = what.replace("\\", File.separator);
        }
        return what;
    }

    void syncFromS3(String Destination) {
        try {
            File[] foo = new File[objectarray.length];
            for (int i = 1; i != objectarray.length; i++) {
                String new_object_name = convertObject(objectarray[i], "download");
                foo[i] = new File(Destination + new_object_name);
                if (foo[i].exists()) {
                    messageParser("\n" + new_object_name + " already exists on this machine.");
                } else {
                    makeDirectory(Destination + File.separator + objectarray[i]);
                    get = new Get(objectarray[i], access_key, secret_key, bucket, endpoint, Destination + new_object_name);
                    get.run();
                }
            }
        } catch (Exception SyncLocal) {
        }
    }

    void reloadObjects() {
        try {
            String objectlist = Bucket.listBucketContents(access_key, secret_key, bucket, endpoint);
            objectarray = objectlist.split("@@");
        } catch (Exception reloadObjects) {
        }
    }
}
