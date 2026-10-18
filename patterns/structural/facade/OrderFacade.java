package patterns.structural.facade;

/**
 * Facade: one simple method hides the coordination of three subsystems.
 * Clients do not need to know the order of calls or how each service works.
 */
public class OrderFacade {
    private final InventoryService inventory = new InventoryService();
    private final PaymentService payment = new PaymentService();
    private final ShippingService shipping = new ShippingService();

    /** @return the tracking id of the shipment */
    public String placeOrder(String customerId, String sku, int quantity, double unitPrice) {
        if (customerId == null || customerId.isBlank()) throw new IllegalArgumentException("customerId required");
        if (quantity <= 0) throw new IllegalArgumentException("quantity must be positive");
        if (unitPrice <= 0) throw new IllegalArgumentException("unitPrice must be positive");

        if (!inventory.isAvailable(sku, quantity)) {
            throw new IllegalStateException("Out of stock: " + sku);
        }
        if (!payment.charge(customerId, quantity * unitPrice)) {
            throw new IllegalStateException("Payment declined for " + customerId);
        }
        inventory.reserve(sku, quantity);
        return shipping.ship(customerId, sku, quantity);
    }
}
