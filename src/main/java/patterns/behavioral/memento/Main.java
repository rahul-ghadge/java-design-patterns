package src.main.java.patterns.behavioral.memento;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditHistory history = new EditHistory();

        history.push(editor.save());
        editor.type("Hello");
        System.out.println("After typing 'Hello'     : " + editor);

        history.push(editor.save());
        editor.type(" World");
        System.out.println("After typing ' World'    : " + editor);

        history.push(editor.save());
        editor.moveCursorTo(5);
        editor.type(",");
        System.out.println("After inserting ','      : " + editor);

        System.out.println("Undo 1                   : " + undo(editor, history));
        System.out.println("Undo 2                   : " + undo(editor, history));
        System.out.println("Undo 3                   : " + undo(editor, history));

        try {
            editor.restore(history.pop());
        } catch (IllegalStateException e) {
            System.out.println("Undo 4 failed            : " + e.getMessage());
        }
    }

    private static String undo(TextEditor editor, EditHistory history) {
        editor.restore(history.pop());
        return editor.toString();
    }
}
