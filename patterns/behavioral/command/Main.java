package patterns.behavioral.command;

public class Main {
    public static void main(String[] args) {
        TextDocument doc = new TextDocument();
        CommandHistory history = new CommandHistory();

        history.run(new AppendTextCommand(doc, "Hello"));
        history.run(new AppendTextCommand(doc, ", World"));
        history.run(new DeleteLastCharsCommand(doc, 3));
        show(doc);

        history.undo();   // restores "rld"
        show(doc);
        history.undo();   // removes ", World"
        show(doc);
        history.undo();   // removes "Hello"
        show(doc);
        history.undo();   // nothing left

        try {
            history.run(new DeleteLastCharsCommand(doc, 10));
        } catch (IllegalArgumentException e) {
            System.out.println("  failed: " + e.getMessage());
        }
    }

    private static void show(TextDocument doc) {
        System.out.println("  text = \"" + doc.getText() + "\"");
    }
}
