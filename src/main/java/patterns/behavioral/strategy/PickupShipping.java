package src.main.java.patterns.behavioral.strategy;

/** Customer collects the parcel from the store: no shipping cost. */
public class PickupShipping implements ShippingStrategy {
    @Override public double calculateCost(double weightKg) { return 0.0; }
    @Override public String name() { return "Store pickup"; }
}
