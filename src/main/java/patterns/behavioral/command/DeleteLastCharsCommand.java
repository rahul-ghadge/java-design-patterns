package src.main.java.patterns.behavioral.command;

public class DeleteLastCharsCommand implements Command {
    private final TextDocument document;
    private final int count;
    private String deletedText = "";   // remembered so the command can be undone

    public DeleteLastCharsCommand(TextDocument document, int count) {
        if (count <= 0) throw new IllegalArgumentException("count must be positive: " + count);
        this.document = document;
        this.count = count;
    }

    @Override public void execute() { deletedText = document.removeLast(count); }
    @Override public void undo() { document.append(deletedText); }
    @Override public String describe() { return "delete last " + count + " chars"; }
}
