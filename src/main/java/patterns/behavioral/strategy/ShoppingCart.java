package src.main.java.patterns.behavioral.strategy;

/** Context: uses whichever strategy it was given, and the strategy can be swapped at runtime. */
public final class ShoppingCart {
    private final double itemsTotal;
    private final double weightKg;
    private ShippingStrategy shipping;

    public ShoppingCart(double itemsTotal, double weightKg, ShippingStrategy shipping) {
        if (itemsTotal < 0) throw new IllegalArgumentException("itemsTotal must not be negative");
        if (weightKg <= 0) throw new IllegalArgumentException("weightKg must be positive");
        this.itemsTotal = itemsTotal;
        this.weightKg = weightKg;
        setShipping(shipping);
    }

    public void setShipping(ShippingStrategy shipping) {
        if (shipping == null) throw new IllegalArgumentException("shipping strategy required");
        this.shipping = shipping;
    }

    public double total() {
        return itemsTotal + shipping.calculateCost(weightKg);
    }

    public void printSummary() {
        System.out.printf("  Items $%.2f + %s shipping $%.2f = Total $%.2f%n",
                itemsTotal, shipping.name(), shipping.calculateCost(weightKg), total());
    }
}
