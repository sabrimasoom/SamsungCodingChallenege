package com.masoomsabri.samsungcodingchallenge.Model;

/**
 * Created by masoomsabri on 5/14/17.
 */

public class Category {
    private String mCategory;
    private String[] mFileNames;

    public Category(String category, String[] fileNames) {
        mCategory = category;
        mFileNames = fileNames;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String[] getFileNames() {
        return mFileNames;
    }

    public void setFileNames(String[] fileNames) {
        mFileNames = fileNames;
    }
}