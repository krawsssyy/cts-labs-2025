package Flyweight;

import java.io.*;

public class Texture {
    private String filePath;
    private Integer width;
    private Integer height;
    private byte[] textureData;

    public Texture(String filePath, Integer width, Integer height) throws IOException {
        this.filePath = filePath;
        this.width = width;
        this.height = height;

        this.textureData = new byte[width * height * 4];
        File fileIn = new File(this.filePath);
        if (!fileIn.isFile()) {
            System.out.println("Given file does not exist or is not a file!");
            return;
        }
        FileInputStream fileInputStr = new FileInputStream(fileIn);
        DataInputStream dataInputStr = new DataInputStream(fileInputStr);

        this.textureData = dataInputStr.readAllBytes();
    }

    public Integer getSizeInBytes() {
        return width * height * 4;
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

}
