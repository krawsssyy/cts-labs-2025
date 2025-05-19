package Flyweight;
import java.io.IOException;
import java.util.*;

public class TextureFactory {
    public static Map<String, Texture> registry = new HashMap<>();

    public static Texture getTexture(String filePath, Integer width, Integer height) throws IOException {
        String key = filePath + "-" + width + "-" + height; // simple key creation

        if (registry.get(key) != null) {
            return registry.get(key);
        }

        Texture texture = new Texture(filePath, width, height);
        registry.put(key, texture);
        return texture;
    }
}