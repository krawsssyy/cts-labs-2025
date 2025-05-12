package Proxy;
import java.io.IOException;
import java.util.*;
public class ImageGallery {
    private List<ImageProxy> images = new ArrayList<>();

    public void add(String filename, Boolean isSubscriber) {
        this.images.add(new ImageProxy(filename, isSubscriber));
    }

    public void load(Integer idx) throws IOException {
        if(this.images.get(idx) != null) {
            this.images.get(idx).loadImage();
        }
    }

    public void display(Integer idx) {
        if(this.images.get(idx) != null) {
            this.images.get(idx).display();
        }
    }

    public void resize(Integer width, Integer height, Integer idx) {
        if(this.images.get(idx) != null) {
            this.images.get(idx).resize(width, height);
        }
    }
}
