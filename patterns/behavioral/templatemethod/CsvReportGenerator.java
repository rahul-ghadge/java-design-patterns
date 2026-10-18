package patterns.behavioral.templatemethod;

public class CsvReportGenerator extends ReportGenerator {
    @Override protected String header(String title) { return "# " + title + "\nnumber,item\n"; }
    @Override protected String formatRow(int number, String row) { return number + "," + row + "\n"; }
    @Override protected String footer() { return ""; }
}
