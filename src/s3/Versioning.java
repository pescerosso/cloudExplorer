package s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.VersionListing;
import java.util.List;

public class Versioning {

    NewJFrame mainFrame;

    public Versioning(NewJFrame Frame) {
        mainFrame = Frame;
    }

    void getVersions(String key, String access_key, String secret_key, String bucket, String endpoint) {
        String results = null;
        try {

            AWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
            AmazonS3 s3Client = new AmazonS3Client(credentials);
            s3Client.setEndpoint(endpoint);
            VersionListing vListing = s3Client.listVersions(bucket, key);
            int i = 0;
            do {
                System.out.print("\n" + vListing.getVersionIdMarker());
                List<S3VersionSummary> summary = vListing.getVersionSummaries();

            } while (vListing.isTruncated());
            /**
             * for (S3VersionSummary foo : summary) {
             * mainFrame.versioning_array[i] = (foo.getKey() + ". Modified on: "
             * + foo.getLastModified() + " key=" + foo.getVersionId());
             * System.out.print("\n" + foo.getKey() + ". Modified on: " +
             * foo.getLastModified() + " key=" + foo.getVersionId()); results =
             * results.replace("null", ""); i++; }
                *
             */
            /**
             * do { objectListing = s3Client.listObjects(listObjectsRequest);
             * for (S3ObjectSummary objectSummary :
             * objectListing.getObjectSummaries()) { objectlist = objectlist +
             * "@@" + objectSummary.getKey(); }
             * listObjectsRequest.setMarker(objectListing.getNextMarker()); }
             * while (objectListing.isTruncated());
             *
             */
        } catch (Exception getVersions) {

        }

    }

}
