package patterns.behavioral.templatemethod;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> tasks = List.of("Write code", "Run tests", "Deploy");

        System.out.println("--- CSV report ---");
        System.out.print(new CsvReportGenerator().generate("Sprint tasks", tasks));

        System.out.println("--- HTML report (with summary hook) ---");
        System.out.print(new HtmlReportGenerator().generate("Sprint tasks", tasks));

        System.out.println("--- Invalid input ---");
        try {
            new CsvReportGenerator().generate("Empty", List.of());
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
