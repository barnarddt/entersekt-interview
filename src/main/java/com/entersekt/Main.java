package com.entersekt;

import com.entersekt.routes.FileListRoute;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Main entry point for this service
 */
public class Main {

    public static void main(String [] args) {
        // Listen on Port  8080
        port(8080);
        // Define Routes
        get("/files/:path", new FileListRoute());
    }
}
