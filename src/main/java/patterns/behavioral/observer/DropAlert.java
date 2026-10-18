package src.main.java.patterns.behavioral.observer;

/** Concrete observer: only reacts when the price drops by more than a threshold. */
public class DropAlert implements StockObserver {
    private final double thresholdPercent;

    public DropAlert(double thresholdPercent) {
        if (thresholdPercent <= 0) throw new IllegalArgumentException("threshold must be positive");
        this.thresholdPercent = thresholdPercent;
    }

    @Override
    public void onPriceChanged(String symbol, double oldPrice, double newPrice) {
        double dropPercent = (oldPrice - newPrice) / oldPrice * 100;
        if (dropPercent >= thresholdPercent) {
            System.out.printf("  [ALERT] %s dropped %.1f%%!%n", symbol, dropPercent);
        }
    }
}
