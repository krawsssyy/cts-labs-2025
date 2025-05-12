package Proxy;

import java.io.IOException;

public class ImageProxy implements ImageInterface { // implements the same interface to maintain common access
    private RealImage image;
    private String filename;
    private Boolean isSubscriber;
    // proxy class which  handles object creation

    public ImageProxy(String filename, Boolean isSubscriber) {
        this.filename = filename;
        this.isSubscriber = isSubscriber;
    }

    public void loadImage() throws IOException {
        this.image = new RealImage(this.filename);
    }
    @Override
    public void display() {
        if (this.image != null) {
            this.image.display();
        }
    }

    @Override
    public void resize(Integer width, Integer height) {
        if (this.image != null) {
            if (!this.isSubscriber) { // some access control mechanism
                System.out.println("[*] Available only for subcribers!");
                return; // fast-fail
            }
            this.image.resize(width, height);
        }
    }
}
