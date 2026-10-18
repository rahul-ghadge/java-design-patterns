package src.main.java.patterns.structural.adapter;

public class Main {
    public static void main(String[] args) {
        // The client only knows about PaymentProcessor.
        PaymentProcessor processor = new LegacyGatewayAdapter(new LegacyCardGateway(), "tok_abc123");

        System.out.println("Paying order A-100 ($49.99)...");
        System.out.println("  success = " + processor.pay("A-100", 49.99));

        System.out.println("Paying order A-101 ($20,000.00)...");
        System.out.println("  success = " + processor.pay("A-101", 20_000.00));

        System.out.println("Paying order A-102 (-5.00)...");
        try {
            processor.pay("A-102", -5.00);
        } catch (IllegalArgumentException e) {
            System.out.println("  rejected: " + e.getMessage());
        }
    }
}
