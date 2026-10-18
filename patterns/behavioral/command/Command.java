package patterns.behavioral.command;

/** Command: an action packaged as an object, so it can be stored and undone. */
public interface Command {
    void execute();
    void undo();
    String describe();
}
