package Strategy;

/*class TextEditor {
    String text, type;
    public void setType(), formatText();
}*/

public class TextEditor {
    private String text;
    private IStrategy formattingStrategy = new HTMLStrategy(); // default

    public TextEditor(String text, IStrategy formattingStrategy) {
        this.text = text;
        this.formattingStrategy = formattingStrategy;
    }

    public TextEditor(String text) {
        this.text = text;
    }

    public void setFormattingStrategy(IStrategy formattingStrategy) {
        this.formattingStrategy = formattingStrategy;
    }

    public void formatText() { // same functionality, but achieved through different algorithms
        // with various degrees of variance
        System.out.println(this.formattingStrategy.formatText(this.text));
    }
}
