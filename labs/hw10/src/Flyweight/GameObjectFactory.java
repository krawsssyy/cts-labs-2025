package Flyweight;
import java.io.IOException;
import java.util.*;

public class GameObjectFactory {
    public static Map<String, GameObject> registry = new HashMap<>();

    public static GameObject getGameObject(String filePath, Integer width, Integer height,
                                           String type, Integer x, Integer y, Float rotation,
                                           Integer health, Boolean isAnimated) throws IOException {
        String key = filePath + "-" + width + "-" + height + "-" + type + "-" + x + "-" + y + "-"
                + rotation + "-" + health + "-" + isAnimated; // simple key creation for gameobject

        if (registry.get(key) != null) {
            return registry.get(key);
        }

        GameObject obj = new GameObject(filePath, width, height, type, x, y, rotation, health, isAnimated);
        registry.put(key, obj);
        return obj;
    }
}