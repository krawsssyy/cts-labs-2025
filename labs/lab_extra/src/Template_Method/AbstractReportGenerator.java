package Template_Method;
/* - refactor the following code

public class ReportGenerator {
    private Integer id = 0;
    public String generateHtmlReport(String title, String data, String footer) {
        String text = "<html>\n\t<head>\n\t\t<title>" + title + "</title>\n\t</head>\n";
        text += "\t<body>\n\t\t" + data + "\n\t</body>\n";
        return text + footer + "\n</html>";
    }

    public String generateCsvReport(String title, String data, String footer) {
        String text = "ID, " + title;
        this.id += 1;
        text += this.id.toString() + "," + data;
        return text + "\n\n\n----FOOTER:" + footer;
    }
}
*/


public abstract class AbstractReportGenerator {
    // the template method pattern allows us to define the steps of a certain algorithm
    // allowing subclasses to define their own implementations, whilst still adhering to the given skeleton, without modifying it
    // ensure SRP and OCP are respected
    // use for example in java io for reading multiple bytes, where read with a single byte is called over and over again (and read is specific to each stream)
    // or in game engine loops (with each object doing its own update() and render() per frame)

    // abstract utilities that are used in the template method, to be implemented by each class
    public abstract String addHeader(String title);
    public abstract String addBody(String data);
    public abstract String addFooter(String footer);

    public final String generateReport(String title, String data, String footer) {
        // the template method
        return addHeader(title) + addBody(data) + addFooter(footer);
    }
}
