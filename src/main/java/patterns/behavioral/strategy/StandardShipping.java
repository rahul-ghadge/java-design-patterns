package src.main.java.patterns.behavioral.strategy;

public class StandardShipping implements ShippingStrategy {
    @Override public double calculateCost(double weightKg) { return 4.00 + 1.20 * weightKg; }
    @Override public String name() { return "Standard"; }
}
