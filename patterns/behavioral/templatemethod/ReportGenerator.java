package patterns.behavioral.templatemethod;

import java.util.List;

/**
 * Abstract class with the template method {@link #generate(String, List)}.
 * The ORDER of the steps is fixed here; subclasses supply the format-specific steps.
 */
public abstract class ReportGenerator {

    /** The template method: final, so subclasses cannot change the algorithm's skeleton. */
    public final String generate(String title, List<String> rows) {
        validate(title, rows);
        StringBuilder out = new StringBuilder();
        out.append(header(title));
        for (int i = 0; i < rows.size(); i++) {
            out.append(formatRow(i + 1, rows.get(i)));
        }
        if (includeSummary()) {                 // optional step controlled by a hook
            out.append(summary(rows.size()));
        }
        out.append(footer());
        return out.toString();
    }

    // ---- common step (same for all subclasses) ----
    private void validate(String title, List<String> rows) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title required");
        if (rows == null || rows.isEmpty()) throw new IllegalArgumentException("at least one row required");
    }

    // ---- steps subclasses MUST implement ----
    protected abstract String header(String title);
    protected abstract String formatRow(int number, String row);
    protected abstract String footer();

    // ---- hooks: subclasses MAY override ----
    protected boolean includeSummary() { return false; }
    protected String summary(int rowCount) { return ""; }
}
