package patterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        // Only set what you need; the call reads like a sentence.
        EmailMessage simple = EmailMessage.builder()
                .to("alice@example.com")
                .subject("Lunch?")
                .build();
        System.out.println(simple);

        EmailMessage detailed = EmailMessage.builder()
                .to("bob@example.com")
                .to("carol@example.com")
                .cc("manager@example.com")
                .subject("Server down")
                .body("The production server is not responding.")
                .highPriority()
                .build();
        System.out.println(detailed);

        System.out.println("Invalid inputs:");
        try {
            EmailMessage.builder().subject("No recipient").build();
        } catch (IllegalStateException e) {
            System.out.println("  Rejected: " + e.getMessage());
        }
        try {
            EmailMessage.builder().to("not-an-email");
        } catch (IllegalArgumentException e) {
            System.out.println("  Rejected: " + e.getMessage());
        }
    }
}
