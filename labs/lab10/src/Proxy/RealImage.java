package Proxy;
/*
code to refactor
--------------------
class Image{
     String filename;
     byte[] data;
     public void display(), resize();
}

class ImageGallery{
     List<Image> images;
     public void add();
     ---//---
}
--------------------
*/


import java.io.*;
import java.nio.file.Files;

public class RealImage implements ImageInterface {
    private String filename;
    private byte[] data;

    public RealImage(String filename) throws IOException {
        this.filename = filename;
        File fileIn = new File(this.filename);
        if (fileIn.isFile()) {
            System.out.println("[*] Found image file!");
            this.data = new byte[Math.toIntExact(fileIn.length())];
            this.data = Files.readAllBytes(fileIn.toPath());
        }
        else {
            System.out.println("[*] Didn't find image file!");
        }
    }
    @Override
    public void display() {
        System.out.println("[*] Displaying image with filename " + this.filename);
    }

    @Override
    public void resize(Integer width, Integer height) {
        System.out.println("[*] Resized image with filename " + this.filename + " to " +
                width + "x" + height);
    }
}
