This is a simple, free, open-source S3 client made by me as a fun, side project.  It works on Windows, Linux, and Mac.  Cloudian Explorer provides extras that are not found elsewhere in other S3 browsers like search for objects, music player, simple text editor, and image viewer.  It’s primary use is to demonstrate Cloudian’s S3 software, but it also works with Amazon’s S3 by simply changing the settings for host and credentials.  Users can easily sync folders to their S3 account and upload and download files to their computer.

![Browsing Objects](http://www.linux-toys.com/wp-content/uploads/2013/11/objects.png)

![Text Editor](http://www.linux-toys.com/wp-content/uploads/2013/11/editor.png)

[Background Sync]

Background Sync allows Cloudian Explorer to function like Dropbox. It will sync to and from the S3 server. Please note that no files will be deleted. 

From the GUI: 

Click on "Background Syncing"
Click Configure
Click on a destination Directory
Click Save.

Click on "Background Syncing"
Click "Run".
Syncing will occur every 5 minutes.



From the Command Line (Useful for running as a background process)

Create your config file from the GUI.
# java -jar CloudianExplorer.jar daemon
