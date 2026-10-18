package src.main.java.patterns.behavioral.state;

public class Main {
    public static void main(String[] args) {
        System.out.println("Happy path:");
        Order order = new Order("ORD-1");
        order.pay();
        order.ship();
        order.deliver();

        System.out.println("Cancel after payment:");
        Order second = new Order("ORD-2");
        second.pay();
        second.cancel();

        System.out.println("Illegal transitions:");
        attempt("ship an unpaid order", () -> new Order("ORD-3").ship());
        attempt("cancel a shipped order", () -> {
            Order o = new Order("ORD-4");
            o.pay();
            o.ship();
            o.cancel();
        });
        attempt("pay a cancelled order", second::pay);
    }

    private static void attempt(String description, Runnable action) {
        try {
            action.run();
        } catch (IllegalStateException e) {
            System.out.println("  Tried to " + description + " -> " + e.getMessage());
        }
    }
}
