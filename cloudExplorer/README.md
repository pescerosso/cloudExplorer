This is a simple, free, and open-source S3 client made by me. It works on Windows, Linux, and Mac.  Cloud Explorer provides extras that are not found elsewhere in other S3 browsers like search for objects, music player, simple text editor, and image viewer. Users can easily sync folders to their S3 account and upload and download files to their computer.



![Music Player](https://www.linux-toys.com/object.png)
![Editor](https://linux-toys.com/editor.png)

[Background Sync]

Background Sync allows Cloud Explorer to function like Dropbox. It will sync to and from the S3 server. Please note that no files will be deleted. 
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
$ java -jar -Xms100m -Xmx500m CloudExplorer.jar daemon
