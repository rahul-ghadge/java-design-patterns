package patterns.behavioral.visitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> cart = List.of(
                new Book("Effective Java", 45.00),
                new Electronics("Headphones", 120.00, 0.4),
                new Grocery("Coffee beans", 18.00));

        System.out.printf("Total tax     : $%.2f%n", sum(cart, new TaxVisitor()));
        System.out.printf("Total shipping: $%.2f%n", sum(cart, new ShippingVisitor()));

        System.out.println("Invalid item:");
        try {
            new Electronics("Broken", 10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Rejected: " + e.getMessage());
        }
    }

    private static double sum(List<Item> items, ItemVisitor<Double> visitor) {
        double total = 0;
        for (Item item : items) {
            total += item.accept(visitor);
        }
        return total;
    }
}
