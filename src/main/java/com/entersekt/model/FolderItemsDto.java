package com.entersekt.model;

import java.util.*;

/**
 * Wrapper for folder content
 */
public class FolderItemsDto {

    private final List<FolderDto> folders = new ArrayList<>();
    private final List<FileDto> files = new ArrayList<>();


    /**
     * Sorts items in alphabetical order
     */
    public void sort () {
        synchronized (folders) {
            folders.sort(Comparator.comparing(FolderDto::getFolderPath));
        }
        synchronized (files) {
            files.sort(Comparator.comparing(FileDto::getFilePath));
        }
    }

    public void addFolder(FolderDto folder) {
        synchronized (folders) {
            folders.add(folder);
        }
    }

    public void addFile(FileDto file) {
        synchronized (files) {
            files.add(file);

        }
    }
}
