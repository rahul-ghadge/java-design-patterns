package patterns.behavioral.mediator;

/** Colleague: never references other users directly, only the mediator. */
public final class User {
    private final String name;
    private final ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        this.name = name;
        this.mediator = mediator;
        mediator.register(this);
    }

    public String getName() { return name; }

    public void say(String message) {
        System.out.println("  " + name + " says: " + message);
        mediator.broadcast(this, message);
    }

    public void whisper(String recipient, String message) {
        System.out.println("  " + name + " whispers to " + recipient + ": " + message);
        mediator.sendPrivate(this, recipient, message);
    }

    void receive(String from, String message) {
        System.out.println("      -> " + name + " received from " + from + ": " + message);
    }
}
