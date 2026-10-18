package patterns.structural.facade;

public class Main {
    public static void main(String[] args) {
        OrderFacade orders = new OrderFacade();

        tryOrder(orders, "alice", "LAPTOP", 1, 999.00);   // success
        tryOrder(orders, "bob", "MOUSE", 1, 25.00);       // out of stock
        tryOrder(orders, "carol", "LAPTOP", 4, 1500.00);  // payment declined ($6000)
        tryOrder(orders, "dave", "LAPTOP", 0, 999.00);    // invalid input
    }

    private static void tryOrder(OrderFacade orders, String customer, String sku, int qty, double price) {
        System.out.println("Order: " + customer + " wants " + qty + " x " + sku);
        try {
            String tracking = orders.placeOrder(customer, sku, qty, price);
            System.out.println("  -> order placed, tracking " + tracking);
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("  -> failed: " + e.getMessage());
        }
    }
}
