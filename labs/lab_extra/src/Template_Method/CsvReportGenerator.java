package Template_Method;

public class CsvReportGenerator extends AbstractReportGenerator {
    private Integer id = 0;
    @Override
    public String addHeader(String title) {
        return "ID, " + title;
    }

    @Override
    public String addBody(String data) {
        this.id += 1;
        return this.id.toString() + "," + data;
    }

    @Override
    public String addFooter(String footer) {
        return "\n\n\n----FOOTER:" + footer;
    }
}
