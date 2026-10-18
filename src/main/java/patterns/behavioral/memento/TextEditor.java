package src.main.java.patterns.behavioral.memento;

/**
 * Originator: creates snapshots of its own state and can restore from them.
 * The snapshot class is nested so that only the editor can read its contents -
 * the history (caretaker) just stores it without peeking inside.
 */
public class TextEditor {
    private String content = "";
    private int cursor = 0;

    public void type(String text) {
        if (text == null || text.isEmpty()) throw new IllegalArgumentException("text must not be empty");
        content = content.substring(0, cursor) + text + content.substring(cursor);
        cursor += text.length();
    }

    public void moveCursorTo(int position) {
        if (position < 0 || position > content.length()) {
            throw new IllegalArgumentException("cursor position out of range: " + position);
        }
        cursor = position;
    }

    public Snapshot save() {
        return new Snapshot(content, cursor);
    }

    public void restore(Snapshot snapshot) {
        if (snapshot == null) throw new IllegalArgumentException("snapshot must not be null");
        this.content = snapshot.content;
        this.cursor = snapshot.cursor;
    }

    @Override
    public String toString() {
        return "\"" + content.substring(0, cursor) + "|" + content.substring(cursor) + "\"";   // | marks the cursor
    }

    /** Memento: an immutable, opaque snapshot. */
    public static final class Snapshot {
        private final String content;
        private final int cursor;

        private Snapshot(String content, int cursor) {
            this.content = content;
            this.cursor = cursor;
        }
    }
}
