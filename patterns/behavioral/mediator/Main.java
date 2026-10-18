package patterns.behavioral.mediator;

public class Main {
    public static void main(String[] args) {
        ChatMediator room = new ChatRoom("java-help");

        User alice = new User("Alice", room);
        User bob = new User("Bob", room);
        User carol = new User("Carol", room);

        alice.say("Does anyone know how Mediator works?");
        bob.whisper("Alice", "It is like a chat room - nobody talks directly.");

        System.out.println("Error handling:");
        try {
            carol.whisper("Zed", "Hello?");
        } catch (IllegalArgumentException e) {
            System.out.println("  " + e.getMessage());
        }
        try {
            new User("Bob", room);
        } catch (IllegalArgumentException e) {
            System.out.println("  " + e.getMessage());
        }
    }
}
