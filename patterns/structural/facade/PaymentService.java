package patterns.structural.facade;

/** Subsystem class #2: charges the customer. */
public class PaymentService {
    public boolean charge(String customerId, double amount) {
        System.out.printf("  [Payment] charging %s $%.2f%n", customerId, amount);
        return amount < 5_000;   // pretend larger amounts are declined
    }
}
