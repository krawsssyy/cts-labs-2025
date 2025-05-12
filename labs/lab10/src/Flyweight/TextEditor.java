package Flyweight;
import java.util.*;

public class TextEditor {
    private List<TextCharacter> chars = new ArrayList<>();
    private FormatFactory factory = new FormatFactory();

    public void add(Character symbol, String font, Integer size, Boolean isBold, Boolean isItalic, Boolean isUnderlined) {
        TextCharacter charVar = new TextCharacter(symbol, factory.getFormat(font, size, isBold, isItalic, isUnderlined));
        // use our factory to get the format
        // if the format was seen before, it is stored there and we can reuse it, instead of creating a different one, thus sharing resources
        // if it wasn't seen before, it is created and stored there for future sharing
        this.chars.add(charVar);
    }

    public void display() {
        for (Integer i = 0; i < this.chars.size(); i++) {
            this.chars.get(i).display(i);
        }
    }

    public TextCharacter getCharacter(Integer idx) {
        return this.chars.get(idx);
    }
}
