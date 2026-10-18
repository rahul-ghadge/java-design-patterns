package patterns.behavioral.strategy;

/** Strategy: an interchangeable algorithm for calculating shipping cost. */
public interface ShippingStrategy {
    /** @param weightKg total weight, always positive */
    double calculateCost(double weightKg);
    String name();
}
