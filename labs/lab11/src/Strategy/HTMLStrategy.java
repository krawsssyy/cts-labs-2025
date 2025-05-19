package Strategy;

public class HTMLStrategy implements IStrategy {
    @Override
    public String formatText(String text) {
        return "<html>\n\t<head>\n\t\t<title>\n\t\t\tHello World\n\t\t</title>\n\t</head>\n\t<body>\n\t\t"
                + text + "\n\t</body>\n</html>";
    }
}
