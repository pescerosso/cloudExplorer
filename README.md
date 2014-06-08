This is a simple, free, and open-source S3 client made by me as a fun, side project.  It works on Windows, Linux, and Mac.  Cloudian Explorer provides extras that are not found elsewhere in other S3 browsers like search for objects, music player, simple text editor, and image viewer.  It’s primary use is to demonstrate Cloudian’s S3 software, but it also works with Amazon’s S3 by simply changing the settings for host and credentials.  Users can easily sync folders to their S3 account and upload and download files to their computer.

![Browsing Objects](http://www.linux-toys.com/objects.png)

![Text Editor](http://www.linux-toys.com/editor.png)

![Streaming Music](http://linux-toys.com/music.png)


[Background Sync]

Background Sync allows Cloudian Explorer to function like Dropbox. It will sync to and from the S3 server. Please note that no files will be deleted. 
<br>
<br>
From the GUI: 
<br>
Click on "Background Syncing"
<br>
Click Configure
<br>
Click on a destination Directory
<br>
Click Save.
<br>
Click on "Background Syncing"
<br>
Click "Run".
<br>
Syncing will occur every 5 minutes.

<br>
Starting background sync from the Command Line (Useful for running as a background process):

Create your config file from the GUI.
<br>
$ java -jar CloudianExplorer.jar daemon
