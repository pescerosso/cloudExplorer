package s3;

import java.io.File;
import static s3.NewJFrame.jFileChooser2;
import static s3.NewJFrame.jTextArea1;

public class Daemon {

    String Home = System.getProperty("user.home");
    String OS = System.getProperty("os.name");
    String slash = "/";
    String temp_file = (Home + "/object.tmp");
    String config_file = Home + slash + "s3config.sync";
    Credentials cred = new Credentials();
    BucketClass bucket = new BucketClass();
    Delete delete = new Delete();
    Acl objectacl = new Acl();
    Get get = new Get();
    String[] bucketarray = null;
    String[] objectarray = null;

    public Put put = new Put();

    boolean OScheck() {
        boolean result;
        result = !((OS.contains("windows")) || OS.contains("Windows"));
        return result;
    }

    public void clearescreen() {
        for (int i = 0; i != 20; i++) {
            System.out.print("\n");
        }
    }

    public void mainmenu() {
        clearescreen();
        System.out.print("\n------------------------------------------------");
        System.out.print("\nCloudian Explorer is running in Daemon mode.");
        System.out.print("\n------------------------------------------------");
    }

    public void start() {
        OScheck();
        if (!OScheck()) {
            //Needs testing on Windows
            config_file = (Home + slash + "s3config.sync");
        }
        mainmenu();
        System.out.print("\n\nCloudian Explorer will perform a bidirectional \nsync on directories listed in the config file:\n\n" + config_file);
        
       //loadConfig();
       //load SyncConfig();
       //loadBuckets();
       //syncTO
        //syncFrom(
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
                            System.out.print("\nObject already exists on S3: " + simple_what);
                            found++;
                        }
                    }

                    if (found == 0) {
                        System.out.print("\n" + put.put(file.getAbsolutePath(), cred.getAccess_key(), cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), simple_what));
                        found = 0;
                    }
                }
            }
        } catch (Exception Sync) {
        }
    }

    public void syncFromS3() {
        try {
            File[] foo = new File[100000000];
            for (int i = 1; i != objectarray.length; i++) {
                String Destination = objectarray[i];
                String new_object_name = convertObject(objectarray[i], "download");
                foo[i] = new File(Destination + slash + new_object_name);
                if (foo[i].exists()) {
                    System.out.print("\n" + new_object_name + " already exists on this machine.");
                } else {
                    System.out.print("\n" + get.get(objectarray[i], cred.access_key, cred.getSecret_key(), cred.getBucket(), cred.getEndpoint(), Destination + slash + new_object_name));
                }
            }
        } catch (Exception SyncLocal) {
        }
    }
}
