package patterns.structural.adapter;

/** The interface our application expects (the "Target"). */
public interface PaymentProcessor {
    /**
     * Charges the customer.
     *
     * @param orderId   identifier of the order being paid
     * @param amountUsd amount in US dollars, must be positive
     * @return true if the payment succeeded
     */
    boolean pay(String orderId, double amountUsd);
}
