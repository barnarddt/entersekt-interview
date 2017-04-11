# Overview
Interview question sent by entersekt : 
Write a small little cross platform program in Java 8 that exposes a RESTful interface on port
8080 and allows a client application to do only one thing: obtain the full directory listing of a
given directory path on the local filesystem. Include the full path, file size and attribute
information in the result and cater for a directory size of at least 1 000 000.

## Build instructions
1. In your command line go to root directory of the project.
2. run command: docker build -t entersekt/interview .
3. Wait for docker file to build (takes a while)
 

## Usage instructions
1. Run the container: docker run -d -p 8080:8080 entersekt/interview
2. Go to your browser and go to the url  httP://localhost:8080/files/{directory path} where the directory
path is the full path of the directory of which you want to see the content. Note the url escape for 
the / character is %2F and you need to use it in the url for all subdirectories of the ones in route i.e 
a valid request would look as follows http://localhost:8080/files/home%2Fbarnard%2FDownloads to see the 
contents of the download directory