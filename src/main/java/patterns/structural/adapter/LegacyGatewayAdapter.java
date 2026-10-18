package src.main.java.patterns.structural.adapter;

/** Translates {@link PaymentProcessor} calls into {@link LegacyCardGateway} calls. */
public class LegacyGatewayAdapter implements PaymentProcessor {
    private final LegacyCardGateway gateway;
    private final String cardToken;

    public LegacyGatewayAdapter(LegacyCardGateway gateway, String cardToken) {
        if (gateway == null) {
            throw new IllegalArgumentException("gateway must not be null");
        }
        if (cardToken == null || cardToken.isBlank()) {
            throw new IllegalArgumentException("cardToken must not be blank");
        }
        this.gateway = gateway;
        this.cardToken = cardToken;
    }

    @Override
    public boolean pay(String orderId, double amountUsd) {
        if (amountUsd <= 0) {
            throw new IllegalArgumentException("amount must be positive: " + amountUsd);
        }
        int cents = (int) Math.round(amountUsd * 100);   // dollars -> cents
        int resultCode = gateway.makeCharge(cents, cardToken);
        return resultCode == 0;                          // legacy code -> boolean
    }
}
