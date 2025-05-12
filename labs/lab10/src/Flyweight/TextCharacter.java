package Flyweight;
/*
code to refactor
-----------------------
class Character{
    char Symbol;
    String font;
    Integer size;
    Boolean isBold, isItalic, isUnderlined;
    public void display();
}

class TextEditor{
    List<Character> chars;
    public void add(), display();
}
-----------------------
*/


public class TextCharacter {
    private Character symbol; // extrinsic state - not shared
    private Format format; // intrinsic state - shared between instances

    public TextCharacter(Character symbol, Format format) {
        this.symbol = symbol;
        this.format = format;
    }

    public void display(Integer pos) {
        this.format.display(this.symbol, pos);
    }

    public Format returnFormat() { // auxiliary function to demonstrate that formats are shared
        return this.format;
    }
}
