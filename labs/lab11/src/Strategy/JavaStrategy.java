package Strategy;

public class JavaStrategy implements IStrategy {
    @Override
    public String formatText(String text) {
        return "public class Main {\n\tpublic static void main(String[] args) { \n\t\t" +
                text + "\n\t}\n}";
    }
}
