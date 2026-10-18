package patterns.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/** Caretaker: stores snapshots, but cannot read or modify them. */
public class EditHistory {
    private final Deque<TextEditor.Snapshot> snapshots = new ArrayDeque<>();

    public void push(TextEditor.Snapshot snapshot) {
        snapshots.push(snapshot);
    }

    public TextEditor.Snapshot pop() {
        if (snapshots.isEmpty()) {
            throw new IllegalStateException("nothing to undo");
        }
        return snapshots.pop();
    }
}
