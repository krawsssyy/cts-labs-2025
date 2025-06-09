package Template_Method;

public class HtmlReportGenerator extends AbstractReportGenerator {
    @Override
    public String addHeader(String title) {
        return "<html>\n\t<head>\n\t\t<title>" + title + "</title>\n\t</head>\n";
    }

    @Override
    public String addBody(String data) {
        return "\t<body>\n\t\t" + data + "\n\t</body>\n";
    }

    @Override
    public String addFooter(String footer) {
        return footer + "\n</html>";
    }
}
