package com.entersekt.model;

/**
 * Data about a folder
 */
public class FolderDto {
    public FolderDto(String folderPath) {
        this.folderPath = folderPath;
    }

    // private variables
    private String folderPath;

    // public accesor for json conversion
    public String getFolderPath() {
        return folderPath;
    }
}
