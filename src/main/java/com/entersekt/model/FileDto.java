package com.entersekt.model;

/**
 * Class representing a file item
 */
public class FileDto {

    public FileDto(String filePath, long bytes){
        this.filePath = filePath;
        this.bytes = bytes;
    }

    // Local variables
    private String filePath;
    private long bytes;

    // Public getters for json conversion
    public String getFilePath() {
        return filePath;
    }


}
