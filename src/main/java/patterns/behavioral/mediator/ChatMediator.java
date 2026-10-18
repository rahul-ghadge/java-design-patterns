package src.main.java.patterns.behavioral.mediator;

/** Mediator: the only thing users talk to. */
public interface ChatMediator {
    void register(User user);
    void broadcast(User sender, String message);
    void sendPrivate(User sender, String recipientName, String message);
}
