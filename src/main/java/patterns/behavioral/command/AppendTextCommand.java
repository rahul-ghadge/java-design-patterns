package src.main.java.patterns.behavioral.command;

public class AppendTextCommand implements Command {
    private final TextDocument document;
    private final String textToAppend;

    public AppendTextCommand(TextDocument document, String textToAppend) {
        if (textToAppend == null || textToAppend.isEmpty()) throw new IllegalArgumentException("text must not be empty");
        this.document = document;
        this.textToAppend = textToAppend;
    }

    @Override public void execute() { document.append(textToAppend); }
    @Override public void undo() { document.removeLast(textToAppend.length()); }
    @Override public String describe() { return "append \"" + textToAppend + "\""; }
}
