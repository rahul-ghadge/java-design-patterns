package src.main.java.patterns.behavioral.mediator;

import java.util.LinkedHashMap;
import java.util.Map;

/** Concrete mediator: knows all users and routes messages between them. */
public class ChatRoom implements ChatMediator {
    private final String roomName;
    private final Map<String, User> users = new LinkedHashMap<>();

    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public void register(User user) {
        if (users.containsKey(user.getName())) {
            throw new IllegalArgumentException("Name already taken in " + roomName + ": " + user.getName());
        }
        users.put(user.getName(), user);
        broadcastSystem(user.getName() + " joined #" + roomName);
    }

    @Override
    public void broadcast(User sender, String message) {
        requireMember(sender);
        for (User user : users.values()) {
            if (user != sender) {
                user.receive(sender.getName(), message);
            }
        }
    }

    @Override
    public void sendPrivate(User sender, String recipientName, String message) {
        requireMember(sender);
        User recipient = users.get(recipientName);
        if (recipient == null) {
            throw new IllegalArgumentException("No such user in #" + roomName + ": " + recipientName);
        }
        recipient.receive(sender.getName() + " (private)", message);
    }

    private void broadcastSystem(String message) {
        System.out.println("  [#" + roomName + "] " + message);
    }

    private void requireMember(User user) {
        if (users.get(user.getName()) != user) {
            throw new IllegalStateException(user.getName() + " is not in #" + roomName);
        }
    }
}
