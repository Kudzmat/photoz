package com.kudzbam.photoz.clone;

public class Photo {

    private String id;

    private String fileName;

    // empty contructor to avoid issues of converting java class to json
    public  Photo() {

    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    // raw data

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
