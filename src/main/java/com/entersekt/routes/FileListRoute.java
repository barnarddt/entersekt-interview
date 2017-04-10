package com.entersekt.routes;

import com.entersekt.model.FileDto;
import com.entersekt.model.FolderDto;
import com.entersekt.model.FolderItemsDto;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Route that handles requests for file listings
 */
public class FileListRoute implements Route {
    private Gson gson = new Gson();
    @Override
    public Object handle(Request req, Response res) throws Exception {
        File folder = new File("/" + req.params(":path"));
        // Check File not found
        if (!folder.exists()) {
            res.status(404);
            return "Could not find file or directory: " + req.params(":path");
        }
        // Return single entry if the path leads to a file
        if (!folder.isDirectory())
            return gson.toJson(new FileDto(folder.getAbsolutePath(), folder.length()));

        List<File> files = Arrays.asList(folder.listFiles());
        FolderItemsDto items = new FolderItemsDto();

        // Add each item to the response container
        files.parallelStream().forEach((file) -> {
            if (file.isFile())
                items.addFile(new FileDto(file.getAbsolutePath(), file.length()));
            else if (file.isDirectory())
                items.addFolder(new FolderDto(file.getAbsolutePath()));
        });
        // Sort items alphabetically
        items.sort();
        return gson.toJson(items);
    }
}
