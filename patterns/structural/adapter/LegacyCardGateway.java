package patterns.structural.adapter;

/**
 * A third-party / legacy class we cannot (or should not) modify (the "Adaptee").
 * Its API is incompatible with {@link PaymentProcessor}: it works in cents
 * and needs a card token instead of an order id.
 */
public class LegacyCardGateway {
    public int makeCharge(int amountInCents, String cardToken) {
        System.out.println("  [LegacyCardGateway] charging " + amountInCents + " cents on token " + cardToken);
        // Legacy convention: 0 means success, anything else is an error code.
        return amountInCents <= 1_000_000 ? 0 : 99;
    }
}
