package Strategy;

public class MarkdownStrategy implements IStrategy {
    @Override
    public String formatText(String text) {
        return "# - Title 1: Hello world\n" + text + "\n";
    }
}
