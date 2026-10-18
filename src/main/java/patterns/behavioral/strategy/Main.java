package src.main.java.patterns.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(80.00, 2.5, new StandardShipping());
        cart.printSummary();

        cart.setShipping(new ExpressShipping());    // swap the algorithm at runtime
        cart.printSummary();

        cart.setShipping(new PickupShipping());
        cart.printSummary();

        // A one-off strategy can also be defined inline with an anonymous class
        cart.setShipping(new ShippingStrategy() {
            @Override public double calculateCost(double weightKg) { return 9.99; }
            @Override public String name() { return "Flat rate"; }
        });
        cart.printSummary();

        try {
            new ShoppingCart(10, 0, new StandardShipping());
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
