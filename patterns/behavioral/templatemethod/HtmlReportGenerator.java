package patterns.behavioral.templatemethod;

public class HtmlReportGenerator extends ReportGenerator {
    @Override protected String header(String title) { return "<h1>" + title + "</h1>\n<ol>\n"; }
    @Override protected String formatRow(int number, String row) { return "  <li>" + row + "</li>\n"; }
    @Override protected String footer() { return "</ol>\n"; }

    // override the hook to add an extra step
    @Override protected boolean includeSummary() { return true; }
    @Override protected String summary(int rowCount) { return "  <!-- total items: " + rowCount + " -->\n"; }
}
