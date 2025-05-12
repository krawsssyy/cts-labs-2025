package Flyweight;
import java.util.*;

public class FormatFactory {
    private Map<String, Format> registry = new HashMap<>();

    public Format getFormat(String font, Integer size, Boolean isBold, Boolean isItalic, Boolean isUnderlined) {
        String key = font + size + isBold + isItalic + isUnderlined; // simple key creation

        if (this.registry.get(key) != null) { // if the key exists, return the format stored for that key
            return this.registry.get(key);
        }
        // else, create a new format, save it in the registry and return it
        Format format = new Format(font, size, isBold, isItalic, isUnderlined);
        this.registry.put(key, format);
        return format;
    }
}
