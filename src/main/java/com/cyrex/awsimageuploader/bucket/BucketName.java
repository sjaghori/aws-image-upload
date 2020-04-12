package com.cyrex.awsimageuploader.bucket;

public enum BucketName {

    PROFILE_IMAGE("cyrex-image-upload");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }

}
