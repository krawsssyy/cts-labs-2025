package Flyweight;

public class Format {
    private String font;
    private Integer size;
    private Boolean isBold, isItalic, isUnderlined;

    public Format(String font, Integer size, Boolean isBold, Boolean isItalic, Boolean isUnderlined) {
        this.font = font;
        this.size = size;
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.isUnderlined = isUnderlined;
    }

    public void display(Character symbol, Integer pos) { // passing extrinsic state as parameters
        System.out.println("[*] Character '" + symbol + "' at position " + pos + " has the following format: " +
                "font=" + this.font + ";size=" + this.size + ";bold=" + this.isBold + ";italic=" + this.isItalic +
                "underlined=" + this.isUnderlined);
    }
}
