package src.main.java.patterns.behavioral.observer;

/** Concrete observer: shows every price change. */
public class PriceBoard implements StockObserver {
    @Override
    public void onPriceChanged(String symbol, double oldPrice, double newPrice) {
        System.out.printf("  [Board] %s: %.2f -> %.2f%n", symbol, oldPrice, newPrice);
    }
}
