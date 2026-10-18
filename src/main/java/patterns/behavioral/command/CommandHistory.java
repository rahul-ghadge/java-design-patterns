package src.main.java.patterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

/** Invoker: runs commands and keeps a history to support undo. */
public class CommandHistory {
    private final Deque<Command> executed = new ArrayDeque<>();

    public void run(Command command) {
        command.execute();            // if this throws, the command is not recorded
        executed.push(command);
        System.out.println("  executed: " + command.describe());
    }

    public void undo() {
        if (executed.isEmpty()) {
            System.out.println("  nothing to undo");
            return;
        }
        Command command = executed.pop();
        command.undo();
        System.out.println("  undone:   " + command.describe());
    }
}
