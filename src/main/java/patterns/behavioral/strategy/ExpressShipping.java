package src.main.java.patterns.behavioral.strategy;

public class ExpressShipping implements ShippingStrategy {
    @Override public double calculateCost(double weightKg) { return 12.00 + 3.00 * weightKg; }
    @Override public String name() { return "Express"; }
}
