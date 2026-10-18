package patterns.structural.facade;

/** Subsystem class #3: creates shipments. */
public class ShippingService {
    public String ship(String customerId, String sku, int quantity) {
        String trackingId = "TRK-" + Math.abs((customerId + sku).hashCode() % 100_000);
        System.out.println("  [Shipping] shipping " + quantity + " x " + sku + " to " + customerId + " (" + trackingId + ")");
        return trackingId;
    }
}
